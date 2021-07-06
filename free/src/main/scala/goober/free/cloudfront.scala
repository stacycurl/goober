package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudfront.CloudFrontClient
import software.amazon.awssdk.services.cloudfront.model._


object cloudfront { module =>

  // Free monad over CloudFrontOp
  type CloudFrontIO[A] = FF[CloudFrontOp, A]

  sealed trait CloudFrontOp[A] {
    def visit[F[_]](visitor: CloudFrontOp.Visitor[F]): F[A]
  }

  object CloudFrontOp {
    // Given a CloudFrontClient we can embed a CloudFrontIO program in any algebra that understands embedding.
    implicit val CloudFrontOpEmbeddable: Embeddable[CloudFrontOp, CloudFrontClient] = new Embeddable[CloudFrontOp, CloudFrontClient] {
      def embed[A](client: CloudFrontClient, io: CloudFrontIO[A]): Embedded[A] = Embedded.CloudFront(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudFrontOp.Visitor[Kleisli[M, CloudFrontClient, *]] {
        def createCachePolicy(
          request: CreateCachePolicyRequest
        ): Kleisli[M, CloudFrontClient, CreateCachePolicyResponse] =
          primitive(_.createCachePolicy(request))

        def createCloudFrontOriginAccessIdentity(
          request: CreateCloudFrontOriginAccessIdentityRequest
        ): Kleisli[M, CloudFrontClient, CreateCloudFrontOriginAccessIdentityResponse] =
          primitive(_.createCloudFrontOriginAccessIdentity(request))

        def createDistribution(
          request: CreateDistributionRequest
        ): Kleisli[M, CloudFrontClient, CreateDistributionResponse] =
          primitive(_.createDistribution(request))

        def createDistributionWithTags(
          request: CreateDistributionWithTagsRequest
        ): Kleisli[M, CloudFrontClient, CreateDistributionWithTagsResponse] =
          primitive(_.createDistributionWithTags(request))

        def createFieldLevelEncryptionConfig(
          request: CreateFieldLevelEncryptionConfigRequest
        ): Kleisli[M, CloudFrontClient, CreateFieldLevelEncryptionConfigResponse] =
          primitive(_.createFieldLevelEncryptionConfig(request))

        def createFieldLevelEncryptionProfile(
          request: CreateFieldLevelEncryptionProfileRequest
        ): Kleisli[M, CloudFrontClient, CreateFieldLevelEncryptionProfileResponse] =
          primitive(_.createFieldLevelEncryptionProfile(request))

        def createFunction(
          request: CreateFunctionRequest
        ): Kleisli[M, CloudFrontClient, CreateFunctionResponse] =
          primitive(_.createFunction(request))

        def createInvalidation(
          request: CreateInvalidationRequest
        ): Kleisli[M, CloudFrontClient, CreateInvalidationResponse] =
          primitive(_.createInvalidation(request))

        def createKeyGroup(
          request: CreateKeyGroupRequest
        ): Kleisli[M, CloudFrontClient, CreateKeyGroupResponse] =
          primitive(_.createKeyGroup(request))

        def createMonitoringSubscription(
          request: CreateMonitoringSubscriptionRequest
        ): Kleisli[M, CloudFrontClient, CreateMonitoringSubscriptionResponse] =
          primitive(_.createMonitoringSubscription(request))

        def createOriginRequestPolicy(
          request: CreateOriginRequestPolicyRequest
        ): Kleisli[M, CloudFrontClient, CreateOriginRequestPolicyResponse] =
          primitive(_.createOriginRequestPolicy(request))

        def createPublicKey(
          request: CreatePublicKeyRequest
        ): Kleisli[M, CloudFrontClient, CreatePublicKeyResponse] =
          primitive(_.createPublicKey(request))

        def createRealtimeLogConfig(
          request: CreateRealtimeLogConfigRequest
        ): Kleisli[M, CloudFrontClient, CreateRealtimeLogConfigResponse] =
          primitive(_.createRealtimeLogConfig(request))

        def createStreamingDistribution(
          request: CreateStreamingDistributionRequest
        ): Kleisli[M, CloudFrontClient, CreateStreamingDistributionResponse] =
          primitive(_.createStreamingDistribution(request))

        def createStreamingDistributionWithTags(
          request: CreateStreamingDistributionWithTagsRequest
        ): Kleisli[M, CloudFrontClient, CreateStreamingDistributionWithTagsResponse] =
          primitive(_.createStreamingDistributionWithTags(request))

        def deleteCachePolicy(
          request: DeleteCachePolicyRequest
        ): Kleisli[M, CloudFrontClient, DeleteCachePolicyResponse] =
          primitive(_.deleteCachePolicy(request))

        def deleteCloudFrontOriginAccessIdentity(
          request: DeleteCloudFrontOriginAccessIdentityRequest
        ): Kleisli[M, CloudFrontClient, DeleteCloudFrontOriginAccessIdentityResponse] =
          primitive(_.deleteCloudFrontOriginAccessIdentity(request))

        def deleteDistribution(
          request: DeleteDistributionRequest
        ): Kleisli[M, CloudFrontClient, DeleteDistributionResponse] =
          primitive(_.deleteDistribution(request))

        def deleteFieldLevelEncryptionConfig(
          request: DeleteFieldLevelEncryptionConfigRequest
        ): Kleisli[M, CloudFrontClient, DeleteFieldLevelEncryptionConfigResponse] =
          primitive(_.deleteFieldLevelEncryptionConfig(request))

        def deleteFieldLevelEncryptionProfile(
          request: DeleteFieldLevelEncryptionProfileRequest
        ): Kleisli[M, CloudFrontClient, DeleteFieldLevelEncryptionProfileResponse] =
          primitive(_.deleteFieldLevelEncryptionProfile(request))

        def deleteFunction(
          request: DeleteFunctionRequest
        ): Kleisli[M, CloudFrontClient, DeleteFunctionResponse] =
          primitive(_.deleteFunction(request))

        def deleteKeyGroup(
          request: DeleteKeyGroupRequest
        ): Kleisli[M, CloudFrontClient, DeleteKeyGroupResponse] =
          primitive(_.deleteKeyGroup(request))

        def deleteMonitoringSubscription(
          request: DeleteMonitoringSubscriptionRequest
        ): Kleisli[M, CloudFrontClient, DeleteMonitoringSubscriptionResponse] =
          primitive(_.deleteMonitoringSubscription(request))

        def deleteOriginRequestPolicy(
          request: DeleteOriginRequestPolicyRequest
        ): Kleisli[M, CloudFrontClient, DeleteOriginRequestPolicyResponse] =
          primitive(_.deleteOriginRequestPolicy(request))

        def deletePublicKey(
          request: DeletePublicKeyRequest
        ): Kleisli[M, CloudFrontClient, DeletePublicKeyResponse] =
          primitive(_.deletePublicKey(request))

        def deleteRealtimeLogConfig(
          request: DeleteRealtimeLogConfigRequest
        ): Kleisli[M, CloudFrontClient, DeleteRealtimeLogConfigResponse] =
          primitive(_.deleteRealtimeLogConfig(request))

        def deleteStreamingDistribution(
          request: DeleteStreamingDistributionRequest
        ): Kleisli[M, CloudFrontClient, DeleteStreamingDistributionResponse] =
          primitive(_.deleteStreamingDistribution(request))

        def describeFunction(
          request: DescribeFunctionRequest
        ): Kleisli[M, CloudFrontClient, DescribeFunctionResponse] =
          primitive(_.describeFunction(request))

        def getCachePolicy(
          request: GetCachePolicyRequest
        ): Kleisli[M, CloudFrontClient, GetCachePolicyResponse] =
          primitive(_.getCachePolicy(request))

        def getCachePolicyConfig(
          request: GetCachePolicyConfigRequest
        ): Kleisli[M, CloudFrontClient, GetCachePolicyConfigResponse] =
          primitive(_.getCachePolicyConfig(request))

        def getCloudFrontOriginAccessIdentity(
          request: GetCloudFrontOriginAccessIdentityRequest
        ): Kleisli[M, CloudFrontClient, GetCloudFrontOriginAccessIdentityResponse] =
          primitive(_.getCloudFrontOriginAccessIdentity(request))

        def getCloudFrontOriginAccessIdentityConfig(
          request: GetCloudFrontOriginAccessIdentityConfigRequest
        ): Kleisli[M, CloudFrontClient, GetCloudFrontOriginAccessIdentityConfigResponse] =
          primitive(_.getCloudFrontOriginAccessIdentityConfig(request))

        def getDistribution(
          request: GetDistributionRequest
        ): Kleisli[M, CloudFrontClient, GetDistributionResponse] =
          primitive(_.getDistribution(request))

        def getDistributionConfig(
          request: GetDistributionConfigRequest
        ): Kleisli[M, CloudFrontClient, GetDistributionConfigResponse] =
          primitive(_.getDistributionConfig(request))

        def getFieldLevelEncryption(
          request: GetFieldLevelEncryptionRequest
        ): Kleisli[M, CloudFrontClient, GetFieldLevelEncryptionResponse] =
          primitive(_.getFieldLevelEncryption(request))

        def getFieldLevelEncryptionConfig(
          request: GetFieldLevelEncryptionConfigRequest
        ): Kleisli[M, CloudFrontClient, GetFieldLevelEncryptionConfigResponse] =
          primitive(_.getFieldLevelEncryptionConfig(request))

        def getFieldLevelEncryptionProfile(
          request: GetFieldLevelEncryptionProfileRequest
        ): Kleisli[M, CloudFrontClient, GetFieldLevelEncryptionProfileResponse] =
          primitive(_.getFieldLevelEncryptionProfile(request))

        def getFieldLevelEncryptionProfileConfig(
          request: GetFieldLevelEncryptionProfileConfigRequest
        ): Kleisli[M, CloudFrontClient, GetFieldLevelEncryptionProfileConfigResponse] =
          primitive(_.getFieldLevelEncryptionProfileConfig(request))

        def getFunction(
          request: GetFunctionRequest
        ): Kleisli[M, CloudFrontClient, GetFunctionResponse] =
          primitive(_.getFunction(request))

        def getInvalidation(
          request: GetInvalidationRequest
        ): Kleisli[M, CloudFrontClient, GetInvalidationResponse] =
          primitive(_.getInvalidation(request))

        def getKeyGroup(
          request: GetKeyGroupRequest
        ): Kleisli[M, CloudFrontClient, GetKeyGroupResponse] =
          primitive(_.getKeyGroup(request))

        def getKeyGroupConfig(
          request: GetKeyGroupConfigRequest
        ): Kleisli[M, CloudFrontClient, GetKeyGroupConfigResponse] =
          primitive(_.getKeyGroupConfig(request))

        def getMonitoringSubscription(
          request: GetMonitoringSubscriptionRequest
        ): Kleisli[M, CloudFrontClient, GetMonitoringSubscriptionResponse] =
          primitive(_.getMonitoringSubscription(request))

        def getOriginRequestPolicy(
          request: GetOriginRequestPolicyRequest
        ): Kleisli[M, CloudFrontClient, GetOriginRequestPolicyResponse] =
          primitive(_.getOriginRequestPolicy(request))

        def getOriginRequestPolicyConfig(
          request: GetOriginRequestPolicyConfigRequest
        ): Kleisli[M, CloudFrontClient, GetOriginRequestPolicyConfigResponse] =
          primitive(_.getOriginRequestPolicyConfig(request))

        def getPublicKey(
          request: GetPublicKeyRequest
        ): Kleisli[M, CloudFrontClient, GetPublicKeyResponse] =
          primitive(_.getPublicKey(request))

        def getPublicKeyConfig(
          request: GetPublicKeyConfigRequest
        ): Kleisli[M, CloudFrontClient, GetPublicKeyConfigResponse] =
          primitive(_.getPublicKeyConfig(request))

        def getRealtimeLogConfig(
          request: GetRealtimeLogConfigRequest
        ): Kleisli[M, CloudFrontClient, GetRealtimeLogConfigResponse] =
          primitive(_.getRealtimeLogConfig(request))

        def getStreamingDistribution(
          request: GetStreamingDistributionRequest
        ): Kleisli[M, CloudFrontClient, GetStreamingDistributionResponse] =
          primitive(_.getStreamingDistribution(request))

        def getStreamingDistributionConfig(
          request: GetStreamingDistributionConfigRequest
        ): Kleisli[M, CloudFrontClient, GetStreamingDistributionConfigResponse] =
          primitive(_.getStreamingDistributionConfig(request))

        def listCachePolicies(
          request: ListCachePoliciesRequest
        ): Kleisli[M, CloudFrontClient, ListCachePoliciesResponse] =
          primitive(_.listCachePolicies(request))

        def listCloudFrontOriginAccessIdentities(
          request: ListCloudFrontOriginAccessIdentitiesRequest
        ): Kleisli[M, CloudFrontClient, ListCloudFrontOriginAccessIdentitiesResponse] =
          primitive(_.listCloudFrontOriginAccessIdentities(request))

        def listDistributions(
          request: ListDistributionsRequest
        ): Kleisli[M, CloudFrontClient, ListDistributionsResponse] =
          primitive(_.listDistributions(request))

        def listDistributionsByCachePolicyId(
          request: ListDistributionsByCachePolicyIdRequest
        ): Kleisli[M, CloudFrontClient, ListDistributionsByCachePolicyIdResponse] =
          primitive(_.listDistributionsByCachePolicyId(request))

        def listDistributionsByKeyGroup(
          request: ListDistributionsByKeyGroupRequest
        ): Kleisli[M, CloudFrontClient, ListDistributionsByKeyGroupResponse] =
          primitive(_.listDistributionsByKeyGroup(request))

        def listDistributionsByOriginRequestPolicyId(
          request: ListDistributionsByOriginRequestPolicyIdRequest
        ): Kleisli[M, CloudFrontClient, ListDistributionsByOriginRequestPolicyIdResponse] =
          primitive(_.listDistributionsByOriginRequestPolicyId(request))

        def listDistributionsByRealtimeLogConfig(
          request: ListDistributionsByRealtimeLogConfigRequest
        ): Kleisli[M, CloudFrontClient, ListDistributionsByRealtimeLogConfigResponse] =
          primitive(_.listDistributionsByRealtimeLogConfig(request))

        def listDistributionsByWebACLId(
          request: ListDistributionsByWebAclIdRequest
        ): Kleisli[M, CloudFrontClient, ListDistributionsByWebAclIdResponse] =
          primitive(_.listDistributionsByWebACLId(request))

        def listFieldLevelEncryptionConfigs(
          request: ListFieldLevelEncryptionConfigsRequest
        ): Kleisli[M, CloudFrontClient, ListFieldLevelEncryptionConfigsResponse] =
          primitive(_.listFieldLevelEncryptionConfigs(request))

        def listFieldLevelEncryptionProfiles(
          request: ListFieldLevelEncryptionProfilesRequest
        ): Kleisli[M, CloudFrontClient, ListFieldLevelEncryptionProfilesResponse] =
          primitive(_.listFieldLevelEncryptionProfiles(request))

        def listFunctions(
          request: ListFunctionsRequest
        ): Kleisli[M, CloudFrontClient, ListFunctionsResponse] =
          primitive(_.listFunctions(request))

        def listInvalidations(
          request: ListInvalidationsRequest
        ): Kleisli[M, CloudFrontClient, ListInvalidationsResponse] =
          primitive(_.listInvalidations(request))

        def listKeyGroups(
          request: ListKeyGroupsRequest
        ): Kleisli[M, CloudFrontClient, ListKeyGroupsResponse] =
          primitive(_.listKeyGroups(request))

        def listOriginRequestPolicies(
          request: ListOriginRequestPoliciesRequest
        ): Kleisli[M, CloudFrontClient, ListOriginRequestPoliciesResponse] =
          primitive(_.listOriginRequestPolicies(request))

        def listPublicKeys(
          request: ListPublicKeysRequest
        ): Kleisli[M, CloudFrontClient, ListPublicKeysResponse] =
          primitive(_.listPublicKeys(request))

        def listRealtimeLogConfigs(
          request: ListRealtimeLogConfigsRequest
        ): Kleisli[M, CloudFrontClient, ListRealtimeLogConfigsResponse] =
          primitive(_.listRealtimeLogConfigs(request))

        def listStreamingDistributions(
          request: ListStreamingDistributionsRequest
        ): Kleisli[M, CloudFrontClient, ListStreamingDistributionsResponse] =
          primitive(_.listStreamingDistributions(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CloudFrontClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def publishFunction(
          request: PublishFunctionRequest
        ): Kleisli[M, CloudFrontClient, PublishFunctionResponse] =
          primitive(_.publishFunction(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CloudFrontClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testFunction(
          request: TestFunctionRequest
        ): Kleisli[M, CloudFrontClient, TestFunctionResponse] =
          primitive(_.testFunction(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CloudFrontClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateCachePolicy(
          request: UpdateCachePolicyRequest
        ): Kleisli[M, CloudFrontClient, UpdateCachePolicyResponse] =
          primitive(_.updateCachePolicy(request))

        def updateCloudFrontOriginAccessIdentity(
          request: UpdateCloudFrontOriginAccessIdentityRequest
        ): Kleisli[M, CloudFrontClient, UpdateCloudFrontOriginAccessIdentityResponse] =
          primitive(_.updateCloudFrontOriginAccessIdentity(request))

        def updateDistribution(
          request: UpdateDistributionRequest
        ): Kleisli[M, CloudFrontClient, UpdateDistributionResponse] =
          primitive(_.updateDistribution(request))

        def updateFieldLevelEncryptionConfig(
          request: UpdateFieldLevelEncryptionConfigRequest
        ): Kleisli[M, CloudFrontClient, UpdateFieldLevelEncryptionConfigResponse] =
          primitive(_.updateFieldLevelEncryptionConfig(request))

        def updateFieldLevelEncryptionProfile(
          request: UpdateFieldLevelEncryptionProfileRequest
        ): Kleisli[M, CloudFrontClient, UpdateFieldLevelEncryptionProfileResponse] =
          primitive(_.updateFieldLevelEncryptionProfile(request))

        def updateFunction(
          request: UpdateFunctionRequest
        ): Kleisli[M, CloudFrontClient, UpdateFunctionResponse] =
          primitive(_.updateFunction(request))

        def updateKeyGroup(
          request: UpdateKeyGroupRequest
        ): Kleisli[M, CloudFrontClient, UpdateKeyGroupResponse] =
          primitive(_.updateKeyGroup(request))

        def updateOriginRequestPolicy(
          request: UpdateOriginRequestPolicyRequest
        ): Kleisli[M, CloudFrontClient, UpdateOriginRequestPolicyResponse] =
          primitive(_.updateOriginRequestPolicy(request))

        def updatePublicKey(
          request: UpdatePublicKeyRequest
        ): Kleisli[M, CloudFrontClient, UpdatePublicKeyResponse] =
          primitive(_.updatePublicKey(request))

        def updateRealtimeLogConfig(
          request: UpdateRealtimeLogConfigRequest
        ): Kleisli[M, CloudFrontClient, UpdateRealtimeLogConfigResponse] =
          primitive(_.updateRealtimeLogConfig(request))

        def updateStreamingDistribution(
          request: UpdateStreamingDistributionRequest
        ): Kleisli[M, CloudFrontClient, UpdateStreamingDistributionResponse] =
          primitive(_.updateStreamingDistribution(request))

        def primitive[A](
          f: CloudFrontClient => A
        ): Kleisli[M, CloudFrontClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudFrontOp ~> F) {
      final def apply[A](op: CloudFrontOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createCachePolicy(
        request: CreateCachePolicyRequest
      ): F[CreateCachePolicyResponse]

      def createCloudFrontOriginAccessIdentity(
        request: CreateCloudFrontOriginAccessIdentityRequest
      ): F[CreateCloudFrontOriginAccessIdentityResponse]

      def createDistribution(
        request: CreateDistributionRequest
      ): F[CreateDistributionResponse]

      def createDistributionWithTags(
        request: CreateDistributionWithTagsRequest
      ): F[CreateDistributionWithTagsResponse]

      def createFieldLevelEncryptionConfig(
        request: CreateFieldLevelEncryptionConfigRequest
      ): F[CreateFieldLevelEncryptionConfigResponse]

      def createFieldLevelEncryptionProfile(
        request: CreateFieldLevelEncryptionProfileRequest
      ): F[CreateFieldLevelEncryptionProfileResponse]

      def createFunction(
        request: CreateFunctionRequest
      ): F[CreateFunctionResponse]

      def createInvalidation(
        request: CreateInvalidationRequest
      ): F[CreateInvalidationResponse]

      def createKeyGroup(
        request: CreateKeyGroupRequest
      ): F[CreateKeyGroupResponse]

      def createMonitoringSubscription(
        request: CreateMonitoringSubscriptionRequest
      ): F[CreateMonitoringSubscriptionResponse]

      def createOriginRequestPolicy(
        request: CreateOriginRequestPolicyRequest
      ): F[CreateOriginRequestPolicyResponse]

      def createPublicKey(
        request: CreatePublicKeyRequest
      ): F[CreatePublicKeyResponse]

      def createRealtimeLogConfig(
        request: CreateRealtimeLogConfigRequest
      ): F[CreateRealtimeLogConfigResponse]

      def createStreamingDistribution(
        request: CreateStreamingDistributionRequest
      ): F[CreateStreamingDistributionResponse]

      def createStreamingDistributionWithTags(
        request: CreateStreamingDistributionWithTagsRequest
      ): F[CreateStreamingDistributionWithTagsResponse]

      def deleteCachePolicy(
        request: DeleteCachePolicyRequest
      ): F[DeleteCachePolicyResponse]

      def deleteCloudFrontOriginAccessIdentity(
        request: DeleteCloudFrontOriginAccessIdentityRequest
      ): F[DeleteCloudFrontOriginAccessIdentityResponse]

      def deleteDistribution(
        request: DeleteDistributionRequest
      ): F[DeleteDistributionResponse]

      def deleteFieldLevelEncryptionConfig(
        request: DeleteFieldLevelEncryptionConfigRequest
      ): F[DeleteFieldLevelEncryptionConfigResponse]

      def deleteFieldLevelEncryptionProfile(
        request: DeleteFieldLevelEncryptionProfileRequest
      ): F[DeleteFieldLevelEncryptionProfileResponse]

      def deleteFunction(
        request: DeleteFunctionRequest
      ): F[DeleteFunctionResponse]

      def deleteKeyGroup(
        request: DeleteKeyGroupRequest
      ): F[DeleteKeyGroupResponse]

      def deleteMonitoringSubscription(
        request: DeleteMonitoringSubscriptionRequest
      ): F[DeleteMonitoringSubscriptionResponse]

      def deleteOriginRequestPolicy(
        request: DeleteOriginRequestPolicyRequest
      ): F[DeleteOriginRequestPolicyResponse]

      def deletePublicKey(
        request: DeletePublicKeyRequest
      ): F[DeletePublicKeyResponse]

      def deleteRealtimeLogConfig(
        request: DeleteRealtimeLogConfigRequest
      ): F[DeleteRealtimeLogConfigResponse]

      def deleteStreamingDistribution(
        request: DeleteStreamingDistributionRequest
      ): F[DeleteStreamingDistributionResponse]

      def describeFunction(
        request: DescribeFunctionRequest
      ): F[DescribeFunctionResponse]

      def getCachePolicy(
        request: GetCachePolicyRequest
      ): F[GetCachePolicyResponse]

      def getCachePolicyConfig(
        request: GetCachePolicyConfigRequest
      ): F[GetCachePolicyConfigResponse]

      def getCloudFrontOriginAccessIdentity(
        request: GetCloudFrontOriginAccessIdentityRequest
      ): F[GetCloudFrontOriginAccessIdentityResponse]

      def getCloudFrontOriginAccessIdentityConfig(
        request: GetCloudFrontOriginAccessIdentityConfigRequest
      ): F[GetCloudFrontOriginAccessIdentityConfigResponse]

      def getDistribution(
        request: GetDistributionRequest
      ): F[GetDistributionResponse]

      def getDistributionConfig(
        request: GetDistributionConfigRequest
      ): F[GetDistributionConfigResponse]

      def getFieldLevelEncryption(
        request: GetFieldLevelEncryptionRequest
      ): F[GetFieldLevelEncryptionResponse]

      def getFieldLevelEncryptionConfig(
        request: GetFieldLevelEncryptionConfigRequest
      ): F[GetFieldLevelEncryptionConfigResponse]

      def getFieldLevelEncryptionProfile(
        request: GetFieldLevelEncryptionProfileRequest
      ): F[GetFieldLevelEncryptionProfileResponse]

      def getFieldLevelEncryptionProfileConfig(
        request: GetFieldLevelEncryptionProfileConfigRequest
      ): F[GetFieldLevelEncryptionProfileConfigResponse]

      def getFunction(
        request: GetFunctionRequest
      ): F[GetFunctionResponse]

      def getInvalidation(
        request: GetInvalidationRequest
      ): F[GetInvalidationResponse]

      def getKeyGroup(
        request: GetKeyGroupRequest
      ): F[GetKeyGroupResponse]

      def getKeyGroupConfig(
        request: GetKeyGroupConfigRequest
      ): F[GetKeyGroupConfigResponse]

      def getMonitoringSubscription(
        request: GetMonitoringSubscriptionRequest
      ): F[GetMonitoringSubscriptionResponse]

      def getOriginRequestPolicy(
        request: GetOriginRequestPolicyRequest
      ): F[GetOriginRequestPolicyResponse]

      def getOriginRequestPolicyConfig(
        request: GetOriginRequestPolicyConfigRequest
      ): F[GetOriginRequestPolicyConfigResponse]

      def getPublicKey(
        request: GetPublicKeyRequest
      ): F[GetPublicKeyResponse]

      def getPublicKeyConfig(
        request: GetPublicKeyConfigRequest
      ): F[GetPublicKeyConfigResponse]

      def getRealtimeLogConfig(
        request: GetRealtimeLogConfigRequest
      ): F[GetRealtimeLogConfigResponse]

      def getStreamingDistribution(
        request: GetStreamingDistributionRequest
      ): F[GetStreamingDistributionResponse]

      def getStreamingDistributionConfig(
        request: GetStreamingDistributionConfigRequest
      ): F[GetStreamingDistributionConfigResponse]

      def listCachePolicies(
        request: ListCachePoliciesRequest
      ): F[ListCachePoliciesResponse]

      def listCloudFrontOriginAccessIdentities(
        request: ListCloudFrontOriginAccessIdentitiesRequest
      ): F[ListCloudFrontOriginAccessIdentitiesResponse]

      def listDistributions(
        request: ListDistributionsRequest
      ): F[ListDistributionsResponse]

      def listDistributionsByCachePolicyId(
        request: ListDistributionsByCachePolicyIdRequest
      ): F[ListDistributionsByCachePolicyIdResponse]

      def listDistributionsByKeyGroup(
        request: ListDistributionsByKeyGroupRequest
      ): F[ListDistributionsByKeyGroupResponse]

      def listDistributionsByOriginRequestPolicyId(
        request: ListDistributionsByOriginRequestPolicyIdRequest
      ): F[ListDistributionsByOriginRequestPolicyIdResponse]

      def listDistributionsByRealtimeLogConfig(
        request: ListDistributionsByRealtimeLogConfigRequest
      ): F[ListDistributionsByRealtimeLogConfigResponse]

      def listDistributionsByWebACLId(
        request: ListDistributionsByWebAclIdRequest
      ): F[ListDistributionsByWebAclIdResponse]

      def listFieldLevelEncryptionConfigs(
        request: ListFieldLevelEncryptionConfigsRequest
      ): F[ListFieldLevelEncryptionConfigsResponse]

      def listFieldLevelEncryptionProfiles(
        request: ListFieldLevelEncryptionProfilesRequest
      ): F[ListFieldLevelEncryptionProfilesResponse]

      def listFunctions(
        request: ListFunctionsRequest
      ): F[ListFunctionsResponse]

      def listInvalidations(
        request: ListInvalidationsRequest
      ): F[ListInvalidationsResponse]

      def listKeyGroups(
        request: ListKeyGroupsRequest
      ): F[ListKeyGroupsResponse]

      def listOriginRequestPolicies(
        request: ListOriginRequestPoliciesRequest
      ): F[ListOriginRequestPoliciesResponse]

      def listPublicKeys(
        request: ListPublicKeysRequest
      ): F[ListPublicKeysResponse]

      def listRealtimeLogConfigs(
        request: ListRealtimeLogConfigsRequest
      ): F[ListRealtimeLogConfigsResponse]

      def listStreamingDistributions(
        request: ListStreamingDistributionsRequest
      ): F[ListStreamingDistributionsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def publishFunction(
        request: PublishFunctionRequest
      ): F[PublishFunctionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testFunction(
        request: TestFunctionRequest
      ): F[TestFunctionResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateCachePolicy(
        request: UpdateCachePolicyRequest
      ): F[UpdateCachePolicyResponse]

      def updateCloudFrontOriginAccessIdentity(
        request: UpdateCloudFrontOriginAccessIdentityRequest
      ): F[UpdateCloudFrontOriginAccessIdentityResponse]

      def updateDistribution(
        request: UpdateDistributionRequest
      ): F[UpdateDistributionResponse]

      def updateFieldLevelEncryptionConfig(
        request: UpdateFieldLevelEncryptionConfigRequest
      ): F[UpdateFieldLevelEncryptionConfigResponse]

      def updateFieldLevelEncryptionProfile(
        request: UpdateFieldLevelEncryptionProfileRequest
      ): F[UpdateFieldLevelEncryptionProfileResponse]

      def updateFunction(
        request: UpdateFunctionRequest
      ): F[UpdateFunctionResponse]

      def updateKeyGroup(
        request: UpdateKeyGroupRequest
      ): F[UpdateKeyGroupResponse]

      def updateOriginRequestPolicy(
        request: UpdateOriginRequestPolicyRequest
      ): F[UpdateOriginRequestPolicyResponse]

      def updatePublicKey(
        request: UpdatePublicKeyRequest
      ): F[UpdatePublicKeyResponse]

      def updateRealtimeLogConfig(
        request: UpdateRealtimeLogConfigRequest
      ): F[UpdateRealtimeLogConfigResponse]

      def updateStreamingDistribution(
        request: UpdateStreamingDistributionRequest
      ): F[UpdateStreamingDistributionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudFrontOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateCachePolicyOp(
      request: CreateCachePolicyRequest
    ) extends CloudFrontOp[CreateCachePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCachePolicyResponse] =
        visitor.createCachePolicy(request)
    }

    final case class CreateCloudFrontOriginAccessIdentityOp(
      request: CreateCloudFrontOriginAccessIdentityRequest
    ) extends CloudFrontOp[CreateCloudFrontOriginAccessIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCloudFrontOriginAccessIdentityResponse] =
        visitor.createCloudFrontOriginAccessIdentity(request)
    }

    final case class CreateDistributionOp(
      request: CreateDistributionRequest
    ) extends CloudFrontOp[CreateDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDistributionResponse] =
        visitor.createDistribution(request)
    }

    final case class CreateDistributionWithTagsOp(
      request: CreateDistributionWithTagsRequest
    ) extends CloudFrontOp[CreateDistributionWithTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDistributionWithTagsResponse] =
        visitor.createDistributionWithTags(request)
    }

    final case class CreateFieldLevelEncryptionConfigOp(
      request: CreateFieldLevelEncryptionConfigRequest
    ) extends CloudFrontOp[CreateFieldLevelEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFieldLevelEncryptionConfigResponse] =
        visitor.createFieldLevelEncryptionConfig(request)
    }

    final case class CreateFieldLevelEncryptionProfileOp(
      request: CreateFieldLevelEncryptionProfileRequest
    ) extends CloudFrontOp[CreateFieldLevelEncryptionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFieldLevelEncryptionProfileResponse] =
        visitor.createFieldLevelEncryptionProfile(request)
    }

    final case class CreateFunctionOp(
      request: CreateFunctionRequest
    ) extends CloudFrontOp[CreateFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFunctionResponse] =
        visitor.createFunction(request)
    }

    final case class CreateInvalidationOp(
      request: CreateInvalidationRequest
    ) extends CloudFrontOp[CreateInvalidationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInvalidationResponse] =
        visitor.createInvalidation(request)
    }

    final case class CreateKeyGroupOp(
      request: CreateKeyGroupRequest
    ) extends CloudFrontOp[CreateKeyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateKeyGroupResponse] =
        visitor.createKeyGroup(request)
    }

    final case class CreateMonitoringSubscriptionOp(
      request: CreateMonitoringSubscriptionRequest
    ) extends CloudFrontOp[CreateMonitoringSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMonitoringSubscriptionResponse] =
        visitor.createMonitoringSubscription(request)
    }

    final case class CreateOriginRequestPolicyOp(
      request: CreateOriginRequestPolicyRequest
    ) extends CloudFrontOp[CreateOriginRequestPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOriginRequestPolicyResponse] =
        visitor.createOriginRequestPolicy(request)
    }

    final case class CreatePublicKeyOp(
      request: CreatePublicKeyRequest
    ) extends CloudFrontOp[CreatePublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePublicKeyResponse] =
        visitor.createPublicKey(request)
    }

    final case class CreateRealtimeLogConfigOp(
      request: CreateRealtimeLogConfigRequest
    ) extends CloudFrontOp[CreateRealtimeLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRealtimeLogConfigResponse] =
        visitor.createRealtimeLogConfig(request)
    }

    final case class CreateStreamingDistributionOp(
      request: CreateStreamingDistributionRequest
    ) extends CloudFrontOp[CreateStreamingDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamingDistributionResponse] =
        visitor.createStreamingDistribution(request)
    }

    final case class CreateStreamingDistributionWithTagsOp(
      request: CreateStreamingDistributionWithTagsRequest
    ) extends CloudFrontOp[CreateStreamingDistributionWithTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamingDistributionWithTagsResponse] =
        visitor.createStreamingDistributionWithTags(request)
    }

    final case class DeleteCachePolicyOp(
      request: DeleteCachePolicyRequest
    ) extends CloudFrontOp[DeleteCachePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCachePolicyResponse] =
        visitor.deleteCachePolicy(request)
    }

    final case class DeleteCloudFrontOriginAccessIdentityOp(
      request: DeleteCloudFrontOriginAccessIdentityRequest
    ) extends CloudFrontOp[DeleteCloudFrontOriginAccessIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCloudFrontOriginAccessIdentityResponse] =
        visitor.deleteCloudFrontOriginAccessIdentity(request)
    }

    final case class DeleteDistributionOp(
      request: DeleteDistributionRequest
    ) extends CloudFrontOp[DeleteDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDistributionResponse] =
        visitor.deleteDistribution(request)
    }

    final case class DeleteFieldLevelEncryptionConfigOp(
      request: DeleteFieldLevelEncryptionConfigRequest
    ) extends CloudFrontOp[DeleteFieldLevelEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFieldLevelEncryptionConfigResponse] =
        visitor.deleteFieldLevelEncryptionConfig(request)
    }

    final case class DeleteFieldLevelEncryptionProfileOp(
      request: DeleteFieldLevelEncryptionProfileRequest
    ) extends CloudFrontOp[DeleteFieldLevelEncryptionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFieldLevelEncryptionProfileResponse] =
        visitor.deleteFieldLevelEncryptionProfile(request)
    }

    final case class DeleteFunctionOp(
      request: DeleteFunctionRequest
    ) extends CloudFrontOp[DeleteFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionResponse] =
        visitor.deleteFunction(request)
    }

    final case class DeleteKeyGroupOp(
      request: DeleteKeyGroupRequest
    ) extends CloudFrontOp[DeleteKeyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteKeyGroupResponse] =
        visitor.deleteKeyGroup(request)
    }

    final case class DeleteMonitoringSubscriptionOp(
      request: DeleteMonitoringSubscriptionRequest
    ) extends CloudFrontOp[DeleteMonitoringSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMonitoringSubscriptionResponse] =
        visitor.deleteMonitoringSubscription(request)
    }

    final case class DeleteOriginRequestPolicyOp(
      request: DeleteOriginRequestPolicyRequest
    ) extends CloudFrontOp[DeleteOriginRequestPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOriginRequestPolicyResponse] =
        visitor.deleteOriginRequestPolicy(request)
    }

    final case class DeletePublicKeyOp(
      request: DeletePublicKeyRequest
    ) extends CloudFrontOp[DeletePublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePublicKeyResponse] =
        visitor.deletePublicKey(request)
    }

    final case class DeleteRealtimeLogConfigOp(
      request: DeleteRealtimeLogConfigRequest
    ) extends CloudFrontOp[DeleteRealtimeLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRealtimeLogConfigResponse] =
        visitor.deleteRealtimeLogConfig(request)
    }

    final case class DeleteStreamingDistributionOp(
      request: DeleteStreamingDistributionRequest
    ) extends CloudFrontOp[DeleteStreamingDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamingDistributionResponse] =
        visitor.deleteStreamingDistribution(request)
    }

    final case class DescribeFunctionOp(
      request: DescribeFunctionRequest
    ) extends CloudFrontOp[DescribeFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFunctionResponse] =
        visitor.describeFunction(request)
    }

    final case class GetCachePolicyOp(
      request: GetCachePolicyRequest
    ) extends CloudFrontOp[GetCachePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCachePolicyResponse] =
        visitor.getCachePolicy(request)
    }

    final case class GetCachePolicyConfigOp(
      request: GetCachePolicyConfigRequest
    ) extends CloudFrontOp[GetCachePolicyConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCachePolicyConfigResponse] =
        visitor.getCachePolicyConfig(request)
    }

    final case class GetCloudFrontOriginAccessIdentityOp(
      request: GetCloudFrontOriginAccessIdentityRequest
    ) extends CloudFrontOp[GetCloudFrontOriginAccessIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCloudFrontOriginAccessIdentityResponse] =
        visitor.getCloudFrontOriginAccessIdentity(request)
    }

    final case class GetCloudFrontOriginAccessIdentityConfigOp(
      request: GetCloudFrontOriginAccessIdentityConfigRequest
    ) extends CloudFrontOp[GetCloudFrontOriginAccessIdentityConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCloudFrontOriginAccessIdentityConfigResponse] =
        visitor.getCloudFrontOriginAccessIdentityConfig(request)
    }

    final case class GetDistributionOp(
      request: GetDistributionRequest
    ) extends CloudFrontOp[GetDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionResponse] =
        visitor.getDistribution(request)
    }

    final case class GetDistributionConfigOp(
      request: GetDistributionConfigRequest
    ) extends CloudFrontOp[GetDistributionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDistributionConfigResponse] =
        visitor.getDistributionConfig(request)
    }

    final case class GetFieldLevelEncryptionOp(
      request: GetFieldLevelEncryptionRequest
    ) extends CloudFrontOp[GetFieldLevelEncryptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFieldLevelEncryptionResponse] =
        visitor.getFieldLevelEncryption(request)
    }

    final case class GetFieldLevelEncryptionConfigOp(
      request: GetFieldLevelEncryptionConfigRequest
    ) extends CloudFrontOp[GetFieldLevelEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFieldLevelEncryptionConfigResponse] =
        visitor.getFieldLevelEncryptionConfig(request)
    }

    final case class GetFieldLevelEncryptionProfileOp(
      request: GetFieldLevelEncryptionProfileRequest
    ) extends CloudFrontOp[GetFieldLevelEncryptionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFieldLevelEncryptionProfileResponse] =
        visitor.getFieldLevelEncryptionProfile(request)
    }

    final case class GetFieldLevelEncryptionProfileConfigOp(
      request: GetFieldLevelEncryptionProfileConfigRequest
    ) extends CloudFrontOp[GetFieldLevelEncryptionProfileConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFieldLevelEncryptionProfileConfigResponse] =
        visitor.getFieldLevelEncryptionProfileConfig(request)
    }

    final case class GetFunctionOp(
      request: GetFunctionRequest
    ) extends CloudFrontOp[GetFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionResponse] =
        visitor.getFunction(request)
    }

    final case class GetInvalidationOp(
      request: GetInvalidationRequest
    ) extends CloudFrontOp[GetInvalidationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInvalidationResponse] =
        visitor.getInvalidation(request)
    }

    final case class GetKeyGroupOp(
      request: GetKeyGroupRequest
    ) extends CloudFrontOp[GetKeyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKeyGroupResponse] =
        visitor.getKeyGroup(request)
    }

    final case class GetKeyGroupConfigOp(
      request: GetKeyGroupConfigRequest
    ) extends CloudFrontOp[GetKeyGroupConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetKeyGroupConfigResponse] =
        visitor.getKeyGroupConfig(request)
    }

    final case class GetMonitoringSubscriptionOp(
      request: GetMonitoringSubscriptionRequest
    ) extends CloudFrontOp[GetMonitoringSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMonitoringSubscriptionResponse] =
        visitor.getMonitoringSubscription(request)
    }

    final case class GetOriginRequestPolicyOp(
      request: GetOriginRequestPolicyRequest
    ) extends CloudFrontOp[GetOriginRequestPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOriginRequestPolicyResponse] =
        visitor.getOriginRequestPolicy(request)
    }

    final case class GetOriginRequestPolicyConfigOp(
      request: GetOriginRequestPolicyConfigRequest
    ) extends CloudFrontOp[GetOriginRequestPolicyConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOriginRequestPolicyConfigResponse] =
        visitor.getOriginRequestPolicyConfig(request)
    }

    final case class GetPublicKeyOp(
      request: GetPublicKeyRequest
    ) extends CloudFrontOp[GetPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPublicKeyResponse] =
        visitor.getPublicKey(request)
    }

    final case class GetPublicKeyConfigOp(
      request: GetPublicKeyConfigRequest
    ) extends CloudFrontOp[GetPublicKeyConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPublicKeyConfigResponse] =
        visitor.getPublicKeyConfig(request)
    }

    final case class GetRealtimeLogConfigOp(
      request: GetRealtimeLogConfigRequest
    ) extends CloudFrontOp[GetRealtimeLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRealtimeLogConfigResponse] =
        visitor.getRealtimeLogConfig(request)
    }

    final case class GetStreamingDistributionOp(
      request: GetStreamingDistributionRequest
    ) extends CloudFrontOp[GetStreamingDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamingDistributionResponse] =
        visitor.getStreamingDistribution(request)
    }

    final case class GetStreamingDistributionConfigOp(
      request: GetStreamingDistributionConfigRequest
    ) extends CloudFrontOp[GetStreamingDistributionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStreamingDistributionConfigResponse] =
        visitor.getStreamingDistributionConfig(request)
    }

    final case class ListCachePoliciesOp(
      request: ListCachePoliciesRequest
    ) extends CloudFrontOp[ListCachePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCachePoliciesResponse] =
        visitor.listCachePolicies(request)
    }

    final case class ListCloudFrontOriginAccessIdentitiesOp(
      request: ListCloudFrontOriginAccessIdentitiesRequest
    ) extends CloudFrontOp[ListCloudFrontOriginAccessIdentitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCloudFrontOriginAccessIdentitiesResponse] =
        visitor.listCloudFrontOriginAccessIdentities(request)
    }

    final case class ListDistributionsOp(
      request: ListDistributionsRequest
    ) extends CloudFrontOp[ListDistributionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionsResponse] =
        visitor.listDistributions(request)
    }

    final case class ListDistributionsByCachePolicyIdOp(
      request: ListDistributionsByCachePolicyIdRequest
    ) extends CloudFrontOp[ListDistributionsByCachePolicyIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionsByCachePolicyIdResponse] =
        visitor.listDistributionsByCachePolicyId(request)
    }

    final case class ListDistributionsByKeyGroupOp(
      request: ListDistributionsByKeyGroupRequest
    ) extends CloudFrontOp[ListDistributionsByKeyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionsByKeyGroupResponse] =
        visitor.listDistributionsByKeyGroup(request)
    }

    final case class ListDistributionsByOriginRequestPolicyIdOp(
      request: ListDistributionsByOriginRequestPolicyIdRequest
    ) extends CloudFrontOp[ListDistributionsByOriginRequestPolicyIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionsByOriginRequestPolicyIdResponse] =
        visitor.listDistributionsByOriginRequestPolicyId(request)
    }

    final case class ListDistributionsByRealtimeLogConfigOp(
      request: ListDistributionsByRealtimeLogConfigRequest
    ) extends CloudFrontOp[ListDistributionsByRealtimeLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionsByRealtimeLogConfigResponse] =
        visitor.listDistributionsByRealtimeLogConfig(request)
    }

    final case class ListDistributionsByWebACLIdOp(
      request: ListDistributionsByWebAclIdRequest
    ) extends CloudFrontOp[ListDistributionsByWebAclIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDistributionsByWebAclIdResponse] =
        visitor.listDistributionsByWebACLId(request)
    }

    final case class ListFieldLevelEncryptionConfigsOp(
      request: ListFieldLevelEncryptionConfigsRequest
    ) extends CloudFrontOp[ListFieldLevelEncryptionConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFieldLevelEncryptionConfigsResponse] =
        visitor.listFieldLevelEncryptionConfigs(request)
    }

    final case class ListFieldLevelEncryptionProfilesOp(
      request: ListFieldLevelEncryptionProfilesRequest
    ) extends CloudFrontOp[ListFieldLevelEncryptionProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFieldLevelEncryptionProfilesResponse] =
        visitor.listFieldLevelEncryptionProfiles(request)
    }

    final case class ListFunctionsOp(
      request: ListFunctionsRequest
    ) extends CloudFrontOp[ListFunctionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionsResponse] =
        visitor.listFunctions(request)
    }

    final case class ListInvalidationsOp(
      request: ListInvalidationsRequest
    ) extends CloudFrontOp[ListInvalidationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInvalidationsResponse] =
        visitor.listInvalidations(request)
    }

    final case class ListKeyGroupsOp(
      request: ListKeyGroupsRequest
    ) extends CloudFrontOp[ListKeyGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListKeyGroupsResponse] =
        visitor.listKeyGroups(request)
    }

    final case class ListOriginRequestPoliciesOp(
      request: ListOriginRequestPoliciesRequest
    ) extends CloudFrontOp[ListOriginRequestPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOriginRequestPoliciesResponse] =
        visitor.listOriginRequestPolicies(request)
    }

    final case class ListPublicKeysOp(
      request: ListPublicKeysRequest
    ) extends CloudFrontOp[ListPublicKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPublicKeysResponse] =
        visitor.listPublicKeys(request)
    }

    final case class ListRealtimeLogConfigsOp(
      request: ListRealtimeLogConfigsRequest
    ) extends CloudFrontOp[ListRealtimeLogConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRealtimeLogConfigsResponse] =
        visitor.listRealtimeLogConfigs(request)
    }

    final case class ListStreamingDistributionsOp(
      request: ListStreamingDistributionsRequest
    ) extends CloudFrontOp[ListStreamingDistributionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamingDistributionsResponse] =
        visitor.listStreamingDistributions(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CloudFrontOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PublishFunctionOp(
      request: PublishFunctionRequest
    ) extends CloudFrontOp[PublishFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishFunctionResponse] =
        visitor.publishFunction(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CloudFrontOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestFunctionOp(
      request: TestFunctionRequest
    ) extends CloudFrontOp[TestFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestFunctionResponse] =
        visitor.testFunction(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CloudFrontOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateCachePolicyOp(
      request: UpdateCachePolicyRequest
    ) extends CloudFrontOp[UpdateCachePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCachePolicyResponse] =
        visitor.updateCachePolicy(request)
    }

    final case class UpdateCloudFrontOriginAccessIdentityOp(
      request: UpdateCloudFrontOriginAccessIdentityRequest
    ) extends CloudFrontOp[UpdateCloudFrontOriginAccessIdentityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCloudFrontOriginAccessIdentityResponse] =
        visitor.updateCloudFrontOriginAccessIdentity(request)
    }

    final case class UpdateDistributionOp(
      request: UpdateDistributionRequest
    ) extends CloudFrontOp[UpdateDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDistributionResponse] =
        visitor.updateDistribution(request)
    }

    final case class UpdateFieldLevelEncryptionConfigOp(
      request: UpdateFieldLevelEncryptionConfigRequest
    ) extends CloudFrontOp[UpdateFieldLevelEncryptionConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFieldLevelEncryptionConfigResponse] =
        visitor.updateFieldLevelEncryptionConfig(request)
    }

    final case class UpdateFieldLevelEncryptionProfileOp(
      request: UpdateFieldLevelEncryptionProfileRequest
    ) extends CloudFrontOp[UpdateFieldLevelEncryptionProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFieldLevelEncryptionProfileResponse] =
        visitor.updateFieldLevelEncryptionProfile(request)
    }

    final case class UpdateFunctionOp(
      request: UpdateFunctionRequest
    ) extends CloudFrontOp[UpdateFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFunctionResponse] =
        visitor.updateFunction(request)
    }

    final case class UpdateKeyGroupOp(
      request: UpdateKeyGroupRequest
    ) extends CloudFrontOp[UpdateKeyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateKeyGroupResponse] =
        visitor.updateKeyGroup(request)
    }

    final case class UpdateOriginRequestPolicyOp(
      request: UpdateOriginRequestPolicyRequest
    ) extends CloudFrontOp[UpdateOriginRequestPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOriginRequestPolicyResponse] =
        visitor.updateOriginRequestPolicy(request)
    }

    final case class UpdatePublicKeyOp(
      request: UpdatePublicKeyRequest
    ) extends CloudFrontOp[UpdatePublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePublicKeyResponse] =
        visitor.updatePublicKey(request)
    }

    final case class UpdateRealtimeLogConfigOp(
      request: UpdateRealtimeLogConfigRequest
    ) extends CloudFrontOp[UpdateRealtimeLogConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRealtimeLogConfigResponse] =
        visitor.updateRealtimeLogConfig(request)
    }

    final case class UpdateStreamingDistributionOp(
      request: UpdateStreamingDistributionRequest
    ) extends CloudFrontOp[UpdateStreamingDistributionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStreamingDistributionResponse] =
        visitor.updateStreamingDistribution(request)
    }
  }

  import CloudFrontOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudFrontOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createCachePolicy(
    request: CreateCachePolicyRequest
  ): CloudFrontIO[CreateCachePolicyResponse] =
    FF.liftF(CreateCachePolicyOp(request))

  def createCloudFrontOriginAccessIdentity(
    request: CreateCloudFrontOriginAccessIdentityRequest
  ): CloudFrontIO[CreateCloudFrontOriginAccessIdentityResponse] =
    FF.liftF(CreateCloudFrontOriginAccessIdentityOp(request))

  def createDistribution(
    request: CreateDistributionRequest
  ): CloudFrontIO[CreateDistributionResponse] =
    FF.liftF(CreateDistributionOp(request))

  def createDistributionWithTags(
    request: CreateDistributionWithTagsRequest
  ): CloudFrontIO[CreateDistributionWithTagsResponse] =
    FF.liftF(CreateDistributionWithTagsOp(request))

  def createFieldLevelEncryptionConfig(
    request: CreateFieldLevelEncryptionConfigRequest
  ): CloudFrontIO[CreateFieldLevelEncryptionConfigResponse] =
    FF.liftF(CreateFieldLevelEncryptionConfigOp(request))

  def createFieldLevelEncryptionProfile(
    request: CreateFieldLevelEncryptionProfileRequest
  ): CloudFrontIO[CreateFieldLevelEncryptionProfileResponse] =
    FF.liftF(CreateFieldLevelEncryptionProfileOp(request))

  def createFunction(
    request: CreateFunctionRequest
  ): CloudFrontIO[CreateFunctionResponse] =
    FF.liftF(CreateFunctionOp(request))

  def createInvalidation(
    request: CreateInvalidationRequest
  ): CloudFrontIO[CreateInvalidationResponse] =
    FF.liftF(CreateInvalidationOp(request))

  def createKeyGroup(
    request: CreateKeyGroupRequest
  ): CloudFrontIO[CreateKeyGroupResponse] =
    FF.liftF(CreateKeyGroupOp(request))

  def createMonitoringSubscription(
    request: CreateMonitoringSubscriptionRequest
  ): CloudFrontIO[CreateMonitoringSubscriptionResponse] =
    FF.liftF(CreateMonitoringSubscriptionOp(request))

  def createOriginRequestPolicy(
    request: CreateOriginRequestPolicyRequest
  ): CloudFrontIO[CreateOriginRequestPolicyResponse] =
    FF.liftF(CreateOriginRequestPolicyOp(request))

  def createPublicKey(
    request: CreatePublicKeyRequest
  ): CloudFrontIO[CreatePublicKeyResponse] =
    FF.liftF(CreatePublicKeyOp(request))

  def createRealtimeLogConfig(
    request: CreateRealtimeLogConfigRequest
  ): CloudFrontIO[CreateRealtimeLogConfigResponse] =
    FF.liftF(CreateRealtimeLogConfigOp(request))

  def createStreamingDistribution(
    request: CreateStreamingDistributionRequest
  ): CloudFrontIO[CreateStreamingDistributionResponse] =
    FF.liftF(CreateStreamingDistributionOp(request))

  def createStreamingDistributionWithTags(
    request: CreateStreamingDistributionWithTagsRequest
  ): CloudFrontIO[CreateStreamingDistributionWithTagsResponse] =
    FF.liftF(CreateStreamingDistributionWithTagsOp(request))

  def deleteCachePolicy(
    request: DeleteCachePolicyRequest
  ): CloudFrontIO[DeleteCachePolicyResponse] =
    FF.liftF(DeleteCachePolicyOp(request))

  def deleteCloudFrontOriginAccessIdentity(
    request: DeleteCloudFrontOriginAccessIdentityRequest
  ): CloudFrontIO[DeleteCloudFrontOriginAccessIdentityResponse] =
    FF.liftF(DeleteCloudFrontOriginAccessIdentityOp(request))

  def deleteDistribution(
    request: DeleteDistributionRequest
  ): CloudFrontIO[DeleteDistributionResponse] =
    FF.liftF(DeleteDistributionOp(request))

  def deleteFieldLevelEncryptionConfig(
    request: DeleteFieldLevelEncryptionConfigRequest
  ): CloudFrontIO[DeleteFieldLevelEncryptionConfigResponse] =
    FF.liftF(DeleteFieldLevelEncryptionConfigOp(request))

  def deleteFieldLevelEncryptionProfile(
    request: DeleteFieldLevelEncryptionProfileRequest
  ): CloudFrontIO[DeleteFieldLevelEncryptionProfileResponse] =
    FF.liftF(DeleteFieldLevelEncryptionProfileOp(request))

  def deleteFunction(
    request: DeleteFunctionRequest
  ): CloudFrontIO[DeleteFunctionResponse] =
    FF.liftF(DeleteFunctionOp(request))

  def deleteKeyGroup(
    request: DeleteKeyGroupRequest
  ): CloudFrontIO[DeleteKeyGroupResponse] =
    FF.liftF(DeleteKeyGroupOp(request))

  def deleteMonitoringSubscription(
    request: DeleteMonitoringSubscriptionRequest
  ): CloudFrontIO[DeleteMonitoringSubscriptionResponse] =
    FF.liftF(DeleteMonitoringSubscriptionOp(request))

  def deleteOriginRequestPolicy(
    request: DeleteOriginRequestPolicyRequest
  ): CloudFrontIO[DeleteOriginRequestPolicyResponse] =
    FF.liftF(DeleteOriginRequestPolicyOp(request))

  def deletePublicKey(
    request: DeletePublicKeyRequest
  ): CloudFrontIO[DeletePublicKeyResponse] =
    FF.liftF(DeletePublicKeyOp(request))

  def deleteRealtimeLogConfig(
    request: DeleteRealtimeLogConfigRequest
  ): CloudFrontIO[DeleteRealtimeLogConfigResponse] =
    FF.liftF(DeleteRealtimeLogConfigOp(request))

  def deleteStreamingDistribution(
    request: DeleteStreamingDistributionRequest
  ): CloudFrontIO[DeleteStreamingDistributionResponse] =
    FF.liftF(DeleteStreamingDistributionOp(request))

  def describeFunction(
    request: DescribeFunctionRequest
  ): CloudFrontIO[DescribeFunctionResponse] =
    FF.liftF(DescribeFunctionOp(request))

  def getCachePolicy(
    request: GetCachePolicyRequest
  ): CloudFrontIO[GetCachePolicyResponse] =
    FF.liftF(GetCachePolicyOp(request))

  def getCachePolicyConfig(
    request: GetCachePolicyConfigRequest
  ): CloudFrontIO[GetCachePolicyConfigResponse] =
    FF.liftF(GetCachePolicyConfigOp(request))

  def getCloudFrontOriginAccessIdentity(
    request: GetCloudFrontOriginAccessIdentityRequest
  ): CloudFrontIO[GetCloudFrontOriginAccessIdentityResponse] =
    FF.liftF(GetCloudFrontOriginAccessIdentityOp(request))

  def getCloudFrontOriginAccessIdentityConfig(
    request: GetCloudFrontOriginAccessIdentityConfigRequest
  ): CloudFrontIO[GetCloudFrontOriginAccessIdentityConfigResponse] =
    FF.liftF(GetCloudFrontOriginAccessIdentityConfigOp(request))

  def getDistribution(
    request: GetDistributionRequest
  ): CloudFrontIO[GetDistributionResponse] =
    FF.liftF(GetDistributionOp(request))

  def getDistributionConfig(
    request: GetDistributionConfigRequest
  ): CloudFrontIO[GetDistributionConfigResponse] =
    FF.liftF(GetDistributionConfigOp(request))

  def getFieldLevelEncryption(
    request: GetFieldLevelEncryptionRequest
  ): CloudFrontIO[GetFieldLevelEncryptionResponse] =
    FF.liftF(GetFieldLevelEncryptionOp(request))

  def getFieldLevelEncryptionConfig(
    request: GetFieldLevelEncryptionConfigRequest
  ): CloudFrontIO[GetFieldLevelEncryptionConfigResponse] =
    FF.liftF(GetFieldLevelEncryptionConfigOp(request))

  def getFieldLevelEncryptionProfile(
    request: GetFieldLevelEncryptionProfileRequest
  ): CloudFrontIO[GetFieldLevelEncryptionProfileResponse] =
    FF.liftF(GetFieldLevelEncryptionProfileOp(request))

  def getFieldLevelEncryptionProfileConfig(
    request: GetFieldLevelEncryptionProfileConfigRequest
  ): CloudFrontIO[GetFieldLevelEncryptionProfileConfigResponse] =
    FF.liftF(GetFieldLevelEncryptionProfileConfigOp(request))

  def getFunction(
    request: GetFunctionRequest
  ): CloudFrontIO[GetFunctionResponse] =
    FF.liftF(GetFunctionOp(request))

  def getInvalidation(
    request: GetInvalidationRequest
  ): CloudFrontIO[GetInvalidationResponse] =
    FF.liftF(GetInvalidationOp(request))

  def getKeyGroup(
    request: GetKeyGroupRequest
  ): CloudFrontIO[GetKeyGroupResponse] =
    FF.liftF(GetKeyGroupOp(request))

  def getKeyGroupConfig(
    request: GetKeyGroupConfigRequest
  ): CloudFrontIO[GetKeyGroupConfigResponse] =
    FF.liftF(GetKeyGroupConfigOp(request))

  def getMonitoringSubscription(
    request: GetMonitoringSubscriptionRequest
  ): CloudFrontIO[GetMonitoringSubscriptionResponse] =
    FF.liftF(GetMonitoringSubscriptionOp(request))

  def getOriginRequestPolicy(
    request: GetOriginRequestPolicyRequest
  ): CloudFrontIO[GetOriginRequestPolicyResponse] =
    FF.liftF(GetOriginRequestPolicyOp(request))

  def getOriginRequestPolicyConfig(
    request: GetOriginRequestPolicyConfigRequest
  ): CloudFrontIO[GetOriginRequestPolicyConfigResponse] =
    FF.liftF(GetOriginRequestPolicyConfigOp(request))

  def getPublicKey(
    request: GetPublicKeyRequest
  ): CloudFrontIO[GetPublicKeyResponse] =
    FF.liftF(GetPublicKeyOp(request))

  def getPublicKeyConfig(
    request: GetPublicKeyConfigRequest
  ): CloudFrontIO[GetPublicKeyConfigResponse] =
    FF.liftF(GetPublicKeyConfigOp(request))

  def getRealtimeLogConfig(
    request: GetRealtimeLogConfigRequest
  ): CloudFrontIO[GetRealtimeLogConfigResponse] =
    FF.liftF(GetRealtimeLogConfigOp(request))

  def getStreamingDistribution(
    request: GetStreamingDistributionRequest
  ): CloudFrontIO[GetStreamingDistributionResponse] =
    FF.liftF(GetStreamingDistributionOp(request))

  def getStreamingDistributionConfig(
    request: GetStreamingDistributionConfigRequest
  ): CloudFrontIO[GetStreamingDistributionConfigResponse] =
    FF.liftF(GetStreamingDistributionConfigOp(request))

  def listCachePolicies(
    request: ListCachePoliciesRequest
  ): CloudFrontIO[ListCachePoliciesResponse] =
    FF.liftF(ListCachePoliciesOp(request))

  def listCloudFrontOriginAccessIdentities(
    request: ListCloudFrontOriginAccessIdentitiesRequest
  ): CloudFrontIO[ListCloudFrontOriginAccessIdentitiesResponse] =
    FF.liftF(ListCloudFrontOriginAccessIdentitiesOp(request))

  def listDistributions(
    request: ListDistributionsRequest
  ): CloudFrontIO[ListDistributionsResponse] =
    FF.liftF(ListDistributionsOp(request))

  def listDistributionsByCachePolicyId(
    request: ListDistributionsByCachePolicyIdRequest
  ): CloudFrontIO[ListDistributionsByCachePolicyIdResponse] =
    FF.liftF(ListDistributionsByCachePolicyIdOp(request))

  def listDistributionsByKeyGroup(
    request: ListDistributionsByKeyGroupRequest
  ): CloudFrontIO[ListDistributionsByKeyGroupResponse] =
    FF.liftF(ListDistributionsByKeyGroupOp(request))

  def listDistributionsByOriginRequestPolicyId(
    request: ListDistributionsByOriginRequestPolicyIdRequest
  ): CloudFrontIO[ListDistributionsByOriginRequestPolicyIdResponse] =
    FF.liftF(ListDistributionsByOriginRequestPolicyIdOp(request))

  def listDistributionsByRealtimeLogConfig(
    request: ListDistributionsByRealtimeLogConfigRequest
  ): CloudFrontIO[ListDistributionsByRealtimeLogConfigResponse] =
    FF.liftF(ListDistributionsByRealtimeLogConfigOp(request))

  def listDistributionsByWebACLId(
    request: ListDistributionsByWebAclIdRequest
  ): CloudFrontIO[ListDistributionsByWebAclIdResponse] =
    FF.liftF(ListDistributionsByWebACLIdOp(request))

  def listFieldLevelEncryptionConfigs(
    request: ListFieldLevelEncryptionConfigsRequest
  ): CloudFrontIO[ListFieldLevelEncryptionConfigsResponse] =
    FF.liftF(ListFieldLevelEncryptionConfigsOp(request))

  def listFieldLevelEncryptionProfiles(
    request: ListFieldLevelEncryptionProfilesRequest
  ): CloudFrontIO[ListFieldLevelEncryptionProfilesResponse] =
    FF.liftF(ListFieldLevelEncryptionProfilesOp(request))

  def listFunctions(
    request: ListFunctionsRequest
  ): CloudFrontIO[ListFunctionsResponse] =
    FF.liftF(ListFunctionsOp(request))

  def listInvalidations(
    request: ListInvalidationsRequest
  ): CloudFrontIO[ListInvalidationsResponse] =
    FF.liftF(ListInvalidationsOp(request))

  def listKeyGroups(
    request: ListKeyGroupsRequest
  ): CloudFrontIO[ListKeyGroupsResponse] =
    FF.liftF(ListKeyGroupsOp(request))

  def listOriginRequestPolicies(
    request: ListOriginRequestPoliciesRequest
  ): CloudFrontIO[ListOriginRequestPoliciesResponse] =
    FF.liftF(ListOriginRequestPoliciesOp(request))

  def listPublicKeys(
    request: ListPublicKeysRequest
  ): CloudFrontIO[ListPublicKeysResponse] =
    FF.liftF(ListPublicKeysOp(request))

  def listRealtimeLogConfigs(
    request: ListRealtimeLogConfigsRequest
  ): CloudFrontIO[ListRealtimeLogConfigsResponse] =
    FF.liftF(ListRealtimeLogConfigsOp(request))

  def listStreamingDistributions(
    request: ListStreamingDistributionsRequest
  ): CloudFrontIO[ListStreamingDistributionsResponse] =
    FF.liftF(ListStreamingDistributionsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CloudFrontIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def publishFunction(
    request: PublishFunctionRequest
  ): CloudFrontIO[PublishFunctionResponse] =
    FF.liftF(PublishFunctionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CloudFrontIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testFunction(
    request: TestFunctionRequest
  ): CloudFrontIO[TestFunctionResponse] =
    FF.liftF(TestFunctionOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CloudFrontIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateCachePolicy(
    request: UpdateCachePolicyRequest
  ): CloudFrontIO[UpdateCachePolicyResponse] =
    FF.liftF(UpdateCachePolicyOp(request))

  def updateCloudFrontOriginAccessIdentity(
    request: UpdateCloudFrontOriginAccessIdentityRequest
  ): CloudFrontIO[UpdateCloudFrontOriginAccessIdentityResponse] =
    FF.liftF(UpdateCloudFrontOriginAccessIdentityOp(request))

  def updateDistribution(
    request: UpdateDistributionRequest
  ): CloudFrontIO[UpdateDistributionResponse] =
    FF.liftF(UpdateDistributionOp(request))

  def updateFieldLevelEncryptionConfig(
    request: UpdateFieldLevelEncryptionConfigRequest
  ): CloudFrontIO[UpdateFieldLevelEncryptionConfigResponse] =
    FF.liftF(UpdateFieldLevelEncryptionConfigOp(request))

  def updateFieldLevelEncryptionProfile(
    request: UpdateFieldLevelEncryptionProfileRequest
  ): CloudFrontIO[UpdateFieldLevelEncryptionProfileResponse] =
    FF.liftF(UpdateFieldLevelEncryptionProfileOp(request))

  def updateFunction(
    request: UpdateFunctionRequest
  ): CloudFrontIO[UpdateFunctionResponse] =
    FF.liftF(UpdateFunctionOp(request))

  def updateKeyGroup(
    request: UpdateKeyGroupRequest
  ): CloudFrontIO[UpdateKeyGroupResponse] =
    FF.liftF(UpdateKeyGroupOp(request))

  def updateOriginRequestPolicy(
    request: UpdateOriginRequestPolicyRequest
  ): CloudFrontIO[UpdateOriginRequestPolicyResponse] =
    FF.liftF(UpdateOriginRequestPolicyOp(request))

  def updatePublicKey(
    request: UpdatePublicKeyRequest
  ): CloudFrontIO[UpdatePublicKeyResponse] =
    FF.liftF(UpdatePublicKeyOp(request))

  def updateRealtimeLogConfig(
    request: UpdateRealtimeLogConfigRequest
  ): CloudFrontIO[UpdateRealtimeLogConfigResponse] =
    FF.liftF(UpdateRealtimeLogConfigOp(request))

  def updateStreamingDistribution(
    request: UpdateStreamingDistributionRequest
  ): CloudFrontIO[UpdateStreamingDistributionResponse] =
    FF.liftF(UpdateStreamingDistributionOp(request))
}
