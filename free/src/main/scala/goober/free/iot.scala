package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iot.IotClient
import software.amazon.awssdk.services.iot.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object iot { module =>

  // Free monad over IotOp
  type IotIO[A] = FF[IotOp, A]

  sealed trait IotOp[A] {
    def visit[F[_]](visitor: IotOp.Visitor[F]): F[A]
  }

  object IotOp {
    // Given a IotClient we can embed a IotIO program in any algebra that understands embedding.
    implicit val IotOpEmbeddable: Embeddable[IotOp, IotClient] = new Embeddable[IotOp, IotClient] {
      def embed[A](client: IotClient, io: IotIO[A]): Embedded[A] = Embedded.Iot(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotOp.Visitor[Kleisli[M, IotClient, *]] {
        def acceptCertificateTransfer(
          request: AcceptCertificateTransferRequest
        ): Kleisli[M, IotClient, AcceptCertificateTransferResponse] =
          primitive(_.acceptCertificateTransfer(request))

        def addThingToBillingGroup(
          request: AddThingToBillingGroupRequest
        ): Kleisli[M, IotClient, AddThingToBillingGroupResponse] =
          primitive(_.addThingToBillingGroup(request))

        def addThingToThingGroup(
          request: AddThingToThingGroupRequest
        ): Kleisli[M, IotClient, AddThingToThingGroupResponse] =
          primitive(_.addThingToThingGroup(request))

        def associateTargetsWithJob(
          request: AssociateTargetsWithJobRequest
        ): Kleisli[M, IotClient, AssociateTargetsWithJobResponse] =
          primitive(_.associateTargetsWithJob(request))

        def attachPolicy(
          request: AttachPolicyRequest
        ): Kleisli[M, IotClient, AttachPolicyResponse] =
          primitive(_.attachPolicy(request))

        def attachSecurityProfile(
          request: AttachSecurityProfileRequest
        ): Kleisli[M, IotClient, AttachSecurityProfileResponse] =
          primitive(_.attachSecurityProfile(request))

        def attachThingPrincipal(
          request: AttachThingPrincipalRequest
        ): Kleisli[M, IotClient, AttachThingPrincipalResponse] =
          primitive(_.attachThingPrincipal(request))

        def cancelAuditMitigationActionsTask(
          request: CancelAuditMitigationActionsTaskRequest
        ): Kleisli[M, IotClient, CancelAuditMitigationActionsTaskResponse] =
          primitive(_.cancelAuditMitigationActionsTask(request))

        def cancelAuditTask(
          request: CancelAuditTaskRequest
        ): Kleisli[M, IotClient, CancelAuditTaskResponse] =
          primitive(_.cancelAuditTask(request))

        def cancelCertificateTransfer(
          request: CancelCertificateTransferRequest
        ): Kleisli[M, IotClient, CancelCertificateTransferResponse] =
          primitive(_.cancelCertificateTransfer(request))

        def cancelDetectMitigationActionsTask(
          request: CancelDetectMitigationActionsTaskRequest
        ): Kleisli[M, IotClient, CancelDetectMitigationActionsTaskResponse] =
          primitive(_.cancelDetectMitigationActionsTask(request))

        def cancelJob(
          request: CancelJobRequest
        ): Kleisli[M, IotClient, CancelJobResponse] =
          primitive(_.cancelJob(request))

        def cancelJobExecution(
          request: CancelJobExecutionRequest
        ): Kleisli[M, IotClient, CancelJobExecutionResponse] =
          primitive(_.cancelJobExecution(request))

        def clearDefaultAuthorizer(
          request: ClearDefaultAuthorizerRequest
        ): Kleisli[M, IotClient, ClearDefaultAuthorizerResponse] =
          primitive(_.clearDefaultAuthorizer(request))

        def confirmTopicRuleDestination(
          request: ConfirmTopicRuleDestinationRequest
        ): Kleisli[M, IotClient, ConfirmTopicRuleDestinationResponse] =
          primitive(_.confirmTopicRuleDestination(request))

        def createAuditSuppression(
          request: CreateAuditSuppressionRequest
        ): Kleisli[M, IotClient, CreateAuditSuppressionResponse] =
          primitive(_.createAuditSuppression(request))

        def createAuthorizer(
          request: CreateAuthorizerRequest
        ): Kleisli[M, IotClient, CreateAuthorizerResponse] =
          primitive(_.createAuthorizer(request))

        def createBillingGroup(
          request: CreateBillingGroupRequest
        ): Kleisli[M, IotClient, CreateBillingGroupResponse] =
          primitive(_.createBillingGroup(request))

        def createCertificateFromCsr(
          request: CreateCertificateFromCsrRequest
        ): Kleisli[M, IotClient, CreateCertificateFromCsrResponse] =
          primitive(_.createCertificateFromCsr(request))

        def createCustomMetric(
          request: CreateCustomMetricRequest
        ): Kleisli[M, IotClient, CreateCustomMetricResponse] =
          primitive(_.createCustomMetric(request))

        def createDimension(
          request: CreateDimensionRequest
        ): Kleisli[M, IotClient, CreateDimensionResponse] =
          primitive(_.createDimension(request))

        def createDomainConfiguration(
          request: CreateDomainConfigurationRequest
        ): Kleisli[M, IotClient, CreateDomainConfigurationResponse] =
          primitive(_.createDomainConfiguration(request))

        def createDynamicThingGroup(
          request: CreateDynamicThingGroupRequest
        ): Kleisli[M, IotClient, CreateDynamicThingGroupResponse] =
          primitive(_.createDynamicThingGroup(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, IotClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def createJobTemplate(
          request: CreateJobTemplateRequest
        ): Kleisli[M, IotClient, CreateJobTemplateResponse] =
          primitive(_.createJobTemplate(request))

        def createKeysAndCertificate(
          request: CreateKeysAndCertificateRequest
        ): Kleisli[M, IotClient, CreateKeysAndCertificateResponse] =
          primitive(_.createKeysAndCertificate(request))

        def createMitigationAction(
          request: CreateMitigationActionRequest
        ): Kleisli[M, IotClient, CreateMitigationActionResponse] =
          primitive(_.createMitigationAction(request))

        def createOTAUpdate(
          request: CreateOtaUpdateRequest
        ): Kleisli[M, IotClient, CreateOtaUpdateResponse] =
          primitive(_.createOTAUpdate(request))

        def createPolicy(
          request: CreatePolicyRequest
        ): Kleisli[M, IotClient, CreatePolicyResponse] =
          primitive(_.createPolicy(request))

        def createPolicyVersion(
          request: CreatePolicyVersionRequest
        ): Kleisli[M, IotClient, CreatePolicyVersionResponse] =
          primitive(_.createPolicyVersion(request))

        def createProvisioningClaim(
          request: CreateProvisioningClaimRequest
        ): Kleisli[M, IotClient, CreateProvisioningClaimResponse] =
          primitive(_.createProvisioningClaim(request))

        def createProvisioningTemplate(
          request: CreateProvisioningTemplateRequest
        ): Kleisli[M, IotClient, CreateProvisioningTemplateResponse] =
          primitive(_.createProvisioningTemplate(request))

        def createProvisioningTemplateVersion(
          request: CreateProvisioningTemplateVersionRequest
        ): Kleisli[M, IotClient, CreateProvisioningTemplateVersionResponse] =
          primitive(_.createProvisioningTemplateVersion(request))

        def createRoleAlias(
          request: CreateRoleAliasRequest
        ): Kleisli[M, IotClient, CreateRoleAliasResponse] =
          primitive(_.createRoleAlias(request))

        def createScheduledAudit(
          request: CreateScheduledAuditRequest
        ): Kleisli[M, IotClient, CreateScheduledAuditResponse] =
          primitive(_.createScheduledAudit(request))

        def createSecurityProfile(
          request: CreateSecurityProfileRequest
        ): Kleisli[M, IotClient, CreateSecurityProfileResponse] =
          primitive(_.createSecurityProfile(request))

        def createStream(
          request: CreateStreamRequest
        ): Kleisli[M, IotClient, CreateStreamResponse] =
          primitive(_.createStream(request))

        def createThing(
          request: CreateThingRequest
        ): Kleisli[M, IotClient, CreateThingResponse] =
          primitive(_.createThing(request))

        def createThingGroup(
          request: CreateThingGroupRequest
        ): Kleisli[M, IotClient, CreateThingGroupResponse] =
          primitive(_.createThingGroup(request))

        def createThingType(
          request: CreateThingTypeRequest
        ): Kleisli[M, IotClient, CreateThingTypeResponse] =
          primitive(_.createThingType(request))

        def createTopicRule(
          request: CreateTopicRuleRequest
        ): Kleisli[M, IotClient, CreateTopicRuleResponse] =
          primitive(_.createTopicRule(request))

        def createTopicRuleDestination(
          request: CreateTopicRuleDestinationRequest
        ): Kleisli[M, IotClient, CreateTopicRuleDestinationResponse] =
          primitive(_.createTopicRuleDestination(request))

        def deleteAccountAuditConfiguration(
          request: DeleteAccountAuditConfigurationRequest
        ): Kleisli[M, IotClient, DeleteAccountAuditConfigurationResponse] =
          primitive(_.deleteAccountAuditConfiguration(request))

        def deleteAuditSuppression(
          request: DeleteAuditSuppressionRequest
        ): Kleisli[M, IotClient, DeleteAuditSuppressionResponse] =
          primitive(_.deleteAuditSuppression(request))

        def deleteAuthorizer(
          request: DeleteAuthorizerRequest
        ): Kleisli[M, IotClient, DeleteAuthorizerResponse] =
          primitive(_.deleteAuthorizer(request))

        def deleteBillingGroup(
          request: DeleteBillingGroupRequest
        ): Kleisli[M, IotClient, DeleteBillingGroupResponse] =
          primitive(_.deleteBillingGroup(request))

        def deleteCACertificate(
          request: DeleteCaCertificateRequest
        ): Kleisli[M, IotClient, DeleteCaCertificateResponse] =
          primitive(_.deleteCACertificate(request))

        def deleteCertificate(
          request: DeleteCertificateRequest
        ): Kleisli[M, IotClient, DeleteCertificateResponse] =
          primitive(_.deleteCertificate(request))

        def deleteCustomMetric(
          request: DeleteCustomMetricRequest
        ): Kleisli[M, IotClient, DeleteCustomMetricResponse] =
          primitive(_.deleteCustomMetric(request))

        def deleteDimension(
          request: DeleteDimensionRequest
        ): Kleisli[M, IotClient, DeleteDimensionResponse] =
          primitive(_.deleteDimension(request))

        def deleteDomainConfiguration(
          request: DeleteDomainConfigurationRequest
        ): Kleisli[M, IotClient, DeleteDomainConfigurationResponse] =
          primitive(_.deleteDomainConfiguration(request))

        def deleteDynamicThingGroup(
          request: DeleteDynamicThingGroupRequest
        ): Kleisli[M, IotClient, DeleteDynamicThingGroupResponse] =
          primitive(_.deleteDynamicThingGroup(request))

        def deleteJob(
          request: DeleteJobRequest
        ): Kleisli[M, IotClient, DeleteJobResponse] =
          primitive(_.deleteJob(request))

        def deleteJobExecution(
          request: DeleteJobExecutionRequest
        ): Kleisli[M, IotClient, DeleteJobExecutionResponse] =
          primitive(_.deleteJobExecution(request))

        def deleteJobTemplate(
          request: DeleteJobTemplateRequest
        ): Kleisli[M, IotClient, DeleteJobTemplateResponse] =
          primitive(_.deleteJobTemplate(request))

        def deleteMitigationAction(
          request: DeleteMitigationActionRequest
        ): Kleisli[M, IotClient, DeleteMitigationActionResponse] =
          primitive(_.deleteMitigationAction(request))

        def deleteOTAUpdate(
          request: DeleteOtaUpdateRequest
        ): Kleisli[M, IotClient, DeleteOtaUpdateResponse] =
          primitive(_.deleteOTAUpdate(request))

        def deletePolicy(
          request: DeletePolicyRequest
        ): Kleisli[M, IotClient, DeletePolicyResponse] =
          primitive(_.deletePolicy(request))

        def deletePolicyVersion(
          request: DeletePolicyVersionRequest
        ): Kleisli[M, IotClient, DeletePolicyVersionResponse] =
          primitive(_.deletePolicyVersion(request))

        def deleteProvisioningTemplate(
          request: DeleteProvisioningTemplateRequest
        ): Kleisli[M, IotClient, DeleteProvisioningTemplateResponse] =
          primitive(_.deleteProvisioningTemplate(request))

        def deleteProvisioningTemplateVersion(
          request: DeleteProvisioningTemplateVersionRequest
        ): Kleisli[M, IotClient, DeleteProvisioningTemplateVersionResponse] =
          primitive(_.deleteProvisioningTemplateVersion(request))

        def deleteRegistrationCode(
          request: DeleteRegistrationCodeRequest
        ): Kleisli[M, IotClient, DeleteRegistrationCodeResponse] =
          primitive(_.deleteRegistrationCode(request))

        def deleteRoleAlias(
          request: DeleteRoleAliasRequest
        ): Kleisli[M, IotClient, DeleteRoleAliasResponse] =
          primitive(_.deleteRoleAlias(request))

        def deleteScheduledAudit(
          request: DeleteScheduledAuditRequest
        ): Kleisli[M, IotClient, DeleteScheduledAuditResponse] =
          primitive(_.deleteScheduledAudit(request))

        def deleteSecurityProfile(
          request: DeleteSecurityProfileRequest
        ): Kleisli[M, IotClient, DeleteSecurityProfileResponse] =
          primitive(_.deleteSecurityProfile(request))

        def deleteStream(
          request: DeleteStreamRequest
        ): Kleisli[M, IotClient, DeleteStreamResponse] =
          primitive(_.deleteStream(request))

        def deleteThing(
          request: DeleteThingRequest
        ): Kleisli[M, IotClient, DeleteThingResponse] =
          primitive(_.deleteThing(request))

        def deleteThingGroup(
          request: DeleteThingGroupRequest
        ): Kleisli[M, IotClient, DeleteThingGroupResponse] =
          primitive(_.deleteThingGroup(request))

        def deleteThingType(
          request: DeleteThingTypeRequest
        ): Kleisli[M, IotClient, DeleteThingTypeResponse] =
          primitive(_.deleteThingType(request))

        def deleteTopicRule(
          request: DeleteTopicRuleRequest
        ): Kleisli[M, IotClient, DeleteTopicRuleResponse] =
          primitive(_.deleteTopicRule(request))

        def deleteTopicRuleDestination(
          request: DeleteTopicRuleDestinationRequest
        ): Kleisli[M, IotClient, DeleteTopicRuleDestinationResponse] =
          primitive(_.deleteTopicRuleDestination(request))

        def deleteV2LoggingLevel(
          request: DeleteV2LoggingLevelRequest
        ): Kleisli[M, IotClient, DeleteV2LoggingLevelResponse] =
          primitive(_.deleteV2LoggingLevel(request))

        def deprecateThingType(
          request: DeprecateThingTypeRequest
        ): Kleisli[M, IotClient, DeprecateThingTypeResponse] =
          primitive(_.deprecateThingType(request))

        def describeAccountAuditConfiguration(
          request: DescribeAccountAuditConfigurationRequest
        ): Kleisli[M, IotClient, DescribeAccountAuditConfigurationResponse] =
          primitive(_.describeAccountAuditConfiguration(request))

        def describeAuditFinding(
          request: DescribeAuditFindingRequest
        ): Kleisli[M, IotClient, DescribeAuditFindingResponse] =
          primitive(_.describeAuditFinding(request))

        def describeAuditMitigationActionsTask(
          request: DescribeAuditMitigationActionsTaskRequest
        ): Kleisli[M, IotClient, DescribeAuditMitigationActionsTaskResponse] =
          primitive(_.describeAuditMitigationActionsTask(request))

        def describeAuditSuppression(
          request: DescribeAuditSuppressionRequest
        ): Kleisli[M, IotClient, DescribeAuditSuppressionResponse] =
          primitive(_.describeAuditSuppression(request))

        def describeAuditTask(
          request: DescribeAuditTaskRequest
        ): Kleisli[M, IotClient, DescribeAuditTaskResponse] =
          primitive(_.describeAuditTask(request))

        def describeAuthorizer(
          request: DescribeAuthorizerRequest
        ): Kleisli[M, IotClient, DescribeAuthorizerResponse] =
          primitive(_.describeAuthorizer(request))

        def describeBillingGroup(
          request: DescribeBillingGroupRequest
        ): Kleisli[M, IotClient, DescribeBillingGroupResponse] =
          primitive(_.describeBillingGroup(request))

        def describeCACertificate(
          request: DescribeCaCertificateRequest
        ): Kleisli[M, IotClient, DescribeCaCertificateResponse] =
          primitive(_.describeCACertificate(request))

        def describeCertificate(
          request: DescribeCertificateRequest
        ): Kleisli[M, IotClient, DescribeCertificateResponse] =
          primitive(_.describeCertificate(request))

        def describeCustomMetric(
          request: DescribeCustomMetricRequest
        ): Kleisli[M, IotClient, DescribeCustomMetricResponse] =
          primitive(_.describeCustomMetric(request))

        def describeDefaultAuthorizer(
          request: DescribeDefaultAuthorizerRequest
        ): Kleisli[M, IotClient, DescribeDefaultAuthorizerResponse] =
          primitive(_.describeDefaultAuthorizer(request))

        def describeDetectMitigationActionsTask(
          request: DescribeDetectMitigationActionsTaskRequest
        ): Kleisli[M, IotClient, DescribeDetectMitigationActionsTaskResponse] =
          primitive(_.describeDetectMitigationActionsTask(request))

        def describeDimension(
          request: DescribeDimensionRequest
        ): Kleisli[M, IotClient, DescribeDimensionResponse] =
          primitive(_.describeDimension(request))

        def describeDomainConfiguration(
          request: DescribeDomainConfigurationRequest
        ): Kleisli[M, IotClient, DescribeDomainConfigurationResponse] =
          primitive(_.describeDomainConfiguration(request))

        def describeEndpoint(
          request: DescribeEndpointRequest
        ): Kleisli[M, IotClient, DescribeEndpointResponse] =
          primitive(_.describeEndpoint(request))

        def describeEventConfigurations(
          request: DescribeEventConfigurationsRequest
        ): Kleisli[M, IotClient, DescribeEventConfigurationsResponse] =
          primitive(_.describeEventConfigurations(request))

        def describeIndex(
          request: DescribeIndexRequest
        ): Kleisli[M, IotClient, DescribeIndexResponse] =
          primitive(_.describeIndex(request))

        def describeJob(
          request: DescribeJobRequest
        ): Kleisli[M, IotClient, DescribeJobResponse] =
          primitive(_.describeJob(request))

        def describeJobExecution(
          request: DescribeJobExecutionRequest
        ): Kleisli[M, IotClient, DescribeJobExecutionResponse] =
          primitive(_.describeJobExecution(request))

        def describeJobTemplate(
          request: DescribeJobTemplateRequest
        ): Kleisli[M, IotClient, DescribeJobTemplateResponse] =
          primitive(_.describeJobTemplate(request))

        def describeMitigationAction(
          request: DescribeMitigationActionRequest
        ): Kleisli[M, IotClient, DescribeMitigationActionResponse] =
          primitive(_.describeMitigationAction(request))

        def describeProvisioningTemplate(
          request: DescribeProvisioningTemplateRequest
        ): Kleisli[M, IotClient, DescribeProvisioningTemplateResponse] =
          primitive(_.describeProvisioningTemplate(request))

        def describeProvisioningTemplateVersion(
          request: DescribeProvisioningTemplateVersionRequest
        ): Kleisli[M, IotClient, DescribeProvisioningTemplateVersionResponse] =
          primitive(_.describeProvisioningTemplateVersion(request))

        def describeRoleAlias(
          request: DescribeRoleAliasRequest
        ): Kleisli[M, IotClient, DescribeRoleAliasResponse] =
          primitive(_.describeRoleAlias(request))

        def describeScheduledAudit(
          request: DescribeScheduledAuditRequest
        ): Kleisli[M, IotClient, DescribeScheduledAuditResponse] =
          primitive(_.describeScheduledAudit(request))

        def describeSecurityProfile(
          request: DescribeSecurityProfileRequest
        ): Kleisli[M, IotClient, DescribeSecurityProfileResponse] =
          primitive(_.describeSecurityProfile(request))

        def describeStream(
          request: DescribeStreamRequest
        ): Kleisli[M, IotClient, DescribeStreamResponse] =
          primitive(_.describeStream(request))

        def describeThing(
          request: DescribeThingRequest
        ): Kleisli[M, IotClient, DescribeThingResponse] =
          primitive(_.describeThing(request))

        def describeThingGroup(
          request: DescribeThingGroupRequest
        ): Kleisli[M, IotClient, DescribeThingGroupResponse] =
          primitive(_.describeThingGroup(request))

        def describeThingRegistrationTask(
          request: DescribeThingRegistrationTaskRequest
        ): Kleisli[M, IotClient, DescribeThingRegistrationTaskResponse] =
          primitive(_.describeThingRegistrationTask(request))

        def describeThingType(
          request: DescribeThingTypeRequest
        ): Kleisli[M, IotClient, DescribeThingTypeResponse] =
          primitive(_.describeThingType(request))

        def detachPolicy(
          request: DetachPolicyRequest
        ): Kleisli[M, IotClient, DetachPolicyResponse] =
          primitive(_.detachPolicy(request))

        def detachSecurityProfile(
          request: DetachSecurityProfileRequest
        ): Kleisli[M, IotClient, DetachSecurityProfileResponse] =
          primitive(_.detachSecurityProfile(request))

        def detachThingPrincipal(
          request: DetachThingPrincipalRequest
        ): Kleisli[M, IotClient, DetachThingPrincipalResponse] =
          primitive(_.detachThingPrincipal(request))

        def disableTopicRule(
          request: DisableTopicRuleRequest
        ): Kleisli[M, IotClient, DisableTopicRuleResponse] =
          primitive(_.disableTopicRule(request))

        def enableTopicRule(
          request: EnableTopicRuleRequest
        ): Kleisli[M, IotClient, EnableTopicRuleResponse] =
          primitive(_.enableTopicRule(request))

        def getBehaviorModelTrainingSummaries(
          request: GetBehaviorModelTrainingSummariesRequest
        ): Kleisli[M, IotClient, GetBehaviorModelTrainingSummariesResponse] =
          primitive(_.getBehaviorModelTrainingSummaries(request))

        def getCardinality(
          request: GetCardinalityRequest
        ): Kleisli[M, IotClient, GetCardinalityResponse] =
          primitive(_.getCardinality(request))

        def getEffectivePolicies(
          request: GetEffectivePoliciesRequest
        ): Kleisli[M, IotClient, GetEffectivePoliciesResponse] =
          primitive(_.getEffectivePolicies(request))

        def getIndexingConfiguration(
          request: GetIndexingConfigurationRequest
        ): Kleisli[M, IotClient, GetIndexingConfigurationResponse] =
          primitive(_.getIndexingConfiguration(request))

        def getJobDocument(
          request: GetJobDocumentRequest
        ): Kleisli[M, IotClient, GetJobDocumentResponse] =
          primitive(_.getJobDocument(request))

        def getLoggingOptions(
          request: GetLoggingOptionsRequest
        ): Kleisli[M, IotClient, GetLoggingOptionsResponse] =
          primitive(_.getLoggingOptions(request))

        def getOTAUpdate(
          request: GetOtaUpdateRequest
        ): Kleisli[M, IotClient, GetOtaUpdateResponse] =
          primitive(_.getOTAUpdate(request))

        def getPercentiles(
          request: GetPercentilesRequest
        ): Kleisli[M, IotClient, GetPercentilesResponse] =
          primitive(_.getPercentiles(request))

        def getPolicy(
          request: GetPolicyRequest
        ): Kleisli[M, IotClient, GetPolicyResponse] =
          primitive(_.getPolicy(request))

        def getPolicyVersion(
          request: GetPolicyVersionRequest
        ): Kleisli[M, IotClient, GetPolicyVersionResponse] =
          primitive(_.getPolicyVersion(request))

        def getRegistrationCode(
          request: GetRegistrationCodeRequest
        ): Kleisli[M, IotClient, GetRegistrationCodeResponse] =
          primitive(_.getRegistrationCode(request))

        def getStatistics(
          request: GetStatisticsRequest
        ): Kleisli[M, IotClient, GetStatisticsResponse] =
          primitive(_.getStatistics(request))

        def getTopicRule(
          request: GetTopicRuleRequest
        ): Kleisli[M, IotClient, GetTopicRuleResponse] =
          primitive(_.getTopicRule(request))

        def getTopicRuleDestination(
          request: GetTopicRuleDestinationRequest
        ): Kleisli[M, IotClient, GetTopicRuleDestinationResponse] =
          primitive(_.getTopicRuleDestination(request))

        def getV2LoggingOptions(
          request: GetV2LoggingOptionsRequest
        ): Kleisli[M, IotClient, GetV2LoggingOptionsResponse] =
          primitive(_.getV2LoggingOptions(request))

        def listActiveViolations(
          request: ListActiveViolationsRequest
        ): Kleisli[M, IotClient, ListActiveViolationsResponse] =
          primitive(_.listActiveViolations(request))

        def listAttachedPolicies(
          request: ListAttachedPoliciesRequest
        ): Kleisli[M, IotClient, ListAttachedPoliciesResponse] =
          primitive(_.listAttachedPolicies(request))

        def listAuditFindings(
          request: ListAuditFindingsRequest
        ): Kleisli[M, IotClient, ListAuditFindingsResponse] =
          primitive(_.listAuditFindings(request))

        def listAuditMitigationActionsExecutions(
          request: ListAuditMitigationActionsExecutionsRequest
        ): Kleisli[M, IotClient, ListAuditMitigationActionsExecutionsResponse] =
          primitive(_.listAuditMitigationActionsExecutions(request))

        def listAuditMitigationActionsTasks(
          request: ListAuditMitigationActionsTasksRequest
        ): Kleisli[M, IotClient, ListAuditMitigationActionsTasksResponse] =
          primitive(_.listAuditMitigationActionsTasks(request))

        def listAuditSuppressions(
          request: ListAuditSuppressionsRequest
        ): Kleisli[M, IotClient, ListAuditSuppressionsResponse] =
          primitive(_.listAuditSuppressions(request))

        def listAuditTasks(
          request: ListAuditTasksRequest
        ): Kleisli[M, IotClient, ListAuditTasksResponse] =
          primitive(_.listAuditTasks(request))

        def listAuthorizers(
          request: ListAuthorizersRequest
        ): Kleisli[M, IotClient, ListAuthorizersResponse] =
          primitive(_.listAuthorizers(request))

        def listBillingGroups(
          request: ListBillingGroupsRequest
        ): Kleisli[M, IotClient, ListBillingGroupsResponse] =
          primitive(_.listBillingGroups(request))

        def listCACertificates(
          request: ListCaCertificatesRequest
        ): Kleisli[M, IotClient, ListCaCertificatesResponse] =
          primitive(_.listCACertificates(request))

        def listCertificates(
          request: ListCertificatesRequest
        ): Kleisli[M, IotClient, ListCertificatesResponse] =
          primitive(_.listCertificates(request))

        def listCertificatesByCA(
          request: ListCertificatesByCaRequest
        ): Kleisli[M, IotClient, ListCertificatesByCaResponse] =
          primitive(_.listCertificatesByCA(request))

        def listCustomMetrics(
          request: ListCustomMetricsRequest
        ): Kleisli[M, IotClient, ListCustomMetricsResponse] =
          primitive(_.listCustomMetrics(request))

        def listDetectMitigationActionsExecutions(
          request: ListDetectMitigationActionsExecutionsRequest
        ): Kleisli[M, IotClient, ListDetectMitigationActionsExecutionsResponse] =
          primitive(_.listDetectMitigationActionsExecutions(request))

        def listDetectMitigationActionsTasks(
          request: ListDetectMitigationActionsTasksRequest
        ): Kleisli[M, IotClient, ListDetectMitigationActionsTasksResponse] =
          primitive(_.listDetectMitigationActionsTasks(request))

        def listDimensions(
          request: ListDimensionsRequest
        ): Kleisli[M, IotClient, ListDimensionsResponse] =
          primitive(_.listDimensions(request))

        def listDomainConfigurations(
          request: ListDomainConfigurationsRequest
        ): Kleisli[M, IotClient, ListDomainConfigurationsResponse] =
          primitive(_.listDomainConfigurations(request))

        def listIndices(
          request: ListIndicesRequest
        ): Kleisli[M, IotClient, ListIndicesResponse] =
          primitive(_.listIndices(request))

        def listJobExecutionsForJob(
          request: ListJobExecutionsForJobRequest
        ): Kleisli[M, IotClient, ListJobExecutionsForJobResponse] =
          primitive(_.listJobExecutionsForJob(request))

        def listJobExecutionsForThing(
          request: ListJobExecutionsForThingRequest
        ): Kleisli[M, IotClient, ListJobExecutionsForThingResponse] =
          primitive(_.listJobExecutionsForThing(request))

        def listJobTemplates(
          request: ListJobTemplatesRequest
        ): Kleisli[M, IotClient, ListJobTemplatesResponse] =
          primitive(_.listJobTemplates(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, IotClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listMitigationActions(
          request: ListMitigationActionsRequest
        ): Kleisli[M, IotClient, ListMitigationActionsResponse] =
          primitive(_.listMitigationActions(request))

        def listOTAUpdates(
          request: ListOtaUpdatesRequest
        ): Kleisli[M, IotClient, ListOtaUpdatesResponse] =
          primitive(_.listOTAUpdates(request))

        def listOutgoingCertificates(
          request: ListOutgoingCertificatesRequest
        ): Kleisli[M, IotClient, ListOutgoingCertificatesResponse] =
          primitive(_.listOutgoingCertificates(request))

        def listPolicies(
          request: ListPoliciesRequest
        ): Kleisli[M, IotClient, ListPoliciesResponse] =
          primitive(_.listPolicies(request))

        def listPolicyVersions(
          request: ListPolicyVersionsRequest
        ): Kleisli[M, IotClient, ListPolicyVersionsResponse] =
          primitive(_.listPolicyVersions(request))

        def listPrincipalThings(
          request: ListPrincipalThingsRequest
        ): Kleisli[M, IotClient, ListPrincipalThingsResponse] =
          primitive(_.listPrincipalThings(request))

        def listProvisioningTemplateVersions(
          request: ListProvisioningTemplateVersionsRequest
        ): Kleisli[M, IotClient, ListProvisioningTemplateVersionsResponse] =
          primitive(_.listProvisioningTemplateVersions(request))

        def listProvisioningTemplates(
          request: ListProvisioningTemplatesRequest
        ): Kleisli[M, IotClient, ListProvisioningTemplatesResponse] =
          primitive(_.listProvisioningTemplates(request))

        def listRoleAliases(
          request: ListRoleAliasesRequest
        ): Kleisli[M, IotClient, ListRoleAliasesResponse] =
          primitive(_.listRoleAliases(request))

        def listScheduledAudits(
          request: ListScheduledAuditsRequest
        ): Kleisli[M, IotClient, ListScheduledAuditsResponse] =
          primitive(_.listScheduledAudits(request))

        def listSecurityProfiles(
          request: ListSecurityProfilesRequest
        ): Kleisli[M, IotClient, ListSecurityProfilesResponse] =
          primitive(_.listSecurityProfiles(request))

        def listSecurityProfilesForTarget(
          request: ListSecurityProfilesForTargetRequest
        ): Kleisli[M, IotClient, ListSecurityProfilesForTargetResponse] =
          primitive(_.listSecurityProfilesForTarget(request))

        def listStreams(
          request: ListStreamsRequest
        ): Kleisli[M, IotClient, ListStreamsResponse] =
          primitive(_.listStreams(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IotClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTargetsForPolicy(
          request: ListTargetsForPolicyRequest
        ): Kleisli[M, IotClient, ListTargetsForPolicyResponse] =
          primitive(_.listTargetsForPolicy(request))

        def listTargetsForSecurityProfile(
          request: ListTargetsForSecurityProfileRequest
        ): Kleisli[M, IotClient, ListTargetsForSecurityProfileResponse] =
          primitive(_.listTargetsForSecurityProfile(request))

        def listThingGroups(
          request: ListThingGroupsRequest
        ): Kleisli[M, IotClient, ListThingGroupsResponse] =
          primitive(_.listThingGroups(request))

        def listThingGroupsForThing(
          request: ListThingGroupsForThingRequest
        ): Kleisli[M, IotClient, ListThingGroupsForThingResponse] =
          primitive(_.listThingGroupsForThing(request))

        def listThingPrincipals(
          request: ListThingPrincipalsRequest
        ): Kleisli[M, IotClient, ListThingPrincipalsResponse] =
          primitive(_.listThingPrincipals(request))

        def listThingRegistrationTaskReports(
          request: ListThingRegistrationTaskReportsRequest
        ): Kleisli[M, IotClient, ListThingRegistrationTaskReportsResponse] =
          primitive(_.listThingRegistrationTaskReports(request))

        def listThingRegistrationTasks(
          request: ListThingRegistrationTasksRequest
        ): Kleisli[M, IotClient, ListThingRegistrationTasksResponse] =
          primitive(_.listThingRegistrationTasks(request))

        def listThingTypes(
          request: ListThingTypesRequest
        ): Kleisli[M, IotClient, ListThingTypesResponse] =
          primitive(_.listThingTypes(request))

        def listThings(
          request: ListThingsRequest
        ): Kleisli[M, IotClient, ListThingsResponse] =
          primitive(_.listThings(request))

        def listThingsInBillingGroup(
          request: ListThingsInBillingGroupRequest
        ): Kleisli[M, IotClient, ListThingsInBillingGroupResponse] =
          primitive(_.listThingsInBillingGroup(request))

        def listThingsInThingGroup(
          request: ListThingsInThingGroupRequest
        ): Kleisli[M, IotClient, ListThingsInThingGroupResponse] =
          primitive(_.listThingsInThingGroup(request))

        def listTopicRuleDestinations(
          request: ListTopicRuleDestinationsRequest
        ): Kleisli[M, IotClient, ListTopicRuleDestinationsResponse] =
          primitive(_.listTopicRuleDestinations(request))

        def listTopicRules(
          request: ListTopicRulesRequest
        ): Kleisli[M, IotClient, ListTopicRulesResponse] =
          primitive(_.listTopicRules(request))

        def listV2LoggingLevels(
          request: ListV2LoggingLevelsRequest
        ): Kleisli[M, IotClient, ListV2LoggingLevelsResponse] =
          primitive(_.listV2LoggingLevels(request))

        def listViolationEvents(
          request: ListViolationEventsRequest
        ): Kleisli[M, IotClient, ListViolationEventsResponse] =
          primitive(_.listViolationEvents(request))

        def registerCACertificate(
          request: RegisterCaCertificateRequest
        ): Kleisli[M, IotClient, RegisterCaCertificateResponse] =
          primitive(_.registerCACertificate(request))

        def registerCertificate(
          request: RegisterCertificateRequest
        ): Kleisli[M, IotClient, RegisterCertificateResponse] =
          primitive(_.registerCertificate(request))

        def registerCertificateWithoutCA(
          request: RegisterCertificateWithoutCaRequest
        ): Kleisli[M, IotClient, RegisterCertificateWithoutCaResponse] =
          primitive(_.registerCertificateWithoutCA(request))

        def registerThing(
          request: RegisterThingRequest
        ): Kleisli[M, IotClient, RegisterThingResponse] =
          primitive(_.registerThing(request))

        def rejectCertificateTransfer(
          request: RejectCertificateTransferRequest
        ): Kleisli[M, IotClient, RejectCertificateTransferResponse] =
          primitive(_.rejectCertificateTransfer(request))

        def removeThingFromBillingGroup(
          request: RemoveThingFromBillingGroupRequest
        ): Kleisli[M, IotClient, RemoveThingFromBillingGroupResponse] =
          primitive(_.removeThingFromBillingGroup(request))

        def removeThingFromThingGroup(
          request: RemoveThingFromThingGroupRequest
        ): Kleisli[M, IotClient, RemoveThingFromThingGroupResponse] =
          primitive(_.removeThingFromThingGroup(request))

        def replaceTopicRule(
          request: ReplaceTopicRuleRequest
        ): Kleisli[M, IotClient, ReplaceTopicRuleResponse] =
          primitive(_.replaceTopicRule(request))

        def searchIndex(
          request: SearchIndexRequest
        ): Kleisli[M, IotClient, SearchIndexResponse] =
          primitive(_.searchIndex(request))

        def setDefaultAuthorizer(
          request: SetDefaultAuthorizerRequest
        ): Kleisli[M, IotClient, SetDefaultAuthorizerResponse] =
          primitive(_.setDefaultAuthorizer(request))

        def setDefaultPolicyVersion(
          request: SetDefaultPolicyVersionRequest
        ): Kleisli[M, IotClient, SetDefaultPolicyVersionResponse] =
          primitive(_.setDefaultPolicyVersion(request))

        def setLoggingOptions(
          request: SetLoggingOptionsRequest
        ): Kleisli[M, IotClient, SetLoggingOptionsResponse] =
          primitive(_.setLoggingOptions(request))

        def setV2LoggingLevel(
          request: SetV2LoggingLevelRequest
        ): Kleisli[M, IotClient, SetV2LoggingLevelResponse] =
          primitive(_.setV2LoggingLevel(request))

        def setV2LoggingOptions(
          request: SetV2LoggingOptionsRequest
        ): Kleisli[M, IotClient, SetV2LoggingOptionsResponse] =
          primitive(_.setV2LoggingOptions(request))

        def startAuditMitigationActionsTask(
          request: StartAuditMitigationActionsTaskRequest
        ): Kleisli[M, IotClient, StartAuditMitigationActionsTaskResponse] =
          primitive(_.startAuditMitigationActionsTask(request))

        def startDetectMitigationActionsTask(
          request: StartDetectMitigationActionsTaskRequest
        ): Kleisli[M, IotClient, StartDetectMitigationActionsTaskResponse] =
          primitive(_.startDetectMitigationActionsTask(request))

        def startOnDemandAuditTask(
          request: StartOnDemandAuditTaskRequest
        ): Kleisli[M, IotClient, StartOnDemandAuditTaskResponse] =
          primitive(_.startOnDemandAuditTask(request))

        def startThingRegistrationTask(
          request: StartThingRegistrationTaskRequest
        ): Kleisli[M, IotClient, StartThingRegistrationTaskResponse] =
          primitive(_.startThingRegistrationTask(request))

        def stopThingRegistrationTask(
          request: StopThingRegistrationTaskRequest
        ): Kleisli[M, IotClient, StopThingRegistrationTaskResponse] =
          primitive(_.stopThingRegistrationTask(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IotClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testAuthorization(
          request: TestAuthorizationRequest
        ): Kleisli[M, IotClient, TestAuthorizationResponse] =
          primitive(_.testAuthorization(request))

        def testInvokeAuthorizer(
          request: TestInvokeAuthorizerRequest
        ): Kleisli[M, IotClient, TestInvokeAuthorizerResponse] =
          primitive(_.testInvokeAuthorizer(request))

        def transferCertificate(
          request: TransferCertificateRequest
        ): Kleisli[M, IotClient, TransferCertificateResponse] =
          primitive(_.transferCertificate(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IotClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccountAuditConfiguration(
          request: UpdateAccountAuditConfigurationRequest
        ): Kleisli[M, IotClient, UpdateAccountAuditConfigurationResponse] =
          primitive(_.updateAccountAuditConfiguration(request))

        def updateAuditSuppression(
          request: UpdateAuditSuppressionRequest
        ): Kleisli[M, IotClient, UpdateAuditSuppressionResponse] =
          primitive(_.updateAuditSuppression(request))

        def updateAuthorizer(
          request: UpdateAuthorizerRequest
        ): Kleisli[M, IotClient, UpdateAuthorizerResponse] =
          primitive(_.updateAuthorizer(request))

        def updateBillingGroup(
          request: UpdateBillingGroupRequest
        ): Kleisli[M, IotClient, UpdateBillingGroupResponse] =
          primitive(_.updateBillingGroup(request))

        def updateCACertificate(
          request: UpdateCaCertificateRequest
        ): Kleisli[M, IotClient, UpdateCaCertificateResponse] =
          primitive(_.updateCACertificate(request))

        def updateCertificate(
          request: UpdateCertificateRequest
        ): Kleisli[M, IotClient, UpdateCertificateResponse] =
          primitive(_.updateCertificate(request))

        def updateCustomMetric(
          request: UpdateCustomMetricRequest
        ): Kleisli[M, IotClient, UpdateCustomMetricResponse] =
          primitive(_.updateCustomMetric(request))

        def updateDimension(
          request: UpdateDimensionRequest
        ): Kleisli[M, IotClient, UpdateDimensionResponse] =
          primitive(_.updateDimension(request))

        def updateDomainConfiguration(
          request: UpdateDomainConfigurationRequest
        ): Kleisli[M, IotClient, UpdateDomainConfigurationResponse] =
          primitive(_.updateDomainConfiguration(request))

        def updateDynamicThingGroup(
          request: UpdateDynamicThingGroupRequest
        ): Kleisli[M, IotClient, UpdateDynamicThingGroupResponse] =
          primitive(_.updateDynamicThingGroup(request))

        def updateEventConfigurations(
          request: UpdateEventConfigurationsRequest
        ): Kleisli[M, IotClient, UpdateEventConfigurationsResponse] =
          primitive(_.updateEventConfigurations(request))

        def updateIndexingConfiguration(
          request: UpdateIndexingConfigurationRequest
        ): Kleisli[M, IotClient, UpdateIndexingConfigurationResponse] =
          primitive(_.updateIndexingConfiguration(request))

        def updateJob(
          request: UpdateJobRequest
        ): Kleisli[M, IotClient, UpdateJobResponse] =
          primitive(_.updateJob(request))

        def updateMitigationAction(
          request: UpdateMitigationActionRequest
        ): Kleisli[M, IotClient, UpdateMitigationActionResponse] =
          primitive(_.updateMitigationAction(request))

        def updateProvisioningTemplate(
          request: UpdateProvisioningTemplateRequest
        ): Kleisli[M, IotClient, UpdateProvisioningTemplateResponse] =
          primitive(_.updateProvisioningTemplate(request))

        def updateRoleAlias(
          request: UpdateRoleAliasRequest
        ): Kleisli[M, IotClient, UpdateRoleAliasResponse] =
          primitive(_.updateRoleAlias(request))

        def updateScheduledAudit(
          request: UpdateScheduledAuditRequest
        ): Kleisli[M, IotClient, UpdateScheduledAuditResponse] =
          primitive(_.updateScheduledAudit(request))

        def updateSecurityProfile(
          request: UpdateSecurityProfileRequest
        ): Kleisli[M, IotClient, UpdateSecurityProfileResponse] =
          primitive(_.updateSecurityProfile(request))

        def updateStream(
          request: UpdateStreamRequest
        ): Kleisli[M, IotClient, UpdateStreamResponse] =
          primitive(_.updateStream(request))

        def updateThing(
          request: UpdateThingRequest
        ): Kleisli[M, IotClient, UpdateThingResponse] =
          primitive(_.updateThing(request))

        def updateThingGroup(
          request: UpdateThingGroupRequest
        ): Kleisli[M, IotClient, UpdateThingGroupResponse] =
          primitive(_.updateThingGroup(request))

        def updateThingGroupsForThing(
          request: UpdateThingGroupsForThingRequest
        ): Kleisli[M, IotClient, UpdateThingGroupsForThingResponse] =
          primitive(_.updateThingGroupsForThing(request))

        def updateTopicRuleDestination(
          request: UpdateTopicRuleDestinationRequest
        ): Kleisli[M, IotClient, UpdateTopicRuleDestinationResponse] =
          primitive(_.updateTopicRuleDestination(request))

        def validateSecurityProfileBehaviors(
          request: ValidateSecurityProfileBehaviorsRequest
        ): Kleisli[M, IotClient, ValidateSecurityProfileBehaviorsResponse] =
          primitive(_.validateSecurityProfileBehaviors(request))

        def primitive[A](
          f: IotClient => A
        ): Kleisli[M, IotClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotOp ~> F) {
      final def apply[A](op: IotOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptCertificateTransfer(
        request: AcceptCertificateTransferRequest
      ): F[AcceptCertificateTransferResponse]

      def addThingToBillingGroup(
        request: AddThingToBillingGroupRequest
      ): F[AddThingToBillingGroupResponse]

      def addThingToThingGroup(
        request: AddThingToThingGroupRequest
      ): F[AddThingToThingGroupResponse]

      def associateTargetsWithJob(
        request: AssociateTargetsWithJobRequest
      ): F[AssociateTargetsWithJobResponse]

      def attachPolicy(
        request: AttachPolicyRequest
      ): F[AttachPolicyResponse]

      def attachSecurityProfile(
        request: AttachSecurityProfileRequest
      ): F[AttachSecurityProfileResponse]

      def attachThingPrincipal(
        request: AttachThingPrincipalRequest
      ): F[AttachThingPrincipalResponse]

      def cancelAuditMitigationActionsTask(
        request: CancelAuditMitigationActionsTaskRequest
      ): F[CancelAuditMitigationActionsTaskResponse]

      def cancelAuditTask(
        request: CancelAuditTaskRequest
      ): F[CancelAuditTaskResponse]

      def cancelCertificateTransfer(
        request: CancelCertificateTransferRequest
      ): F[CancelCertificateTransferResponse]

      def cancelDetectMitigationActionsTask(
        request: CancelDetectMitigationActionsTaskRequest
      ): F[CancelDetectMitigationActionsTaskResponse]

      def cancelJob(
        request: CancelJobRequest
      ): F[CancelJobResponse]

      def cancelJobExecution(
        request: CancelJobExecutionRequest
      ): F[CancelJobExecutionResponse]

      def clearDefaultAuthorizer(
        request: ClearDefaultAuthorizerRequest
      ): F[ClearDefaultAuthorizerResponse]

      def confirmTopicRuleDestination(
        request: ConfirmTopicRuleDestinationRequest
      ): F[ConfirmTopicRuleDestinationResponse]

      def createAuditSuppression(
        request: CreateAuditSuppressionRequest
      ): F[CreateAuditSuppressionResponse]

      def createAuthorizer(
        request: CreateAuthorizerRequest
      ): F[CreateAuthorizerResponse]

      def createBillingGroup(
        request: CreateBillingGroupRequest
      ): F[CreateBillingGroupResponse]

      def createCertificateFromCsr(
        request: CreateCertificateFromCsrRequest
      ): F[CreateCertificateFromCsrResponse]

      def createCustomMetric(
        request: CreateCustomMetricRequest
      ): F[CreateCustomMetricResponse]

      def createDimension(
        request: CreateDimensionRequest
      ): F[CreateDimensionResponse]

      def createDomainConfiguration(
        request: CreateDomainConfigurationRequest
      ): F[CreateDomainConfigurationResponse]

      def createDynamicThingGroup(
        request: CreateDynamicThingGroupRequest
      ): F[CreateDynamicThingGroupResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def createJobTemplate(
        request: CreateJobTemplateRequest
      ): F[CreateJobTemplateResponse]

      def createKeysAndCertificate(
        request: CreateKeysAndCertificateRequest
      ): F[CreateKeysAndCertificateResponse]

      def createMitigationAction(
        request: CreateMitigationActionRequest
      ): F[CreateMitigationActionResponse]

      def createOTAUpdate(
        request: CreateOtaUpdateRequest
      ): F[CreateOtaUpdateResponse]

      def createPolicy(
        request: CreatePolicyRequest
      ): F[CreatePolicyResponse]

      def createPolicyVersion(
        request: CreatePolicyVersionRequest
      ): F[CreatePolicyVersionResponse]

      def createProvisioningClaim(
        request: CreateProvisioningClaimRequest
      ): F[CreateProvisioningClaimResponse]

      def createProvisioningTemplate(
        request: CreateProvisioningTemplateRequest
      ): F[CreateProvisioningTemplateResponse]

      def createProvisioningTemplateVersion(
        request: CreateProvisioningTemplateVersionRequest
      ): F[CreateProvisioningTemplateVersionResponse]

      def createRoleAlias(
        request: CreateRoleAliasRequest
      ): F[CreateRoleAliasResponse]

      def createScheduledAudit(
        request: CreateScheduledAuditRequest
      ): F[CreateScheduledAuditResponse]

      def createSecurityProfile(
        request: CreateSecurityProfileRequest
      ): F[CreateSecurityProfileResponse]

      def createStream(
        request: CreateStreamRequest
      ): F[CreateStreamResponse]

      def createThing(
        request: CreateThingRequest
      ): F[CreateThingResponse]

      def createThingGroup(
        request: CreateThingGroupRequest
      ): F[CreateThingGroupResponse]

      def createThingType(
        request: CreateThingTypeRequest
      ): F[CreateThingTypeResponse]

      def createTopicRule(
        request: CreateTopicRuleRequest
      ): F[CreateTopicRuleResponse]

      def createTopicRuleDestination(
        request: CreateTopicRuleDestinationRequest
      ): F[CreateTopicRuleDestinationResponse]

      def deleteAccountAuditConfiguration(
        request: DeleteAccountAuditConfigurationRequest
      ): F[DeleteAccountAuditConfigurationResponse]

      def deleteAuditSuppression(
        request: DeleteAuditSuppressionRequest
      ): F[DeleteAuditSuppressionResponse]

      def deleteAuthorizer(
        request: DeleteAuthorizerRequest
      ): F[DeleteAuthorizerResponse]

      def deleteBillingGroup(
        request: DeleteBillingGroupRequest
      ): F[DeleteBillingGroupResponse]

      def deleteCACertificate(
        request: DeleteCaCertificateRequest
      ): F[DeleteCaCertificateResponse]

      def deleteCertificate(
        request: DeleteCertificateRequest
      ): F[DeleteCertificateResponse]

      def deleteCustomMetric(
        request: DeleteCustomMetricRequest
      ): F[DeleteCustomMetricResponse]

      def deleteDimension(
        request: DeleteDimensionRequest
      ): F[DeleteDimensionResponse]

      def deleteDomainConfiguration(
        request: DeleteDomainConfigurationRequest
      ): F[DeleteDomainConfigurationResponse]

      def deleteDynamicThingGroup(
        request: DeleteDynamicThingGroupRequest
      ): F[DeleteDynamicThingGroupResponse]

      def deleteJob(
        request: DeleteJobRequest
      ): F[DeleteJobResponse]

      def deleteJobExecution(
        request: DeleteJobExecutionRequest
      ): F[DeleteJobExecutionResponse]

      def deleteJobTemplate(
        request: DeleteJobTemplateRequest
      ): F[DeleteJobTemplateResponse]

      def deleteMitigationAction(
        request: DeleteMitigationActionRequest
      ): F[DeleteMitigationActionResponse]

      def deleteOTAUpdate(
        request: DeleteOtaUpdateRequest
      ): F[DeleteOtaUpdateResponse]

      def deletePolicy(
        request: DeletePolicyRequest
      ): F[DeletePolicyResponse]

      def deletePolicyVersion(
        request: DeletePolicyVersionRequest
      ): F[DeletePolicyVersionResponse]

      def deleteProvisioningTemplate(
        request: DeleteProvisioningTemplateRequest
      ): F[DeleteProvisioningTemplateResponse]

      def deleteProvisioningTemplateVersion(
        request: DeleteProvisioningTemplateVersionRequest
      ): F[DeleteProvisioningTemplateVersionResponse]

      def deleteRegistrationCode(
        request: DeleteRegistrationCodeRequest
      ): F[DeleteRegistrationCodeResponse]

      def deleteRoleAlias(
        request: DeleteRoleAliasRequest
      ): F[DeleteRoleAliasResponse]

      def deleteScheduledAudit(
        request: DeleteScheduledAuditRequest
      ): F[DeleteScheduledAuditResponse]

      def deleteSecurityProfile(
        request: DeleteSecurityProfileRequest
      ): F[DeleteSecurityProfileResponse]

      def deleteStream(
        request: DeleteStreamRequest
      ): F[DeleteStreamResponse]

      def deleteThing(
        request: DeleteThingRequest
      ): F[DeleteThingResponse]

      def deleteThingGroup(
        request: DeleteThingGroupRequest
      ): F[DeleteThingGroupResponse]

      def deleteThingType(
        request: DeleteThingTypeRequest
      ): F[DeleteThingTypeResponse]

      def deleteTopicRule(
        request: DeleteTopicRuleRequest
      ): F[DeleteTopicRuleResponse]

      def deleteTopicRuleDestination(
        request: DeleteTopicRuleDestinationRequest
      ): F[DeleteTopicRuleDestinationResponse]

      def deleteV2LoggingLevel(
        request: DeleteV2LoggingLevelRequest
      ): F[DeleteV2LoggingLevelResponse]

      def deprecateThingType(
        request: DeprecateThingTypeRequest
      ): F[DeprecateThingTypeResponse]

      def describeAccountAuditConfiguration(
        request: DescribeAccountAuditConfigurationRequest
      ): F[DescribeAccountAuditConfigurationResponse]

      def describeAuditFinding(
        request: DescribeAuditFindingRequest
      ): F[DescribeAuditFindingResponse]

      def describeAuditMitigationActionsTask(
        request: DescribeAuditMitigationActionsTaskRequest
      ): F[DescribeAuditMitigationActionsTaskResponse]

      def describeAuditSuppression(
        request: DescribeAuditSuppressionRequest
      ): F[DescribeAuditSuppressionResponse]

      def describeAuditTask(
        request: DescribeAuditTaskRequest
      ): F[DescribeAuditTaskResponse]

      def describeAuthorizer(
        request: DescribeAuthorizerRequest
      ): F[DescribeAuthorizerResponse]

      def describeBillingGroup(
        request: DescribeBillingGroupRequest
      ): F[DescribeBillingGroupResponse]

      def describeCACertificate(
        request: DescribeCaCertificateRequest
      ): F[DescribeCaCertificateResponse]

      def describeCertificate(
        request: DescribeCertificateRequest
      ): F[DescribeCertificateResponse]

      def describeCustomMetric(
        request: DescribeCustomMetricRequest
      ): F[DescribeCustomMetricResponse]

      def describeDefaultAuthorizer(
        request: DescribeDefaultAuthorizerRequest
      ): F[DescribeDefaultAuthorizerResponse]

      def describeDetectMitigationActionsTask(
        request: DescribeDetectMitigationActionsTaskRequest
      ): F[DescribeDetectMitigationActionsTaskResponse]

      def describeDimension(
        request: DescribeDimensionRequest
      ): F[DescribeDimensionResponse]

      def describeDomainConfiguration(
        request: DescribeDomainConfigurationRequest
      ): F[DescribeDomainConfigurationResponse]

      def describeEndpoint(
        request: DescribeEndpointRequest
      ): F[DescribeEndpointResponse]

      def describeEventConfigurations(
        request: DescribeEventConfigurationsRequest
      ): F[DescribeEventConfigurationsResponse]

      def describeIndex(
        request: DescribeIndexRequest
      ): F[DescribeIndexResponse]

      def describeJob(
        request: DescribeJobRequest
      ): F[DescribeJobResponse]

      def describeJobExecution(
        request: DescribeJobExecutionRequest
      ): F[DescribeJobExecutionResponse]

      def describeJobTemplate(
        request: DescribeJobTemplateRequest
      ): F[DescribeJobTemplateResponse]

      def describeMitigationAction(
        request: DescribeMitigationActionRequest
      ): F[DescribeMitigationActionResponse]

      def describeProvisioningTemplate(
        request: DescribeProvisioningTemplateRequest
      ): F[DescribeProvisioningTemplateResponse]

      def describeProvisioningTemplateVersion(
        request: DescribeProvisioningTemplateVersionRequest
      ): F[DescribeProvisioningTemplateVersionResponse]

      def describeRoleAlias(
        request: DescribeRoleAliasRequest
      ): F[DescribeRoleAliasResponse]

      def describeScheduledAudit(
        request: DescribeScheduledAuditRequest
      ): F[DescribeScheduledAuditResponse]

      def describeSecurityProfile(
        request: DescribeSecurityProfileRequest
      ): F[DescribeSecurityProfileResponse]

      def describeStream(
        request: DescribeStreamRequest
      ): F[DescribeStreamResponse]

      def describeThing(
        request: DescribeThingRequest
      ): F[DescribeThingResponse]

      def describeThingGroup(
        request: DescribeThingGroupRequest
      ): F[DescribeThingGroupResponse]

      def describeThingRegistrationTask(
        request: DescribeThingRegistrationTaskRequest
      ): F[DescribeThingRegistrationTaskResponse]

      def describeThingType(
        request: DescribeThingTypeRequest
      ): F[DescribeThingTypeResponse]

      def detachPolicy(
        request: DetachPolicyRequest
      ): F[DetachPolicyResponse]

      def detachSecurityProfile(
        request: DetachSecurityProfileRequest
      ): F[DetachSecurityProfileResponse]

      def detachThingPrincipal(
        request: DetachThingPrincipalRequest
      ): F[DetachThingPrincipalResponse]

      def disableTopicRule(
        request: DisableTopicRuleRequest
      ): F[DisableTopicRuleResponse]

      def enableTopicRule(
        request: EnableTopicRuleRequest
      ): F[EnableTopicRuleResponse]

      def getBehaviorModelTrainingSummaries(
        request: GetBehaviorModelTrainingSummariesRequest
      ): F[GetBehaviorModelTrainingSummariesResponse]

      def getCardinality(
        request: GetCardinalityRequest
      ): F[GetCardinalityResponse]

      def getEffectivePolicies(
        request: GetEffectivePoliciesRequest
      ): F[GetEffectivePoliciesResponse]

      def getIndexingConfiguration(
        request: GetIndexingConfigurationRequest
      ): F[GetIndexingConfigurationResponse]

      def getJobDocument(
        request: GetJobDocumentRequest
      ): F[GetJobDocumentResponse]

      def getLoggingOptions(
        request: GetLoggingOptionsRequest
      ): F[GetLoggingOptionsResponse]

      def getOTAUpdate(
        request: GetOtaUpdateRequest
      ): F[GetOtaUpdateResponse]

      def getPercentiles(
        request: GetPercentilesRequest
      ): F[GetPercentilesResponse]

      def getPolicy(
        request: GetPolicyRequest
      ): F[GetPolicyResponse]

      def getPolicyVersion(
        request: GetPolicyVersionRequest
      ): F[GetPolicyVersionResponse]

      def getRegistrationCode(
        request: GetRegistrationCodeRequest
      ): F[GetRegistrationCodeResponse]

      def getStatistics(
        request: GetStatisticsRequest
      ): F[GetStatisticsResponse]

      def getTopicRule(
        request: GetTopicRuleRequest
      ): F[GetTopicRuleResponse]

      def getTopicRuleDestination(
        request: GetTopicRuleDestinationRequest
      ): F[GetTopicRuleDestinationResponse]

      def getV2LoggingOptions(
        request: GetV2LoggingOptionsRequest
      ): F[GetV2LoggingOptionsResponse]

      def listActiveViolations(
        request: ListActiveViolationsRequest
      ): F[ListActiveViolationsResponse]

      def listAttachedPolicies(
        request: ListAttachedPoliciesRequest
      ): F[ListAttachedPoliciesResponse]

      def listAuditFindings(
        request: ListAuditFindingsRequest
      ): F[ListAuditFindingsResponse]

      def listAuditMitigationActionsExecutions(
        request: ListAuditMitigationActionsExecutionsRequest
      ): F[ListAuditMitigationActionsExecutionsResponse]

      def listAuditMitigationActionsTasks(
        request: ListAuditMitigationActionsTasksRequest
      ): F[ListAuditMitigationActionsTasksResponse]

      def listAuditSuppressions(
        request: ListAuditSuppressionsRequest
      ): F[ListAuditSuppressionsResponse]

      def listAuditTasks(
        request: ListAuditTasksRequest
      ): F[ListAuditTasksResponse]

      def listAuthorizers(
        request: ListAuthorizersRequest
      ): F[ListAuthorizersResponse]

      def listBillingGroups(
        request: ListBillingGroupsRequest
      ): F[ListBillingGroupsResponse]

      def listCACertificates(
        request: ListCaCertificatesRequest
      ): F[ListCaCertificatesResponse]

      def listCertificates(
        request: ListCertificatesRequest
      ): F[ListCertificatesResponse]

      def listCertificatesByCA(
        request: ListCertificatesByCaRequest
      ): F[ListCertificatesByCaResponse]

      def listCustomMetrics(
        request: ListCustomMetricsRequest
      ): F[ListCustomMetricsResponse]

      def listDetectMitigationActionsExecutions(
        request: ListDetectMitigationActionsExecutionsRequest
      ): F[ListDetectMitigationActionsExecutionsResponse]

      def listDetectMitigationActionsTasks(
        request: ListDetectMitigationActionsTasksRequest
      ): F[ListDetectMitigationActionsTasksResponse]

      def listDimensions(
        request: ListDimensionsRequest
      ): F[ListDimensionsResponse]

      def listDomainConfigurations(
        request: ListDomainConfigurationsRequest
      ): F[ListDomainConfigurationsResponse]

      def listIndices(
        request: ListIndicesRequest
      ): F[ListIndicesResponse]

      def listJobExecutionsForJob(
        request: ListJobExecutionsForJobRequest
      ): F[ListJobExecutionsForJobResponse]

      def listJobExecutionsForThing(
        request: ListJobExecutionsForThingRequest
      ): F[ListJobExecutionsForThingResponse]

      def listJobTemplates(
        request: ListJobTemplatesRequest
      ): F[ListJobTemplatesResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listMitigationActions(
        request: ListMitigationActionsRequest
      ): F[ListMitigationActionsResponse]

      def listOTAUpdates(
        request: ListOtaUpdatesRequest
      ): F[ListOtaUpdatesResponse]

      def listOutgoingCertificates(
        request: ListOutgoingCertificatesRequest
      ): F[ListOutgoingCertificatesResponse]

      def listPolicies(
        request: ListPoliciesRequest
      ): F[ListPoliciesResponse]

      def listPolicyVersions(
        request: ListPolicyVersionsRequest
      ): F[ListPolicyVersionsResponse]

      def listPrincipalThings(
        request: ListPrincipalThingsRequest
      ): F[ListPrincipalThingsResponse]

      def listProvisioningTemplateVersions(
        request: ListProvisioningTemplateVersionsRequest
      ): F[ListProvisioningTemplateVersionsResponse]

      def listProvisioningTemplates(
        request: ListProvisioningTemplatesRequest
      ): F[ListProvisioningTemplatesResponse]

      def listRoleAliases(
        request: ListRoleAliasesRequest
      ): F[ListRoleAliasesResponse]

      def listScheduledAudits(
        request: ListScheduledAuditsRequest
      ): F[ListScheduledAuditsResponse]

      def listSecurityProfiles(
        request: ListSecurityProfilesRequest
      ): F[ListSecurityProfilesResponse]

      def listSecurityProfilesForTarget(
        request: ListSecurityProfilesForTargetRequest
      ): F[ListSecurityProfilesForTargetResponse]

      def listStreams(
        request: ListStreamsRequest
      ): F[ListStreamsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTargetsForPolicy(
        request: ListTargetsForPolicyRequest
      ): F[ListTargetsForPolicyResponse]

      def listTargetsForSecurityProfile(
        request: ListTargetsForSecurityProfileRequest
      ): F[ListTargetsForSecurityProfileResponse]

      def listThingGroups(
        request: ListThingGroupsRequest
      ): F[ListThingGroupsResponse]

      def listThingGroupsForThing(
        request: ListThingGroupsForThingRequest
      ): F[ListThingGroupsForThingResponse]

      def listThingPrincipals(
        request: ListThingPrincipalsRequest
      ): F[ListThingPrincipalsResponse]

      def listThingRegistrationTaskReports(
        request: ListThingRegistrationTaskReportsRequest
      ): F[ListThingRegistrationTaskReportsResponse]

      def listThingRegistrationTasks(
        request: ListThingRegistrationTasksRequest
      ): F[ListThingRegistrationTasksResponse]

      def listThingTypes(
        request: ListThingTypesRequest
      ): F[ListThingTypesResponse]

      def listThings(
        request: ListThingsRequest
      ): F[ListThingsResponse]

      def listThingsInBillingGroup(
        request: ListThingsInBillingGroupRequest
      ): F[ListThingsInBillingGroupResponse]

      def listThingsInThingGroup(
        request: ListThingsInThingGroupRequest
      ): F[ListThingsInThingGroupResponse]

      def listTopicRuleDestinations(
        request: ListTopicRuleDestinationsRequest
      ): F[ListTopicRuleDestinationsResponse]

      def listTopicRules(
        request: ListTopicRulesRequest
      ): F[ListTopicRulesResponse]

      def listV2LoggingLevels(
        request: ListV2LoggingLevelsRequest
      ): F[ListV2LoggingLevelsResponse]

      def listViolationEvents(
        request: ListViolationEventsRequest
      ): F[ListViolationEventsResponse]

      def registerCACertificate(
        request: RegisterCaCertificateRequest
      ): F[RegisterCaCertificateResponse]

      def registerCertificate(
        request: RegisterCertificateRequest
      ): F[RegisterCertificateResponse]

      def registerCertificateWithoutCA(
        request: RegisterCertificateWithoutCaRequest
      ): F[RegisterCertificateWithoutCaResponse]

      def registerThing(
        request: RegisterThingRequest
      ): F[RegisterThingResponse]

      def rejectCertificateTransfer(
        request: RejectCertificateTransferRequest
      ): F[RejectCertificateTransferResponse]

      def removeThingFromBillingGroup(
        request: RemoveThingFromBillingGroupRequest
      ): F[RemoveThingFromBillingGroupResponse]

      def removeThingFromThingGroup(
        request: RemoveThingFromThingGroupRequest
      ): F[RemoveThingFromThingGroupResponse]

      def replaceTopicRule(
        request: ReplaceTopicRuleRequest
      ): F[ReplaceTopicRuleResponse]

      def searchIndex(
        request: SearchIndexRequest
      ): F[SearchIndexResponse]

      def setDefaultAuthorizer(
        request: SetDefaultAuthorizerRequest
      ): F[SetDefaultAuthorizerResponse]

      def setDefaultPolicyVersion(
        request: SetDefaultPolicyVersionRequest
      ): F[SetDefaultPolicyVersionResponse]

      def setLoggingOptions(
        request: SetLoggingOptionsRequest
      ): F[SetLoggingOptionsResponse]

      def setV2LoggingLevel(
        request: SetV2LoggingLevelRequest
      ): F[SetV2LoggingLevelResponse]

      def setV2LoggingOptions(
        request: SetV2LoggingOptionsRequest
      ): F[SetV2LoggingOptionsResponse]

      def startAuditMitigationActionsTask(
        request: StartAuditMitigationActionsTaskRequest
      ): F[StartAuditMitigationActionsTaskResponse]

      def startDetectMitigationActionsTask(
        request: StartDetectMitigationActionsTaskRequest
      ): F[StartDetectMitigationActionsTaskResponse]

      def startOnDemandAuditTask(
        request: StartOnDemandAuditTaskRequest
      ): F[StartOnDemandAuditTaskResponse]

      def startThingRegistrationTask(
        request: StartThingRegistrationTaskRequest
      ): F[StartThingRegistrationTaskResponse]

      def stopThingRegistrationTask(
        request: StopThingRegistrationTaskRequest
      ): F[StopThingRegistrationTaskResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testAuthorization(
        request: TestAuthorizationRequest
      ): F[TestAuthorizationResponse]

      def testInvokeAuthorizer(
        request: TestInvokeAuthorizerRequest
      ): F[TestInvokeAuthorizerResponse]

      def transferCertificate(
        request: TransferCertificateRequest
      ): F[TransferCertificateResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccountAuditConfiguration(
        request: UpdateAccountAuditConfigurationRequest
      ): F[UpdateAccountAuditConfigurationResponse]

      def updateAuditSuppression(
        request: UpdateAuditSuppressionRequest
      ): F[UpdateAuditSuppressionResponse]

      def updateAuthorizer(
        request: UpdateAuthorizerRequest
      ): F[UpdateAuthorizerResponse]

      def updateBillingGroup(
        request: UpdateBillingGroupRequest
      ): F[UpdateBillingGroupResponse]

      def updateCACertificate(
        request: UpdateCaCertificateRequest
      ): F[UpdateCaCertificateResponse]

      def updateCertificate(
        request: UpdateCertificateRequest
      ): F[UpdateCertificateResponse]

      def updateCustomMetric(
        request: UpdateCustomMetricRequest
      ): F[UpdateCustomMetricResponse]

      def updateDimension(
        request: UpdateDimensionRequest
      ): F[UpdateDimensionResponse]

      def updateDomainConfiguration(
        request: UpdateDomainConfigurationRequest
      ): F[UpdateDomainConfigurationResponse]

      def updateDynamicThingGroup(
        request: UpdateDynamicThingGroupRequest
      ): F[UpdateDynamicThingGroupResponse]

      def updateEventConfigurations(
        request: UpdateEventConfigurationsRequest
      ): F[UpdateEventConfigurationsResponse]

      def updateIndexingConfiguration(
        request: UpdateIndexingConfigurationRequest
      ): F[UpdateIndexingConfigurationResponse]

      def updateJob(
        request: UpdateJobRequest
      ): F[UpdateJobResponse]

      def updateMitigationAction(
        request: UpdateMitigationActionRequest
      ): F[UpdateMitigationActionResponse]

      def updateProvisioningTemplate(
        request: UpdateProvisioningTemplateRequest
      ): F[UpdateProvisioningTemplateResponse]

      def updateRoleAlias(
        request: UpdateRoleAliasRequest
      ): F[UpdateRoleAliasResponse]

      def updateScheduledAudit(
        request: UpdateScheduledAuditRequest
      ): F[UpdateScheduledAuditResponse]

      def updateSecurityProfile(
        request: UpdateSecurityProfileRequest
      ): F[UpdateSecurityProfileResponse]

      def updateStream(
        request: UpdateStreamRequest
      ): F[UpdateStreamResponse]

      def updateThing(
        request: UpdateThingRequest
      ): F[UpdateThingResponse]

      def updateThingGroup(
        request: UpdateThingGroupRequest
      ): F[UpdateThingGroupResponse]

      def updateThingGroupsForThing(
        request: UpdateThingGroupsForThingRequest
      ): F[UpdateThingGroupsForThingResponse]

      def updateTopicRuleDestination(
        request: UpdateTopicRuleDestinationRequest
      ): F[UpdateTopicRuleDestinationResponse]

      def validateSecurityProfileBehaviors(
        request: ValidateSecurityProfileBehaviorsRequest
      ): F[ValidateSecurityProfileBehaviorsResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptCertificateTransferOp(
      request: AcceptCertificateTransferRequest
    ) extends IotOp[AcceptCertificateTransferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptCertificateTransferResponse] =
        visitor.acceptCertificateTransfer(request)
    }

    final case class AddThingToBillingGroupOp(
      request: AddThingToBillingGroupRequest
    ) extends IotOp[AddThingToBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddThingToBillingGroupResponse] =
        visitor.addThingToBillingGroup(request)
    }

    final case class AddThingToThingGroupOp(
      request: AddThingToThingGroupRequest
    ) extends IotOp[AddThingToThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddThingToThingGroupResponse] =
        visitor.addThingToThingGroup(request)
    }

    final case class AssociateTargetsWithJobOp(
      request: AssociateTargetsWithJobRequest
    ) extends IotOp[AssociateTargetsWithJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTargetsWithJobResponse] =
        visitor.associateTargetsWithJob(request)
    }

    final case class AttachPolicyOp(
      request: AttachPolicyRequest
    ) extends IotOp[AttachPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachPolicyResponse] =
        visitor.attachPolicy(request)
    }

    final case class AttachSecurityProfileOp(
      request: AttachSecurityProfileRequest
    ) extends IotOp[AttachSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachSecurityProfileResponse] =
        visitor.attachSecurityProfile(request)
    }

    final case class AttachThingPrincipalOp(
      request: AttachThingPrincipalRequest
    ) extends IotOp[AttachThingPrincipalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachThingPrincipalResponse] =
        visitor.attachThingPrincipal(request)
    }

    final case class CancelAuditMitigationActionsTaskOp(
      request: CancelAuditMitigationActionsTaskRequest
    ) extends IotOp[CancelAuditMitigationActionsTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelAuditMitigationActionsTaskResponse] =
        visitor.cancelAuditMitigationActionsTask(request)
    }

    final case class CancelAuditTaskOp(
      request: CancelAuditTaskRequest
    ) extends IotOp[CancelAuditTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelAuditTaskResponse] =
        visitor.cancelAuditTask(request)
    }

    final case class CancelCertificateTransferOp(
      request: CancelCertificateTransferRequest
    ) extends IotOp[CancelCertificateTransferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelCertificateTransferResponse] =
        visitor.cancelCertificateTransfer(request)
    }

    final case class CancelDetectMitigationActionsTaskOp(
      request: CancelDetectMitigationActionsTaskRequest
    ) extends IotOp[CancelDetectMitigationActionsTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelDetectMitigationActionsTaskResponse] =
        visitor.cancelDetectMitigationActionsTask(request)
    }

    final case class CancelJobOp(
      request: CancelJobRequest
    ) extends IotOp[CancelJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobResponse] =
        visitor.cancelJob(request)
    }

    final case class CancelJobExecutionOp(
      request: CancelJobExecutionRequest
    ) extends IotOp[CancelJobExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobExecutionResponse] =
        visitor.cancelJobExecution(request)
    }

    final case class ClearDefaultAuthorizerOp(
      request: ClearDefaultAuthorizerRequest
    ) extends IotOp[ClearDefaultAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ClearDefaultAuthorizerResponse] =
        visitor.clearDefaultAuthorizer(request)
    }

    final case class ConfirmTopicRuleDestinationOp(
      request: ConfirmTopicRuleDestinationRequest
    ) extends IotOp[ConfirmTopicRuleDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmTopicRuleDestinationResponse] =
        visitor.confirmTopicRuleDestination(request)
    }

    final case class CreateAuditSuppressionOp(
      request: CreateAuditSuppressionRequest
    ) extends IotOp[CreateAuditSuppressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAuditSuppressionResponse] =
        visitor.createAuditSuppression(request)
    }

    final case class CreateAuthorizerOp(
      request: CreateAuthorizerRequest
    ) extends IotOp[CreateAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAuthorizerResponse] =
        visitor.createAuthorizer(request)
    }

    final case class CreateBillingGroupOp(
      request: CreateBillingGroupRequest
    ) extends IotOp[CreateBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBillingGroupResponse] =
        visitor.createBillingGroup(request)
    }

    final case class CreateCertificateFromCsrOp(
      request: CreateCertificateFromCsrRequest
    ) extends IotOp[CreateCertificateFromCsrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCertificateFromCsrResponse] =
        visitor.createCertificateFromCsr(request)
    }

    final case class CreateCustomMetricOp(
      request: CreateCustomMetricRequest
    ) extends IotOp[CreateCustomMetricResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomMetricResponse] =
        visitor.createCustomMetric(request)
    }

    final case class CreateDimensionOp(
      request: CreateDimensionRequest
    ) extends IotOp[CreateDimensionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDimensionResponse] =
        visitor.createDimension(request)
    }

    final case class CreateDomainConfigurationOp(
      request: CreateDomainConfigurationRequest
    ) extends IotOp[CreateDomainConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainConfigurationResponse] =
        visitor.createDomainConfiguration(request)
    }

    final case class CreateDynamicThingGroupOp(
      request: CreateDynamicThingGroupRequest
    ) extends IotOp[CreateDynamicThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDynamicThingGroupResponse] =
        visitor.createDynamicThingGroup(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends IotOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class CreateJobTemplateOp(
      request: CreateJobTemplateRequest
    ) extends IotOp[CreateJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobTemplateResponse] =
        visitor.createJobTemplate(request)
    }

    final case class CreateKeysAndCertificateOp(
      request: CreateKeysAndCertificateRequest
    ) extends IotOp[CreateKeysAndCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateKeysAndCertificateResponse] =
        visitor.createKeysAndCertificate(request)
    }

    final case class CreateMitigationActionOp(
      request: CreateMitigationActionRequest
    ) extends IotOp[CreateMitigationActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMitigationActionResponse] =
        visitor.createMitigationAction(request)
    }

    final case class CreateOTAUpdateOp(
      request: CreateOtaUpdateRequest
    ) extends IotOp[CreateOtaUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOtaUpdateResponse] =
        visitor.createOTAUpdate(request)
    }

    final case class CreatePolicyOp(
      request: CreatePolicyRequest
    ) extends IotOp[CreatePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePolicyResponse] =
        visitor.createPolicy(request)
    }

    final case class CreatePolicyVersionOp(
      request: CreatePolicyVersionRequest
    ) extends IotOp[CreatePolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePolicyVersionResponse] =
        visitor.createPolicyVersion(request)
    }

    final case class CreateProvisioningClaimOp(
      request: CreateProvisioningClaimRequest
    ) extends IotOp[CreateProvisioningClaimResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProvisioningClaimResponse] =
        visitor.createProvisioningClaim(request)
    }

    final case class CreateProvisioningTemplateOp(
      request: CreateProvisioningTemplateRequest
    ) extends IotOp[CreateProvisioningTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProvisioningTemplateResponse] =
        visitor.createProvisioningTemplate(request)
    }

    final case class CreateProvisioningTemplateVersionOp(
      request: CreateProvisioningTemplateVersionRequest
    ) extends IotOp[CreateProvisioningTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProvisioningTemplateVersionResponse] =
        visitor.createProvisioningTemplateVersion(request)
    }

    final case class CreateRoleAliasOp(
      request: CreateRoleAliasRequest
    ) extends IotOp[CreateRoleAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRoleAliasResponse] =
        visitor.createRoleAlias(request)
    }

    final case class CreateScheduledAuditOp(
      request: CreateScheduledAuditRequest
    ) extends IotOp[CreateScheduledAuditResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateScheduledAuditResponse] =
        visitor.createScheduledAudit(request)
    }

    final case class CreateSecurityProfileOp(
      request: CreateSecurityProfileRequest
    ) extends IotOp[CreateSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSecurityProfileResponse] =
        visitor.createSecurityProfile(request)
    }

    final case class CreateStreamOp(
      request: CreateStreamRequest
    ) extends IotOp[CreateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamResponse] =
        visitor.createStream(request)
    }

    final case class CreateThingOp(
      request: CreateThingRequest
    ) extends IotOp[CreateThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThingResponse] =
        visitor.createThing(request)
    }

    final case class CreateThingGroupOp(
      request: CreateThingGroupRequest
    ) extends IotOp[CreateThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThingGroupResponse] =
        visitor.createThingGroup(request)
    }

    final case class CreateThingTypeOp(
      request: CreateThingTypeRequest
    ) extends IotOp[CreateThingTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThingTypeResponse] =
        visitor.createThingType(request)
    }

    final case class CreateTopicRuleOp(
      request: CreateTopicRuleRequest
    ) extends IotOp[CreateTopicRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTopicRuleResponse] =
        visitor.createTopicRule(request)
    }

    final case class CreateTopicRuleDestinationOp(
      request: CreateTopicRuleDestinationRequest
    ) extends IotOp[CreateTopicRuleDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTopicRuleDestinationResponse] =
        visitor.createTopicRuleDestination(request)
    }

    final case class DeleteAccountAuditConfigurationOp(
      request: DeleteAccountAuditConfigurationRequest
    ) extends IotOp[DeleteAccountAuditConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountAuditConfigurationResponse] =
        visitor.deleteAccountAuditConfiguration(request)
    }

    final case class DeleteAuditSuppressionOp(
      request: DeleteAuditSuppressionRequest
    ) extends IotOp[DeleteAuditSuppressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAuditSuppressionResponse] =
        visitor.deleteAuditSuppression(request)
    }

    final case class DeleteAuthorizerOp(
      request: DeleteAuthorizerRequest
    ) extends IotOp[DeleteAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAuthorizerResponse] =
        visitor.deleteAuthorizer(request)
    }

    final case class DeleteBillingGroupOp(
      request: DeleteBillingGroupRequest
    ) extends IotOp[DeleteBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBillingGroupResponse] =
        visitor.deleteBillingGroup(request)
    }

    final case class DeleteCACertificateOp(
      request: DeleteCaCertificateRequest
    ) extends IotOp[DeleteCaCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCaCertificateResponse] =
        visitor.deleteCACertificate(request)
    }

    final case class DeleteCertificateOp(
      request: DeleteCertificateRequest
    ) extends IotOp[DeleteCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCertificateResponse] =
        visitor.deleteCertificate(request)
    }

    final case class DeleteCustomMetricOp(
      request: DeleteCustomMetricRequest
    ) extends IotOp[DeleteCustomMetricResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomMetricResponse] =
        visitor.deleteCustomMetric(request)
    }

    final case class DeleteDimensionOp(
      request: DeleteDimensionRequest
    ) extends IotOp[DeleteDimensionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDimensionResponse] =
        visitor.deleteDimension(request)
    }

    final case class DeleteDomainConfigurationOp(
      request: DeleteDomainConfigurationRequest
    ) extends IotOp[DeleteDomainConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainConfigurationResponse] =
        visitor.deleteDomainConfiguration(request)
    }

    final case class DeleteDynamicThingGroupOp(
      request: DeleteDynamicThingGroupRequest
    ) extends IotOp[DeleteDynamicThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDynamicThingGroupResponse] =
        visitor.deleteDynamicThingGroup(request)
    }

    final case class DeleteJobOp(
      request: DeleteJobRequest
    ) extends IotOp[DeleteJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobResponse] =
        visitor.deleteJob(request)
    }

    final case class DeleteJobExecutionOp(
      request: DeleteJobExecutionRequest
    ) extends IotOp[DeleteJobExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobExecutionResponse] =
        visitor.deleteJobExecution(request)
    }

    final case class DeleteJobTemplateOp(
      request: DeleteJobTemplateRequest
    ) extends IotOp[DeleteJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobTemplateResponse] =
        visitor.deleteJobTemplate(request)
    }

    final case class DeleteMitigationActionOp(
      request: DeleteMitigationActionRequest
    ) extends IotOp[DeleteMitigationActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMitigationActionResponse] =
        visitor.deleteMitigationAction(request)
    }

    final case class DeleteOTAUpdateOp(
      request: DeleteOtaUpdateRequest
    ) extends IotOp[DeleteOtaUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOtaUpdateResponse] =
        visitor.deleteOTAUpdate(request)
    }

    final case class DeletePolicyOp(
      request: DeletePolicyRequest
    ) extends IotOp[DeletePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyResponse] =
        visitor.deletePolicy(request)
    }

    final case class DeletePolicyVersionOp(
      request: DeletePolicyVersionRequest
    ) extends IotOp[DeletePolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyVersionResponse] =
        visitor.deletePolicyVersion(request)
    }

    final case class DeleteProvisioningTemplateOp(
      request: DeleteProvisioningTemplateRequest
    ) extends IotOp[DeleteProvisioningTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProvisioningTemplateResponse] =
        visitor.deleteProvisioningTemplate(request)
    }

    final case class DeleteProvisioningTemplateVersionOp(
      request: DeleteProvisioningTemplateVersionRequest
    ) extends IotOp[DeleteProvisioningTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProvisioningTemplateVersionResponse] =
        visitor.deleteProvisioningTemplateVersion(request)
    }

    final case class DeleteRegistrationCodeOp(
      request: DeleteRegistrationCodeRequest
    ) extends IotOp[DeleteRegistrationCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRegistrationCodeResponse] =
        visitor.deleteRegistrationCode(request)
    }

    final case class DeleteRoleAliasOp(
      request: DeleteRoleAliasRequest
    ) extends IotOp[DeleteRoleAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRoleAliasResponse] =
        visitor.deleteRoleAlias(request)
    }

    final case class DeleteScheduledAuditOp(
      request: DeleteScheduledAuditRequest
    ) extends IotOp[DeleteScheduledAuditResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScheduledAuditResponse] =
        visitor.deleteScheduledAudit(request)
    }

    final case class DeleteSecurityProfileOp(
      request: DeleteSecurityProfileRequest
    ) extends IotOp[DeleteSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSecurityProfileResponse] =
        visitor.deleteSecurityProfile(request)
    }

    final case class DeleteStreamOp(
      request: DeleteStreamRequest
    ) extends IotOp[DeleteStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamResponse] =
        visitor.deleteStream(request)
    }

    final case class DeleteThingOp(
      request: DeleteThingRequest
    ) extends IotOp[DeleteThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThingResponse] =
        visitor.deleteThing(request)
    }

    final case class DeleteThingGroupOp(
      request: DeleteThingGroupRequest
    ) extends IotOp[DeleteThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThingGroupResponse] =
        visitor.deleteThingGroup(request)
    }

    final case class DeleteThingTypeOp(
      request: DeleteThingTypeRequest
    ) extends IotOp[DeleteThingTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThingTypeResponse] =
        visitor.deleteThingType(request)
    }

    final case class DeleteTopicRuleOp(
      request: DeleteTopicRuleRequest
    ) extends IotOp[DeleteTopicRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTopicRuleResponse] =
        visitor.deleteTopicRule(request)
    }

    final case class DeleteTopicRuleDestinationOp(
      request: DeleteTopicRuleDestinationRequest
    ) extends IotOp[DeleteTopicRuleDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTopicRuleDestinationResponse] =
        visitor.deleteTopicRuleDestination(request)
    }

    final case class DeleteV2LoggingLevelOp(
      request: DeleteV2LoggingLevelRequest
    ) extends IotOp[DeleteV2LoggingLevelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteV2LoggingLevelResponse] =
        visitor.deleteV2LoggingLevel(request)
    }

    final case class DeprecateThingTypeOp(
      request: DeprecateThingTypeRequest
    ) extends IotOp[DeprecateThingTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprecateThingTypeResponse] =
        visitor.deprecateThingType(request)
    }

    final case class DescribeAccountAuditConfigurationOp(
      request: DescribeAccountAuditConfigurationRequest
    ) extends IotOp[DescribeAccountAuditConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAuditConfigurationResponse] =
        visitor.describeAccountAuditConfiguration(request)
    }

    final case class DescribeAuditFindingOp(
      request: DescribeAuditFindingRequest
    ) extends IotOp[DescribeAuditFindingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAuditFindingResponse] =
        visitor.describeAuditFinding(request)
    }

    final case class DescribeAuditMitigationActionsTaskOp(
      request: DescribeAuditMitigationActionsTaskRequest
    ) extends IotOp[DescribeAuditMitigationActionsTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAuditMitigationActionsTaskResponse] =
        visitor.describeAuditMitigationActionsTask(request)
    }

    final case class DescribeAuditSuppressionOp(
      request: DescribeAuditSuppressionRequest
    ) extends IotOp[DescribeAuditSuppressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAuditSuppressionResponse] =
        visitor.describeAuditSuppression(request)
    }

    final case class DescribeAuditTaskOp(
      request: DescribeAuditTaskRequest
    ) extends IotOp[DescribeAuditTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAuditTaskResponse] =
        visitor.describeAuditTask(request)
    }

    final case class DescribeAuthorizerOp(
      request: DescribeAuthorizerRequest
    ) extends IotOp[DescribeAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAuthorizerResponse] =
        visitor.describeAuthorizer(request)
    }

    final case class DescribeBillingGroupOp(
      request: DescribeBillingGroupRequest
    ) extends IotOp[DescribeBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBillingGroupResponse] =
        visitor.describeBillingGroup(request)
    }

    final case class DescribeCACertificateOp(
      request: DescribeCaCertificateRequest
    ) extends IotOp[DescribeCaCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCaCertificateResponse] =
        visitor.describeCACertificate(request)
    }

    final case class DescribeCertificateOp(
      request: DescribeCertificateRequest
    ) extends IotOp[DescribeCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCertificateResponse] =
        visitor.describeCertificate(request)
    }

    final case class DescribeCustomMetricOp(
      request: DescribeCustomMetricRequest
    ) extends IotOp[DescribeCustomMetricResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomMetricResponse] =
        visitor.describeCustomMetric(request)
    }

    final case class DescribeDefaultAuthorizerOp(
      request: DescribeDefaultAuthorizerRequest
    ) extends IotOp[DescribeDefaultAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDefaultAuthorizerResponse] =
        visitor.describeDefaultAuthorizer(request)
    }

    final case class DescribeDetectMitigationActionsTaskOp(
      request: DescribeDetectMitigationActionsTaskRequest
    ) extends IotOp[DescribeDetectMitigationActionsTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDetectMitigationActionsTaskResponse] =
        visitor.describeDetectMitigationActionsTask(request)
    }

    final case class DescribeDimensionOp(
      request: DescribeDimensionRequest
    ) extends IotOp[DescribeDimensionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDimensionResponse] =
        visitor.describeDimension(request)
    }

    final case class DescribeDomainConfigurationOp(
      request: DescribeDomainConfigurationRequest
    ) extends IotOp[DescribeDomainConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDomainConfigurationResponse] =
        visitor.describeDomainConfiguration(request)
    }

    final case class DescribeEndpointOp(
      request: DescribeEndpointRequest
    ) extends IotOp[DescribeEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointResponse] =
        visitor.describeEndpoint(request)
    }

    final case class DescribeEventConfigurationsOp(
      request: DescribeEventConfigurationsRequest
    ) extends IotOp[DescribeEventConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventConfigurationsResponse] =
        visitor.describeEventConfigurations(request)
    }

    final case class DescribeIndexOp(
      request: DescribeIndexRequest
    ) extends IotOp[DescribeIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIndexResponse] =
        visitor.describeIndex(request)
    }

    final case class DescribeJobOp(
      request: DescribeJobRequest
    ) extends IotOp[DescribeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobResponse] =
        visitor.describeJob(request)
    }

    final case class DescribeJobExecutionOp(
      request: DescribeJobExecutionRequest
    ) extends IotOp[DescribeJobExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobExecutionResponse] =
        visitor.describeJobExecution(request)
    }

    final case class DescribeJobTemplateOp(
      request: DescribeJobTemplateRequest
    ) extends IotOp[DescribeJobTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobTemplateResponse] =
        visitor.describeJobTemplate(request)
    }

    final case class DescribeMitigationActionOp(
      request: DescribeMitigationActionRequest
    ) extends IotOp[DescribeMitigationActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMitigationActionResponse] =
        visitor.describeMitigationAction(request)
    }

    final case class DescribeProvisioningTemplateOp(
      request: DescribeProvisioningTemplateRequest
    ) extends IotOp[DescribeProvisioningTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProvisioningTemplateResponse] =
        visitor.describeProvisioningTemplate(request)
    }

    final case class DescribeProvisioningTemplateVersionOp(
      request: DescribeProvisioningTemplateVersionRequest
    ) extends IotOp[DescribeProvisioningTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProvisioningTemplateVersionResponse] =
        visitor.describeProvisioningTemplateVersion(request)
    }

    final case class DescribeRoleAliasOp(
      request: DescribeRoleAliasRequest
    ) extends IotOp[DescribeRoleAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRoleAliasResponse] =
        visitor.describeRoleAlias(request)
    }

    final case class DescribeScheduledAuditOp(
      request: DescribeScheduledAuditRequest
    ) extends IotOp[DescribeScheduledAuditResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduledAuditResponse] =
        visitor.describeScheduledAudit(request)
    }

    final case class DescribeSecurityProfileOp(
      request: DescribeSecurityProfileRequest
    ) extends IotOp[DescribeSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSecurityProfileResponse] =
        visitor.describeSecurityProfile(request)
    }

    final case class DescribeStreamOp(
      request: DescribeStreamRequest
    ) extends IotOp[DescribeStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamResponse] =
        visitor.describeStream(request)
    }

    final case class DescribeThingOp(
      request: DescribeThingRequest
    ) extends IotOp[DescribeThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThingResponse] =
        visitor.describeThing(request)
    }

    final case class DescribeThingGroupOp(
      request: DescribeThingGroupRequest
    ) extends IotOp[DescribeThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThingGroupResponse] =
        visitor.describeThingGroup(request)
    }

    final case class DescribeThingRegistrationTaskOp(
      request: DescribeThingRegistrationTaskRequest
    ) extends IotOp[DescribeThingRegistrationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThingRegistrationTaskResponse] =
        visitor.describeThingRegistrationTask(request)
    }

    final case class DescribeThingTypeOp(
      request: DescribeThingTypeRequest
    ) extends IotOp[DescribeThingTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThingTypeResponse] =
        visitor.describeThingType(request)
    }

    final case class DetachPolicyOp(
      request: DetachPolicyRequest
    ) extends IotOp[DetachPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachPolicyResponse] =
        visitor.detachPolicy(request)
    }

    final case class DetachSecurityProfileOp(
      request: DetachSecurityProfileRequest
    ) extends IotOp[DetachSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachSecurityProfileResponse] =
        visitor.detachSecurityProfile(request)
    }

    final case class DetachThingPrincipalOp(
      request: DetachThingPrincipalRequest
    ) extends IotOp[DetachThingPrincipalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachThingPrincipalResponse] =
        visitor.detachThingPrincipal(request)
    }

    final case class DisableTopicRuleOp(
      request: DisableTopicRuleRequest
    ) extends IotOp[DisableTopicRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableTopicRuleResponse] =
        visitor.disableTopicRule(request)
    }

    final case class EnableTopicRuleOp(
      request: EnableTopicRuleRequest
    ) extends IotOp[EnableTopicRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableTopicRuleResponse] =
        visitor.enableTopicRule(request)
    }

    final case class GetBehaviorModelTrainingSummariesOp(
      request: GetBehaviorModelTrainingSummariesRequest
    ) extends IotOp[GetBehaviorModelTrainingSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBehaviorModelTrainingSummariesResponse] =
        visitor.getBehaviorModelTrainingSummaries(request)
    }

    final case class GetCardinalityOp(
      request: GetCardinalityRequest
    ) extends IotOp[GetCardinalityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCardinalityResponse] =
        visitor.getCardinality(request)
    }

    final case class GetEffectivePoliciesOp(
      request: GetEffectivePoliciesRequest
    ) extends IotOp[GetEffectivePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEffectivePoliciesResponse] =
        visitor.getEffectivePolicies(request)
    }

    final case class GetIndexingConfigurationOp(
      request: GetIndexingConfigurationRequest
    ) extends IotOp[GetIndexingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIndexingConfigurationResponse] =
        visitor.getIndexingConfiguration(request)
    }

    final case class GetJobDocumentOp(
      request: GetJobDocumentRequest
    ) extends IotOp[GetJobDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobDocumentResponse] =
        visitor.getJobDocument(request)
    }

    final case class GetLoggingOptionsOp(
      request: GetLoggingOptionsRequest
    ) extends IotOp[GetLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoggingOptionsResponse] =
        visitor.getLoggingOptions(request)
    }

    final case class GetOTAUpdateOp(
      request: GetOtaUpdateRequest
    ) extends IotOp[GetOtaUpdateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOtaUpdateResponse] =
        visitor.getOTAUpdate(request)
    }

    final case class GetPercentilesOp(
      request: GetPercentilesRequest
    ) extends IotOp[GetPercentilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPercentilesResponse] =
        visitor.getPercentiles(request)
    }

    final case class GetPolicyOp(
      request: GetPolicyRequest
    ) extends IotOp[GetPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyResponse] =
        visitor.getPolicy(request)
    }

    final case class GetPolicyVersionOp(
      request: GetPolicyVersionRequest
    ) extends IotOp[GetPolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyVersionResponse] =
        visitor.getPolicyVersion(request)
    }

    final case class GetRegistrationCodeOp(
      request: GetRegistrationCodeRequest
    ) extends IotOp[GetRegistrationCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRegistrationCodeResponse] =
        visitor.getRegistrationCode(request)
    }

    final case class GetStatisticsOp(
      request: GetStatisticsRequest
    ) extends IotOp[GetStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStatisticsResponse] =
        visitor.getStatistics(request)
    }

    final case class GetTopicRuleOp(
      request: GetTopicRuleRequest
    ) extends IotOp[GetTopicRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTopicRuleResponse] =
        visitor.getTopicRule(request)
    }

    final case class GetTopicRuleDestinationOp(
      request: GetTopicRuleDestinationRequest
    ) extends IotOp[GetTopicRuleDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTopicRuleDestinationResponse] =
        visitor.getTopicRuleDestination(request)
    }

    final case class GetV2LoggingOptionsOp(
      request: GetV2LoggingOptionsRequest
    ) extends IotOp[GetV2LoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetV2LoggingOptionsResponse] =
        visitor.getV2LoggingOptions(request)
    }

    final case class ListActiveViolationsOp(
      request: ListActiveViolationsRequest
    ) extends IotOp[ListActiveViolationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActiveViolationsResponse] =
        visitor.listActiveViolations(request)
    }

    final case class ListAttachedPoliciesOp(
      request: ListAttachedPoliciesRequest
    ) extends IotOp[ListAttachedPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttachedPoliciesResponse] =
        visitor.listAttachedPolicies(request)
    }

    final case class ListAuditFindingsOp(
      request: ListAuditFindingsRequest
    ) extends IotOp[ListAuditFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAuditFindingsResponse] =
        visitor.listAuditFindings(request)
    }

    final case class ListAuditMitigationActionsExecutionsOp(
      request: ListAuditMitigationActionsExecutionsRequest
    ) extends IotOp[ListAuditMitigationActionsExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAuditMitigationActionsExecutionsResponse] =
        visitor.listAuditMitigationActionsExecutions(request)
    }

    final case class ListAuditMitigationActionsTasksOp(
      request: ListAuditMitigationActionsTasksRequest
    ) extends IotOp[ListAuditMitigationActionsTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAuditMitigationActionsTasksResponse] =
        visitor.listAuditMitigationActionsTasks(request)
    }

    final case class ListAuditSuppressionsOp(
      request: ListAuditSuppressionsRequest
    ) extends IotOp[ListAuditSuppressionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAuditSuppressionsResponse] =
        visitor.listAuditSuppressions(request)
    }

    final case class ListAuditTasksOp(
      request: ListAuditTasksRequest
    ) extends IotOp[ListAuditTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAuditTasksResponse] =
        visitor.listAuditTasks(request)
    }

    final case class ListAuthorizersOp(
      request: ListAuthorizersRequest
    ) extends IotOp[ListAuthorizersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAuthorizersResponse] =
        visitor.listAuthorizers(request)
    }

    final case class ListBillingGroupsOp(
      request: ListBillingGroupsRequest
    ) extends IotOp[ListBillingGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBillingGroupsResponse] =
        visitor.listBillingGroups(request)
    }

    final case class ListCACertificatesOp(
      request: ListCaCertificatesRequest
    ) extends IotOp[ListCaCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCaCertificatesResponse] =
        visitor.listCACertificates(request)
    }

    final case class ListCertificatesOp(
      request: ListCertificatesRequest
    ) extends IotOp[ListCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCertificatesResponse] =
        visitor.listCertificates(request)
    }

    final case class ListCertificatesByCAOp(
      request: ListCertificatesByCaRequest
    ) extends IotOp[ListCertificatesByCaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCertificatesByCaResponse] =
        visitor.listCertificatesByCA(request)
    }

    final case class ListCustomMetricsOp(
      request: ListCustomMetricsRequest
    ) extends IotOp[ListCustomMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomMetricsResponse] =
        visitor.listCustomMetrics(request)
    }

    final case class ListDetectMitigationActionsExecutionsOp(
      request: ListDetectMitigationActionsExecutionsRequest
    ) extends IotOp[ListDetectMitigationActionsExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDetectMitigationActionsExecutionsResponse] =
        visitor.listDetectMitigationActionsExecutions(request)
    }

    final case class ListDetectMitigationActionsTasksOp(
      request: ListDetectMitigationActionsTasksRequest
    ) extends IotOp[ListDetectMitigationActionsTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDetectMitigationActionsTasksResponse] =
        visitor.listDetectMitigationActionsTasks(request)
    }

    final case class ListDimensionsOp(
      request: ListDimensionsRequest
    ) extends IotOp[ListDimensionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDimensionsResponse] =
        visitor.listDimensions(request)
    }

    final case class ListDomainConfigurationsOp(
      request: ListDomainConfigurationsRequest
    ) extends IotOp[ListDomainConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainConfigurationsResponse] =
        visitor.listDomainConfigurations(request)
    }

    final case class ListIndicesOp(
      request: ListIndicesRequest
    ) extends IotOp[ListIndicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIndicesResponse] =
        visitor.listIndices(request)
    }

    final case class ListJobExecutionsForJobOp(
      request: ListJobExecutionsForJobRequest
    ) extends IotOp[ListJobExecutionsForJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobExecutionsForJobResponse] =
        visitor.listJobExecutionsForJob(request)
    }

    final case class ListJobExecutionsForThingOp(
      request: ListJobExecutionsForThingRequest
    ) extends IotOp[ListJobExecutionsForThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobExecutionsForThingResponse] =
        visitor.listJobExecutionsForThing(request)
    }

    final case class ListJobTemplatesOp(
      request: ListJobTemplatesRequest
    ) extends IotOp[ListJobTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobTemplatesResponse] =
        visitor.listJobTemplates(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends IotOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListMitigationActionsOp(
      request: ListMitigationActionsRequest
    ) extends IotOp[ListMitigationActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMitigationActionsResponse] =
        visitor.listMitigationActions(request)
    }

    final case class ListOTAUpdatesOp(
      request: ListOtaUpdatesRequest
    ) extends IotOp[ListOtaUpdatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOtaUpdatesResponse] =
        visitor.listOTAUpdates(request)
    }

    final case class ListOutgoingCertificatesOp(
      request: ListOutgoingCertificatesRequest
    ) extends IotOp[ListOutgoingCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOutgoingCertificatesResponse] =
        visitor.listOutgoingCertificates(request)
    }

    final case class ListPoliciesOp(
      request: ListPoliciesRequest
    ) extends IotOp[ListPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPoliciesResponse] =
        visitor.listPolicies(request)
    }

    final case class ListPolicyVersionsOp(
      request: ListPolicyVersionsRequest
    ) extends IotOp[ListPolicyVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPolicyVersionsResponse] =
        visitor.listPolicyVersions(request)
    }

    final case class ListPrincipalThingsOp(
      request: ListPrincipalThingsRequest
    ) extends IotOp[ListPrincipalThingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPrincipalThingsResponse] =
        visitor.listPrincipalThings(request)
    }

    final case class ListProvisioningTemplateVersionsOp(
      request: ListProvisioningTemplateVersionsRequest
    ) extends IotOp[ListProvisioningTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisioningTemplateVersionsResponse] =
        visitor.listProvisioningTemplateVersions(request)
    }

    final case class ListProvisioningTemplatesOp(
      request: ListProvisioningTemplatesRequest
    ) extends IotOp[ListProvisioningTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisioningTemplatesResponse] =
        visitor.listProvisioningTemplates(request)
    }

    final case class ListRoleAliasesOp(
      request: ListRoleAliasesRequest
    ) extends IotOp[ListRoleAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoleAliasesResponse] =
        visitor.listRoleAliases(request)
    }

    final case class ListScheduledAuditsOp(
      request: ListScheduledAuditsRequest
    ) extends IotOp[ListScheduledAuditsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListScheduledAuditsResponse] =
        visitor.listScheduledAudits(request)
    }

    final case class ListSecurityProfilesOp(
      request: ListSecurityProfilesRequest
    ) extends IotOp[ListSecurityProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecurityProfilesResponse] =
        visitor.listSecurityProfiles(request)
    }

    final case class ListSecurityProfilesForTargetOp(
      request: ListSecurityProfilesForTargetRequest
    ) extends IotOp[ListSecurityProfilesForTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecurityProfilesForTargetResponse] =
        visitor.listSecurityProfilesForTarget(request)
    }

    final case class ListStreamsOp(
      request: ListStreamsRequest
    ) extends IotOp[ListStreamsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamsResponse] =
        visitor.listStreams(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IotOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTargetsForPolicyOp(
      request: ListTargetsForPolicyRequest
    ) extends IotOp[ListTargetsForPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTargetsForPolicyResponse] =
        visitor.listTargetsForPolicy(request)
    }

    final case class ListTargetsForSecurityProfileOp(
      request: ListTargetsForSecurityProfileRequest
    ) extends IotOp[ListTargetsForSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTargetsForSecurityProfileResponse] =
        visitor.listTargetsForSecurityProfile(request)
    }

    final case class ListThingGroupsOp(
      request: ListThingGroupsRequest
    ) extends IotOp[ListThingGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingGroupsResponse] =
        visitor.listThingGroups(request)
    }

    final case class ListThingGroupsForThingOp(
      request: ListThingGroupsForThingRequest
    ) extends IotOp[ListThingGroupsForThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingGroupsForThingResponse] =
        visitor.listThingGroupsForThing(request)
    }

    final case class ListThingPrincipalsOp(
      request: ListThingPrincipalsRequest
    ) extends IotOp[ListThingPrincipalsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingPrincipalsResponse] =
        visitor.listThingPrincipals(request)
    }

    final case class ListThingRegistrationTaskReportsOp(
      request: ListThingRegistrationTaskReportsRequest
    ) extends IotOp[ListThingRegistrationTaskReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingRegistrationTaskReportsResponse] =
        visitor.listThingRegistrationTaskReports(request)
    }

    final case class ListThingRegistrationTasksOp(
      request: ListThingRegistrationTasksRequest
    ) extends IotOp[ListThingRegistrationTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingRegistrationTasksResponse] =
        visitor.listThingRegistrationTasks(request)
    }

    final case class ListThingTypesOp(
      request: ListThingTypesRequest
    ) extends IotOp[ListThingTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingTypesResponse] =
        visitor.listThingTypes(request)
    }

    final case class ListThingsOp(
      request: ListThingsRequest
    ) extends IotOp[ListThingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingsResponse] =
        visitor.listThings(request)
    }

    final case class ListThingsInBillingGroupOp(
      request: ListThingsInBillingGroupRequest
    ) extends IotOp[ListThingsInBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingsInBillingGroupResponse] =
        visitor.listThingsInBillingGroup(request)
    }

    final case class ListThingsInThingGroupOp(
      request: ListThingsInThingGroupRequest
    ) extends IotOp[ListThingsInThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThingsInThingGroupResponse] =
        visitor.listThingsInThingGroup(request)
    }

    final case class ListTopicRuleDestinationsOp(
      request: ListTopicRuleDestinationsRequest
    ) extends IotOp[ListTopicRuleDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTopicRuleDestinationsResponse] =
        visitor.listTopicRuleDestinations(request)
    }

    final case class ListTopicRulesOp(
      request: ListTopicRulesRequest
    ) extends IotOp[ListTopicRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTopicRulesResponse] =
        visitor.listTopicRules(request)
    }

    final case class ListV2LoggingLevelsOp(
      request: ListV2LoggingLevelsRequest
    ) extends IotOp[ListV2LoggingLevelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListV2LoggingLevelsResponse] =
        visitor.listV2LoggingLevels(request)
    }

    final case class ListViolationEventsOp(
      request: ListViolationEventsRequest
    ) extends IotOp[ListViolationEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListViolationEventsResponse] =
        visitor.listViolationEvents(request)
    }

    final case class RegisterCACertificateOp(
      request: RegisterCaCertificateRequest
    ) extends IotOp[RegisterCaCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterCaCertificateResponse] =
        visitor.registerCACertificate(request)
    }

    final case class RegisterCertificateOp(
      request: RegisterCertificateRequest
    ) extends IotOp[RegisterCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterCertificateResponse] =
        visitor.registerCertificate(request)
    }

    final case class RegisterCertificateWithoutCAOp(
      request: RegisterCertificateWithoutCaRequest
    ) extends IotOp[RegisterCertificateWithoutCaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterCertificateWithoutCaResponse] =
        visitor.registerCertificateWithoutCA(request)
    }

    final case class RegisterThingOp(
      request: RegisterThingRequest
    ) extends IotOp[RegisterThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterThingResponse] =
        visitor.registerThing(request)
    }

    final case class RejectCertificateTransferOp(
      request: RejectCertificateTransferRequest
    ) extends IotOp[RejectCertificateTransferResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectCertificateTransferResponse] =
        visitor.rejectCertificateTransfer(request)
    }

    final case class RemoveThingFromBillingGroupOp(
      request: RemoveThingFromBillingGroupRequest
    ) extends IotOp[RemoveThingFromBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveThingFromBillingGroupResponse] =
        visitor.removeThingFromBillingGroup(request)
    }

    final case class RemoveThingFromThingGroupOp(
      request: RemoveThingFromThingGroupRequest
    ) extends IotOp[RemoveThingFromThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveThingFromThingGroupResponse] =
        visitor.removeThingFromThingGroup(request)
    }

    final case class ReplaceTopicRuleOp(
      request: ReplaceTopicRuleRequest
    ) extends IotOp[ReplaceTopicRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReplaceTopicRuleResponse] =
        visitor.replaceTopicRule(request)
    }

    final case class SearchIndexOp(
      request: SearchIndexRequest
    ) extends IotOp[SearchIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchIndexResponse] =
        visitor.searchIndex(request)
    }

    final case class SetDefaultAuthorizerOp(
      request: SetDefaultAuthorizerRequest
    ) extends IotOp[SetDefaultAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetDefaultAuthorizerResponse] =
        visitor.setDefaultAuthorizer(request)
    }

    final case class SetDefaultPolicyVersionOp(
      request: SetDefaultPolicyVersionRequest
    ) extends IotOp[SetDefaultPolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetDefaultPolicyVersionResponse] =
        visitor.setDefaultPolicyVersion(request)
    }

    final case class SetLoggingOptionsOp(
      request: SetLoggingOptionsRequest
    ) extends IotOp[SetLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetLoggingOptionsResponse] =
        visitor.setLoggingOptions(request)
    }

    final case class SetV2LoggingLevelOp(
      request: SetV2LoggingLevelRequest
    ) extends IotOp[SetV2LoggingLevelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetV2LoggingLevelResponse] =
        visitor.setV2LoggingLevel(request)
    }

    final case class SetV2LoggingOptionsOp(
      request: SetV2LoggingOptionsRequest
    ) extends IotOp[SetV2LoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetV2LoggingOptionsResponse] =
        visitor.setV2LoggingOptions(request)
    }

    final case class StartAuditMitigationActionsTaskOp(
      request: StartAuditMitigationActionsTaskRequest
    ) extends IotOp[StartAuditMitigationActionsTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAuditMitigationActionsTaskResponse] =
        visitor.startAuditMitigationActionsTask(request)
    }

    final case class StartDetectMitigationActionsTaskOp(
      request: StartDetectMitigationActionsTaskRequest
    ) extends IotOp[StartDetectMitigationActionsTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDetectMitigationActionsTaskResponse] =
        visitor.startDetectMitigationActionsTask(request)
    }

    final case class StartOnDemandAuditTaskOp(
      request: StartOnDemandAuditTaskRequest
    ) extends IotOp[StartOnDemandAuditTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartOnDemandAuditTaskResponse] =
        visitor.startOnDemandAuditTask(request)
    }

    final case class StartThingRegistrationTaskOp(
      request: StartThingRegistrationTaskRequest
    ) extends IotOp[StartThingRegistrationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartThingRegistrationTaskResponse] =
        visitor.startThingRegistrationTask(request)
    }

    final case class StopThingRegistrationTaskOp(
      request: StopThingRegistrationTaskRequest
    ) extends IotOp[StopThingRegistrationTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopThingRegistrationTaskResponse] =
        visitor.stopThingRegistrationTask(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IotOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestAuthorizationOp(
      request: TestAuthorizationRequest
    ) extends IotOp[TestAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestAuthorizationResponse] =
        visitor.testAuthorization(request)
    }

    final case class TestInvokeAuthorizerOp(
      request: TestInvokeAuthorizerRequest
    ) extends IotOp[TestInvokeAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestInvokeAuthorizerResponse] =
        visitor.testInvokeAuthorizer(request)
    }

    final case class TransferCertificateOp(
      request: TransferCertificateRequest
    ) extends IotOp[TransferCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TransferCertificateResponse] =
        visitor.transferCertificate(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IotOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccountAuditConfigurationOp(
      request: UpdateAccountAuditConfigurationRequest
    ) extends IotOp[UpdateAccountAuditConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountAuditConfigurationResponse] =
        visitor.updateAccountAuditConfiguration(request)
    }

    final case class UpdateAuditSuppressionOp(
      request: UpdateAuditSuppressionRequest
    ) extends IotOp[UpdateAuditSuppressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAuditSuppressionResponse] =
        visitor.updateAuditSuppression(request)
    }

    final case class UpdateAuthorizerOp(
      request: UpdateAuthorizerRequest
    ) extends IotOp[UpdateAuthorizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAuthorizerResponse] =
        visitor.updateAuthorizer(request)
    }

    final case class UpdateBillingGroupOp(
      request: UpdateBillingGroupRequest
    ) extends IotOp[UpdateBillingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBillingGroupResponse] =
        visitor.updateBillingGroup(request)
    }

    final case class UpdateCACertificateOp(
      request: UpdateCaCertificateRequest
    ) extends IotOp[UpdateCaCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCaCertificateResponse] =
        visitor.updateCACertificate(request)
    }

    final case class UpdateCertificateOp(
      request: UpdateCertificateRequest
    ) extends IotOp[UpdateCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCertificateResponse] =
        visitor.updateCertificate(request)
    }

    final case class UpdateCustomMetricOp(
      request: UpdateCustomMetricRequest
    ) extends IotOp[UpdateCustomMetricResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomMetricResponse] =
        visitor.updateCustomMetric(request)
    }

    final case class UpdateDimensionOp(
      request: UpdateDimensionRequest
    ) extends IotOp[UpdateDimensionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDimensionResponse] =
        visitor.updateDimension(request)
    }

    final case class UpdateDomainConfigurationOp(
      request: UpdateDomainConfigurationRequest
    ) extends IotOp[UpdateDomainConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainConfigurationResponse] =
        visitor.updateDomainConfiguration(request)
    }

    final case class UpdateDynamicThingGroupOp(
      request: UpdateDynamicThingGroupRequest
    ) extends IotOp[UpdateDynamicThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDynamicThingGroupResponse] =
        visitor.updateDynamicThingGroup(request)
    }

    final case class UpdateEventConfigurationsOp(
      request: UpdateEventConfigurationsRequest
    ) extends IotOp[UpdateEventConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEventConfigurationsResponse] =
        visitor.updateEventConfigurations(request)
    }

    final case class UpdateIndexingConfigurationOp(
      request: UpdateIndexingConfigurationRequest
    ) extends IotOp[UpdateIndexingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIndexingConfigurationResponse] =
        visitor.updateIndexingConfiguration(request)
    }

    final case class UpdateJobOp(
      request: UpdateJobRequest
    ) extends IotOp[UpdateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobResponse] =
        visitor.updateJob(request)
    }

    final case class UpdateMitigationActionOp(
      request: UpdateMitigationActionRequest
    ) extends IotOp[UpdateMitigationActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMitigationActionResponse] =
        visitor.updateMitigationAction(request)
    }

    final case class UpdateProvisioningTemplateOp(
      request: UpdateProvisioningTemplateRequest
    ) extends IotOp[UpdateProvisioningTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProvisioningTemplateResponse] =
        visitor.updateProvisioningTemplate(request)
    }

    final case class UpdateRoleAliasOp(
      request: UpdateRoleAliasRequest
    ) extends IotOp[UpdateRoleAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoleAliasResponse] =
        visitor.updateRoleAlias(request)
    }

    final case class UpdateScheduledAuditOp(
      request: UpdateScheduledAuditRequest
    ) extends IotOp[UpdateScheduledAuditResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateScheduledAuditResponse] =
        visitor.updateScheduledAudit(request)
    }

    final case class UpdateSecurityProfileOp(
      request: UpdateSecurityProfileRequest
    ) extends IotOp[UpdateSecurityProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSecurityProfileResponse] =
        visitor.updateSecurityProfile(request)
    }

    final case class UpdateStreamOp(
      request: UpdateStreamRequest
    ) extends IotOp[UpdateStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStreamResponse] =
        visitor.updateStream(request)
    }

    final case class UpdateThingOp(
      request: UpdateThingRequest
    ) extends IotOp[UpdateThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThingResponse] =
        visitor.updateThing(request)
    }

    final case class UpdateThingGroupOp(
      request: UpdateThingGroupRequest
    ) extends IotOp[UpdateThingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThingGroupResponse] =
        visitor.updateThingGroup(request)
    }

    final case class UpdateThingGroupsForThingOp(
      request: UpdateThingGroupsForThingRequest
    ) extends IotOp[UpdateThingGroupsForThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThingGroupsForThingResponse] =
        visitor.updateThingGroupsForThing(request)
    }

    final case class UpdateTopicRuleDestinationOp(
      request: UpdateTopicRuleDestinationRequest
    ) extends IotOp[UpdateTopicRuleDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTopicRuleDestinationResponse] =
        visitor.updateTopicRuleDestination(request)
    }

    final case class ValidateSecurityProfileBehaviorsOp(
      request: ValidateSecurityProfileBehaviorsRequest
    ) extends IotOp[ValidateSecurityProfileBehaviorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateSecurityProfileBehaviorsResponse] =
        visitor.validateSecurityProfileBehaviors(request)
    }
  }

  import IotOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptCertificateTransfer(
    request: AcceptCertificateTransferRequest
  ): IotIO[AcceptCertificateTransferResponse] =
    FF.liftF(AcceptCertificateTransferOp(request))

  def addThingToBillingGroup(
    request: AddThingToBillingGroupRequest
  ): IotIO[AddThingToBillingGroupResponse] =
    FF.liftF(AddThingToBillingGroupOp(request))

  def addThingToThingGroup(
    request: AddThingToThingGroupRequest
  ): IotIO[AddThingToThingGroupResponse] =
    FF.liftF(AddThingToThingGroupOp(request))

  def associateTargetsWithJob(
    request: AssociateTargetsWithJobRequest
  ): IotIO[AssociateTargetsWithJobResponse] =
    FF.liftF(AssociateTargetsWithJobOp(request))

  def attachPolicy(
    request: AttachPolicyRequest
  ): IotIO[AttachPolicyResponse] =
    FF.liftF(AttachPolicyOp(request))

  def attachSecurityProfile(
    request: AttachSecurityProfileRequest
  ): IotIO[AttachSecurityProfileResponse] =
    FF.liftF(AttachSecurityProfileOp(request))

  def attachThingPrincipal(
    request: AttachThingPrincipalRequest
  ): IotIO[AttachThingPrincipalResponse] =
    FF.liftF(AttachThingPrincipalOp(request))

  def cancelAuditMitigationActionsTask(
    request: CancelAuditMitigationActionsTaskRequest
  ): IotIO[CancelAuditMitigationActionsTaskResponse] =
    FF.liftF(CancelAuditMitigationActionsTaskOp(request))

  def cancelAuditTask(
    request: CancelAuditTaskRequest
  ): IotIO[CancelAuditTaskResponse] =
    FF.liftF(CancelAuditTaskOp(request))

  def cancelCertificateTransfer(
    request: CancelCertificateTransferRequest
  ): IotIO[CancelCertificateTransferResponse] =
    FF.liftF(CancelCertificateTransferOp(request))

  def cancelDetectMitigationActionsTask(
    request: CancelDetectMitigationActionsTaskRequest
  ): IotIO[CancelDetectMitigationActionsTaskResponse] =
    FF.liftF(CancelDetectMitigationActionsTaskOp(request))

  def cancelJob(
    request: CancelJobRequest
  ): IotIO[CancelJobResponse] =
    FF.liftF(CancelJobOp(request))

  def cancelJobExecution(
    request: CancelJobExecutionRequest
  ): IotIO[CancelJobExecutionResponse] =
    FF.liftF(CancelJobExecutionOp(request))

  def clearDefaultAuthorizer(
    request: ClearDefaultAuthorizerRequest
  ): IotIO[ClearDefaultAuthorizerResponse] =
    FF.liftF(ClearDefaultAuthorizerOp(request))

  def confirmTopicRuleDestination(
    request: ConfirmTopicRuleDestinationRequest
  ): IotIO[ConfirmTopicRuleDestinationResponse] =
    FF.liftF(ConfirmTopicRuleDestinationOp(request))

  def createAuditSuppression(
    request: CreateAuditSuppressionRequest
  ): IotIO[CreateAuditSuppressionResponse] =
    FF.liftF(CreateAuditSuppressionOp(request))

  def createAuthorizer(
    request: CreateAuthorizerRequest
  ): IotIO[CreateAuthorizerResponse] =
    FF.liftF(CreateAuthorizerOp(request))

  def createBillingGroup(
    request: CreateBillingGroupRequest
  ): IotIO[CreateBillingGroupResponse] =
    FF.liftF(CreateBillingGroupOp(request))

  def createCertificateFromCsr(
    request: CreateCertificateFromCsrRequest
  ): IotIO[CreateCertificateFromCsrResponse] =
    FF.liftF(CreateCertificateFromCsrOp(request))

  def createCustomMetric(
    request: CreateCustomMetricRequest
  ): IotIO[CreateCustomMetricResponse] =
    FF.liftF(CreateCustomMetricOp(request))

  def createDimension(
    request: CreateDimensionRequest
  ): IotIO[CreateDimensionResponse] =
    FF.liftF(CreateDimensionOp(request))

  def createDomainConfiguration(
    request: CreateDomainConfigurationRequest
  ): IotIO[CreateDomainConfigurationResponse] =
    FF.liftF(CreateDomainConfigurationOp(request))

  def createDynamicThingGroup(
    request: CreateDynamicThingGroupRequest
  ): IotIO[CreateDynamicThingGroupResponse] =
    FF.liftF(CreateDynamicThingGroupOp(request))

  def createJob(
    request: CreateJobRequest
  ): IotIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def createJobTemplate(
    request: CreateJobTemplateRequest
  ): IotIO[CreateJobTemplateResponse] =
    FF.liftF(CreateJobTemplateOp(request))

  def createKeysAndCertificate(
    request: CreateKeysAndCertificateRequest
  ): IotIO[CreateKeysAndCertificateResponse] =
    FF.liftF(CreateKeysAndCertificateOp(request))

  def createMitigationAction(
    request: CreateMitigationActionRequest
  ): IotIO[CreateMitigationActionResponse] =
    FF.liftF(CreateMitigationActionOp(request))

  def createOTAUpdate(
    request: CreateOtaUpdateRequest
  ): IotIO[CreateOtaUpdateResponse] =
    FF.liftF(CreateOTAUpdateOp(request))

  def createPolicy(
    request: CreatePolicyRequest
  ): IotIO[CreatePolicyResponse] =
    FF.liftF(CreatePolicyOp(request))

  def createPolicyVersion(
    request: CreatePolicyVersionRequest
  ): IotIO[CreatePolicyVersionResponse] =
    FF.liftF(CreatePolicyVersionOp(request))

  def createProvisioningClaim(
    request: CreateProvisioningClaimRequest
  ): IotIO[CreateProvisioningClaimResponse] =
    FF.liftF(CreateProvisioningClaimOp(request))

  def createProvisioningTemplate(
    request: CreateProvisioningTemplateRequest
  ): IotIO[CreateProvisioningTemplateResponse] =
    FF.liftF(CreateProvisioningTemplateOp(request))

  def createProvisioningTemplateVersion(
    request: CreateProvisioningTemplateVersionRequest
  ): IotIO[CreateProvisioningTemplateVersionResponse] =
    FF.liftF(CreateProvisioningTemplateVersionOp(request))

  def createRoleAlias(
    request: CreateRoleAliasRequest
  ): IotIO[CreateRoleAliasResponse] =
    FF.liftF(CreateRoleAliasOp(request))

  def createScheduledAudit(
    request: CreateScheduledAuditRequest
  ): IotIO[CreateScheduledAuditResponse] =
    FF.liftF(CreateScheduledAuditOp(request))

  def createSecurityProfile(
    request: CreateSecurityProfileRequest
  ): IotIO[CreateSecurityProfileResponse] =
    FF.liftF(CreateSecurityProfileOp(request))

  def createStream(
    request: CreateStreamRequest
  ): IotIO[CreateStreamResponse] =
    FF.liftF(CreateStreamOp(request))

  def createThing(
    request: CreateThingRequest
  ): IotIO[CreateThingResponse] =
    FF.liftF(CreateThingOp(request))

  def createThingGroup(
    request: CreateThingGroupRequest
  ): IotIO[CreateThingGroupResponse] =
    FF.liftF(CreateThingGroupOp(request))

  def createThingType(
    request: CreateThingTypeRequest
  ): IotIO[CreateThingTypeResponse] =
    FF.liftF(CreateThingTypeOp(request))

  def createTopicRule(
    request: CreateTopicRuleRequest
  ): IotIO[CreateTopicRuleResponse] =
    FF.liftF(CreateTopicRuleOp(request))

  def createTopicRuleDestination(
    request: CreateTopicRuleDestinationRequest
  ): IotIO[CreateTopicRuleDestinationResponse] =
    FF.liftF(CreateTopicRuleDestinationOp(request))

  def deleteAccountAuditConfiguration(
    request: DeleteAccountAuditConfigurationRequest
  ): IotIO[DeleteAccountAuditConfigurationResponse] =
    FF.liftF(DeleteAccountAuditConfigurationOp(request))

  def deleteAuditSuppression(
    request: DeleteAuditSuppressionRequest
  ): IotIO[DeleteAuditSuppressionResponse] =
    FF.liftF(DeleteAuditSuppressionOp(request))

  def deleteAuthorizer(
    request: DeleteAuthorizerRequest
  ): IotIO[DeleteAuthorizerResponse] =
    FF.liftF(DeleteAuthorizerOp(request))

  def deleteBillingGroup(
    request: DeleteBillingGroupRequest
  ): IotIO[DeleteBillingGroupResponse] =
    FF.liftF(DeleteBillingGroupOp(request))

  def deleteCACertificate(
    request: DeleteCaCertificateRequest
  ): IotIO[DeleteCaCertificateResponse] =
    FF.liftF(DeleteCACertificateOp(request))

  def deleteCertificate(
    request: DeleteCertificateRequest
  ): IotIO[DeleteCertificateResponse] =
    FF.liftF(DeleteCertificateOp(request))

  def deleteCustomMetric(
    request: DeleteCustomMetricRequest
  ): IotIO[DeleteCustomMetricResponse] =
    FF.liftF(DeleteCustomMetricOp(request))

  def deleteDimension(
    request: DeleteDimensionRequest
  ): IotIO[DeleteDimensionResponse] =
    FF.liftF(DeleteDimensionOp(request))

  def deleteDomainConfiguration(
    request: DeleteDomainConfigurationRequest
  ): IotIO[DeleteDomainConfigurationResponse] =
    FF.liftF(DeleteDomainConfigurationOp(request))

  def deleteDynamicThingGroup(
    request: DeleteDynamicThingGroupRequest
  ): IotIO[DeleteDynamicThingGroupResponse] =
    FF.liftF(DeleteDynamicThingGroupOp(request))

  def deleteJob(
    request: DeleteJobRequest
  ): IotIO[DeleteJobResponse] =
    FF.liftF(DeleteJobOp(request))

  def deleteJobExecution(
    request: DeleteJobExecutionRequest
  ): IotIO[DeleteJobExecutionResponse] =
    FF.liftF(DeleteJobExecutionOp(request))

  def deleteJobTemplate(
    request: DeleteJobTemplateRequest
  ): IotIO[DeleteJobTemplateResponse] =
    FF.liftF(DeleteJobTemplateOp(request))

  def deleteMitigationAction(
    request: DeleteMitigationActionRequest
  ): IotIO[DeleteMitigationActionResponse] =
    FF.liftF(DeleteMitigationActionOp(request))

  def deleteOTAUpdate(
    request: DeleteOtaUpdateRequest
  ): IotIO[DeleteOtaUpdateResponse] =
    FF.liftF(DeleteOTAUpdateOp(request))

  def deletePolicy(
    request: DeletePolicyRequest
  ): IotIO[DeletePolicyResponse] =
    FF.liftF(DeletePolicyOp(request))

  def deletePolicyVersion(
    request: DeletePolicyVersionRequest
  ): IotIO[DeletePolicyVersionResponse] =
    FF.liftF(DeletePolicyVersionOp(request))

  def deleteProvisioningTemplate(
    request: DeleteProvisioningTemplateRequest
  ): IotIO[DeleteProvisioningTemplateResponse] =
    FF.liftF(DeleteProvisioningTemplateOp(request))

  def deleteProvisioningTemplateVersion(
    request: DeleteProvisioningTemplateVersionRequest
  ): IotIO[DeleteProvisioningTemplateVersionResponse] =
    FF.liftF(DeleteProvisioningTemplateVersionOp(request))

  def deleteRegistrationCode(
    request: DeleteRegistrationCodeRequest
  ): IotIO[DeleteRegistrationCodeResponse] =
    FF.liftF(DeleteRegistrationCodeOp(request))

  def deleteRoleAlias(
    request: DeleteRoleAliasRequest
  ): IotIO[DeleteRoleAliasResponse] =
    FF.liftF(DeleteRoleAliasOp(request))

  def deleteScheduledAudit(
    request: DeleteScheduledAuditRequest
  ): IotIO[DeleteScheduledAuditResponse] =
    FF.liftF(DeleteScheduledAuditOp(request))

  def deleteSecurityProfile(
    request: DeleteSecurityProfileRequest
  ): IotIO[DeleteSecurityProfileResponse] =
    FF.liftF(DeleteSecurityProfileOp(request))

  def deleteStream(
    request: DeleteStreamRequest
  ): IotIO[DeleteStreamResponse] =
    FF.liftF(DeleteStreamOp(request))

  def deleteThing(
    request: DeleteThingRequest
  ): IotIO[DeleteThingResponse] =
    FF.liftF(DeleteThingOp(request))

  def deleteThingGroup(
    request: DeleteThingGroupRequest
  ): IotIO[DeleteThingGroupResponse] =
    FF.liftF(DeleteThingGroupOp(request))

  def deleteThingType(
    request: DeleteThingTypeRequest
  ): IotIO[DeleteThingTypeResponse] =
    FF.liftF(DeleteThingTypeOp(request))

  def deleteTopicRule(
    request: DeleteTopicRuleRequest
  ): IotIO[DeleteTopicRuleResponse] =
    FF.liftF(DeleteTopicRuleOp(request))

  def deleteTopicRuleDestination(
    request: DeleteTopicRuleDestinationRequest
  ): IotIO[DeleteTopicRuleDestinationResponse] =
    FF.liftF(DeleteTopicRuleDestinationOp(request))

  def deleteV2LoggingLevel(
    request: DeleteV2LoggingLevelRequest
  ): IotIO[DeleteV2LoggingLevelResponse] =
    FF.liftF(DeleteV2LoggingLevelOp(request))

  def deprecateThingType(
    request: DeprecateThingTypeRequest
  ): IotIO[DeprecateThingTypeResponse] =
    FF.liftF(DeprecateThingTypeOp(request))

  def describeAccountAuditConfiguration(
    request: DescribeAccountAuditConfigurationRequest
  ): IotIO[DescribeAccountAuditConfigurationResponse] =
    FF.liftF(DescribeAccountAuditConfigurationOp(request))

  def describeAuditFinding(
    request: DescribeAuditFindingRequest
  ): IotIO[DescribeAuditFindingResponse] =
    FF.liftF(DescribeAuditFindingOp(request))

  def describeAuditMitigationActionsTask(
    request: DescribeAuditMitigationActionsTaskRequest
  ): IotIO[DescribeAuditMitigationActionsTaskResponse] =
    FF.liftF(DescribeAuditMitigationActionsTaskOp(request))

  def describeAuditSuppression(
    request: DescribeAuditSuppressionRequest
  ): IotIO[DescribeAuditSuppressionResponse] =
    FF.liftF(DescribeAuditSuppressionOp(request))

  def describeAuditTask(
    request: DescribeAuditTaskRequest
  ): IotIO[DescribeAuditTaskResponse] =
    FF.liftF(DescribeAuditTaskOp(request))

  def describeAuthorizer(
    request: DescribeAuthorizerRequest
  ): IotIO[DescribeAuthorizerResponse] =
    FF.liftF(DescribeAuthorizerOp(request))

  def describeBillingGroup(
    request: DescribeBillingGroupRequest
  ): IotIO[DescribeBillingGroupResponse] =
    FF.liftF(DescribeBillingGroupOp(request))

  def describeCACertificate(
    request: DescribeCaCertificateRequest
  ): IotIO[DescribeCaCertificateResponse] =
    FF.liftF(DescribeCACertificateOp(request))

  def describeCertificate(
    request: DescribeCertificateRequest
  ): IotIO[DescribeCertificateResponse] =
    FF.liftF(DescribeCertificateOp(request))

  def describeCustomMetric(
    request: DescribeCustomMetricRequest
  ): IotIO[DescribeCustomMetricResponse] =
    FF.liftF(DescribeCustomMetricOp(request))

  def describeDefaultAuthorizer(
    request: DescribeDefaultAuthorizerRequest
  ): IotIO[DescribeDefaultAuthorizerResponse] =
    FF.liftF(DescribeDefaultAuthorizerOp(request))

  def describeDetectMitigationActionsTask(
    request: DescribeDetectMitigationActionsTaskRequest
  ): IotIO[DescribeDetectMitigationActionsTaskResponse] =
    FF.liftF(DescribeDetectMitigationActionsTaskOp(request))

  def describeDimension(
    request: DescribeDimensionRequest
  ): IotIO[DescribeDimensionResponse] =
    FF.liftF(DescribeDimensionOp(request))

  def describeDomainConfiguration(
    request: DescribeDomainConfigurationRequest
  ): IotIO[DescribeDomainConfigurationResponse] =
    FF.liftF(DescribeDomainConfigurationOp(request))

  def describeEndpoint(
    request: DescribeEndpointRequest
  ): IotIO[DescribeEndpointResponse] =
    FF.liftF(DescribeEndpointOp(request))

  def describeEventConfigurations(
    request: DescribeEventConfigurationsRequest
  ): IotIO[DescribeEventConfigurationsResponse] =
    FF.liftF(DescribeEventConfigurationsOp(request))

  def describeIndex(
    request: DescribeIndexRequest
  ): IotIO[DescribeIndexResponse] =
    FF.liftF(DescribeIndexOp(request))

  def describeJob(
    request: DescribeJobRequest
  ): IotIO[DescribeJobResponse] =
    FF.liftF(DescribeJobOp(request))

  def describeJobExecution(
    request: DescribeJobExecutionRequest
  ): IotIO[DescribeJobExecutionResponse] =
    FF.liftF(DescribeJobExecutionOp(request))

  def describeJobTemplate(
    request: DescribeJobTemplateRequest
  ): IotIO[DescribeJobTemplateResponse] =
    FF.liftF(DescribeJobTemplateOp(request))

  def describeMitigationAction(
    request: DescribeMitigationActionRequest
  ): IotIO[DescribeMitigationActionResponse] =
    FF.liftF(DescribeMitigationActionOp(request))

  def describeProvisioningTemplate(
    request: DescribeProvisioningTemplateRequest
  ): IotIO[DescribeProvisioningTemplateResponse] =
    FF.liftF(DescribeProvisioningTemplateOp(request))

  def describeProvisioningTemplateVersion(
    request: DescribeProvisioningTemplateVersionRequest
  ): IotIO[DescribeProvisioningTemplateVersionResponse] =
    FF.liftF(DescribeProvisioningTemplateVersionOp(request))

  def describeRoleAlias(
    request: DescribeRoleAliasRequest
  ): IotIO[DescribeRoleAliasResponse] =
    FF.liftF(DescribeRoleAliasOp(request))

  def describeScheduledAudit(
    request: DescribeScheduledAuditRequest
  ): IotIO[DescribeScheduledAuditResponse] =
    FF.liftF(DescribeScheduledAuditOp(request))

  def describeSecurityProfile(
    request: DescribeSecurityProfileRequest
  ): IotIO[DescribeSecurityProfileResponse] =
    FF.liftF(DescribeSecurityProfileOp(request))

  def describeStream(
    request: DescribeStreamRequest
  ): IotIO[DescribeStreamResponse] =
    FF.liftF(DescribeStreamOp(request))

  def describeThing(
    request: DescribeThingRequest
  ): IotIO[DescribeThingResponse] =
    FF.liftF(DescribeThingOp(request))

  def describeThingGroup(
    request: DescribeThingGroupRequest
  ): IotIO[DescribeThingGroupResponse] =
    FF.liftF(DescribeThingGroupOp(request))

  def describeThingRegistrationTask(
    request: DescribeThingRegistrationTaskRequest
  ): IotIO[DescribeThingRegistrationTaskResponse] =
    FF.liftF(DescribeThingRegistrationTaskOp(request))

  def describeThingType(
    request: DescribeThingTypeRequest
  ): IotIO[DescribeThingTypeResponse] =
    FF.liftF(DescribeThingTypeOp(request))

  def detachPolicy(
    request: DetachPolicyRequest
  ): IotIO[DetachPolicyResponse] =
    FF.liftF(DetachPolicyOp(request))

  def detachSecurityProfile(
    request: DetachSecurityProfileRequest
  ): IotIO[DetachSecurityProfileResponse] =
    FF.liftF(DetachSecurityProfileOp(request))

  def detachThingPrincipal(
    request: DetachThingPrincipalRequest
  ): IotIO[DetachThingPrincipalResponse] =
    FF.liftF(DetachThingPrincipalOp(request))

  def disableTopicRule(
    request: DisableTopicRuleRequest
  ): IotIO[DisableTopicRuleResponse] =
    FF.liftF(DisableTopicRuleOp(request))

  def enableTopicRule(
    request: EnableTopicRuleRequest
  ): IotIO[EnableTopicRuleResponse] =
    FF.liftF(EnableTopicRuleOp(request))

  def getBehaviorModelTrainingSummaries(
    request: GetBehaviorModelTrainingSummariesRequest
  ): IotIO[GetBehaviorModelTrainingSummariesResponse] =
    FF.liftF(GetBehaviorModelTrainingSummariesOp(request))

  def getCardinality(
    request: GetCardinalityRequest
  ): IotIO[GetCardinalityResponse] =
    FF.liftF(GetCardinalityOp(request))

  def getEffectivePolicies(
    request: GetEffectivePoliciesRequest
  ): IotIO[GetEffectivePoliciesResponse] =
    FF.liftF(GetEffectivePoliciesOp(request))

  def getIndexingConfiguration(
    request: GetIndexingConfigurationRequest
  ): IotIO[GetIndexingConfigurationResponse] =
    FF.liftF(GetIndexingConfigurationOp(request))

  def getJobDocument(
    request: GetJobDocumentRequest
  ): IotIO[GetJobDocumentResponse] =
    FF.liftF(GetJobDocumentOp(request))

  def getLoggingOptions(
    request: GetLoggingOptionsRequest
  ): IotIO[GetLoggingOptionsResponse] =
    FF.liftF(GetLoggingOptionsOp(request))

  def getOTAUpdate(
    request: GetOtaUpdateRequest
  ): IotIO[GetOtaUpdateResponse] =
    FF.liftF(GetOTAUpdateOp(request))

  def getPercentiles(
    request: GetPercentilesRequest
  ): IotIO[GetPercentilesResponse] =
    FF.liftF(GetPercentilesOp(request))

  def getPolicy(
    request: GetPolicyRequest
  ): IotIO[GetPolicyResponse] =
    FF.liftF(GetPolicyOp(request))

  def getPolicyVersion(
    request: GetPolicyVersionRequest
  ): IotIO[GetPolicyVersionResponse] =
    FF.liftF(GetPolicyVersionOp(request))

  def getRegistrationCode(
    request: GetRegistrationCodeRequest
  ): IotIO[GetRegistrationCodeResponse] =
    FF.liftF(GetRegistrationCodeOp(request))

  def getStatistics(
    request: GetStatisticsRequest
  ): IotIO[GetStatisticsResponse] =
    FF.liftF(GetStatisticsOp(request))

  def getTopicRule(
    request: GetTopicRuleRequest
  ): IotIO[GetTopicRuleResponse] =
    FF.liftF(GetTopicRuleOp(request))

  def getTopicRuleDestination(
    request: GetTopicRuleDestinationRequest
  ): IotIO[GetTopicRuleDestinationResponse] =
    FF.liftF(GetTopicRuleDestinationOp(request))

  def getV2LoggingOptions(
    request: GetV2LoggingOptionsRequest
  ): IotIO[GetV2LoggingOptionsResponse] =
    FF.liftF(GetV2LoggingOptionsOp(request))

  def listActiveViolations(
    request: ListActiveViolationsRequest
  ): IotIO[ListActiveViolationsResponse] =
    FF.liftF(ListActiveViolationsOp(request))

  def listAttachedPolicies(
    request: ListAttachedPoliciesRequest
  ): IotIO[ListAttachedPoliciesResponse] =
    FF.liftF(ListAttachedPoliciesOp(request))

  def listAuditFindings(
    request: ListAuditFindingsRequest
  ): IotIO[ListAuditFindingsResponse] =
    FF.liftF(ListAuditFindingsOp(request))

  def listAuditMitigationActionsExecutions(
    request: ListAuditMitigationActionsExecutionsRequest
  ): IotIO[ListAuditMitigationActionsExecutionsResponse] =
    FF.liftF(ListAuditMitigationActionsExecutionsOp(request))

  def listAuditMitigationActionsTasks(
    request: ListAuditMitigationActionsTasksRequest
  ): IotIO[ListAuditMitigationActionsTasksResponse] =
    FF.liftF(ListAuditMitigationActionsTasksOp(request))

  def listAuditSuppressions(
    request: ListAuditSuppressionsRequest
  ): IotIO[ListAuditSuppressionsResponse] =
    FF.liftF(ListAuditSuppressionsOp(request))

  def listAuditTasks(
    request: ListAuditTasksRequest
  ): IotIO[ListAuditTasksResponse] =
    FF.liftF(ListAuditTasksOp(request))

  def listAuthorizers(
    request: ListAuthorizersRequest
  ): IotIO[ListAuthorizersResponse] =
    FF.liftF(ListAuthorizersOp(request))

  def listBillingGroups(
    request: ListBillingGroupsRequest
  ): IotIO[ListBillingGroupsResponse] =
    FF.liftF(ListBillingGroupsOp(request))

  def listCACertificates(
    request: ListCaCertificatesRequest
  ): IotIO[ListCaCertificatesResponse] =
    FF.liftF(ListCACertificatesOp(request))

  def listCertificates(
    request: ListCertificatesRequest
  ): IotIO[ListCertificatesResponse] =
    FF.liftF(ListCertificatesOp(request))

  def listCertificatesByCA(
    request: ListCertificatesByCaRequest
  ): IotIO[ListCertificatesByCaResponse] =
    FF.liftF(ListCertificatesByCAOp(request))

  def listCustomMetrics(
    request: ListCustomMetricsRequest
  ): IotIO[ListCustomMetricsResponse] =
    FF.liftF(ListCustomMetricsOp(request))

  def listDetectMitigationActionsExecutions(
    request: ListDetectMitigationActionsExecutionsRequest
  ): IotIO[ListDetectMitigationActionsExecutionsResponse] =
    FF.liftF(ListDetectMitigationActionsExecutionsOp(request))

  def listDetectMitigationActionsTasks(
    request: ListDetectMitigationActionsTasksRequest
  ): IotIO[ListDetectMitigationActionsTasksResponse] =
    FF.liftF(ListDetectMitigationActionsTasksOp(request))

  def listDimensions(
    request: ListDimensionsRequest
  ): IotIO[ListDimensionsResponse] =
    FF.liftF(ListDimensionsOp(request))

  def listDomainConfigurations(
    request: ListDomainConfigurationsRequest
  ): IotIO[ListDomainConfigurationsResponse] =
    FF.liftF(ListDomainConfigurationsOp(request))

  def listIndices(
    request: ListIndicesRequest
  ): IotIO[ListIndicesResponse] =
    FF.liftF(ListIndicesOp(request))

  def listJobExecutionsForJob(
    request: ListJobExecutionsForJobRequest
  ): IotIO[ListJobExecutionsForJobResponse] =
    FF.liftF(ListJobExecutionsForJobOp(request))

  def listJobExecutionsForThing(
    request: ListJobExecutionsForThingRequest
  ): IotIO[ListJobExecutionsForThingResponse] =
    FF.liftF(ListJobExecutionsForThingOp(request))

  def listJobTemplates(
    request: ListJobTemplatesRequest
  ): IotIO[ListJobTemplatesResponse] =
    FF.liftF(ListJobTemplatesOp(request))

  def listJobs(
    request: ListJobsRequest
  ): IotIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listMitigationActions(
    request: ListMitigationActionsRequest
  ): IotIO[ListMitigationActionsResponse] =
    FF.liftF(ListMitigationActionsOp(request))

  def listOTAUpdates(
    request: ListOtaUpdatesRequest
  ): IotIO[ListOtaUpdatesResponse] =
    FF.liftF(ListOTAUpdatesOp(request))

  def listOutgoingCertificates(
    request: ListOutgoingCertificatesRequest
  ): IotIO[ListOutgoingCertificatesResponse] =
    FF.liftF(ListOutgoingCertificatesOp(request))

  def listPolicies(
    request: ListPoliciesRequest
  ): IotIO[ListPoliciesResponse] =
    FF.liftF(ListPoliciesOp(request))

  def listPolicyVersions(
    request: ListPolicyVersionsRequest
  ): IotIO[ListPolicyVersionsResponse] =
    FF.liftF(ListPolicyVersionsOp(request))

  def listPrincipalThings(
    request: ListPrincipalThingsRequest
  ): IotIO[ListPrincipalThingsResponse] =
    FF.liftF(ListPrincipalThingsOp(request))

  def listProvisioningTemplateVersions(
    request: ListProvisioningTemplateVersionsRequest
  ): IotIO[ListProvisioningTemplateVersionsResponse] =
    FF.liftF(ListProvisioningTemplateVersionsOp(request))

  def listProvisioningTemplates(
    request: ListProvisioningTemplatesRequest
  ): IotIO[ListProvisioningTemplatesResponse] =
    FF.liftF(ListProvisioningTemplatesOp(request))

  def listRoleAliases(
    request: ListRoleAliasesRequest
  ): IotIO[ListRoleAliasesResponse] =
    FF.liftF(ListRoleAliasesOp(request))

  def listScheduledAudits(
    request: ListScheduledAuditsRequest
  ): IotIO[ListScheduledAuditsResponse] =
    FF.liftF(ListScheduledAuditsOp(request))

  def listSecurityProfiles(
    request: ListSecurityProfilesRequest
  ): IotIO[ListSecurityProfilesResponse] =
    FF.liftF(ListSecurityProfilesOp(request))

  def listSecurityProfilesForTarget(
    request: ListSecurityProfilesForTargetRequest
  ): IotIO[ListSecurityProfilesForTargetResponse] =
    FF.liftF(ListSecurityProfilesForTargetOp(request))

  def listStreams(
    request: ListStreamsRequest
  ): IotIO[ListStreamsResponse] =
    FF.liftF(ListStreamsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IotIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTargetsForPolicy(
    request: ListTargetsForPolicyRequest
  ): IotIO[ListTargetsForPolicyResponse] =
    FF.liftF(ListTargetsForPolicyOp(request))

  def listTargetsForSecurityProfile(
    request: ListTargetsForSecurityProfileRequest
  ): IotIO[ListTargetsForSecurityProfileResponse] =
    FF.liftF(ListTargetsForSecurityProfileOp(request))

  def listThingGroups(
    request: ListThingGroupsRequest
  ): IotIO[ListThingGroupsResponse] =
    FF.liftF(ListThingGroupsOp(request))

  def listThingGroupsForThing(
    request: ListThingGroupsForThingRequest
  ): IotIO[ListThingGroupsForThingResponse] =
    FF.liftF(ListThingGroupsForThingOp(request))

  def listThingPrincipals(
    request: ListThingPrincipalsRequest
  ): IotIO[ListThingPrincipalsResponse] =
    FF.liftF(ListThingPrincipalsOp(request))

  def listThingRegistrationTaskReports(
    request: ListThingRegistrationTaskReportsRequest
  ): IotIO[ListThingRegistrationTaskReportsResponse] =
    FF.liftF(ListThingRegistrationTaskReportsOp(request))

  def listThingRegistrationTasks(
    request: ListThingRegistrationTasksRequest
  ): IotIO[ListThingRegistrationTasksResponse] =
    FF.liftF(ListThingRegistrationTasksOp(request))

  def listThingTypes(
    request: ListThingTypesRequest
  ): IotIO[ListThingTypesResponse] =
    FF.liftF(ListThingTypesOp(request))

  def listThings(
    request: ListThingsRequest
  ): IotIO[ListThingsResponse] =
    FF.liftF(ListThingsOp(request))

  def listThingsInBillingGroup(
    request: ListThingsInBillingGroupRequest
  ): IotIO[ListThingsInBillingGroupResponse] =
    FF.liftF(ListThingsInBillingGroupOp(request))

  def listThingsInThingGroup(
    request: ListThingsInThingGroupRequest
  ): IotIO[ListThingsInThingGroupResponse] =
    FF.liftF(ListThingsInThingGroupOp(request))

  def listTopicRuleDestinations(
    request: ListTopicRuleDestinationsRequest
  ): IotIO[ListTopicRuleDestinationsResponse] =
    FF.liftF(ListTopicRuleDestinationsOp(request))

  def listTopicRules(
    request: ListTopicRulesRequest
  ): IotIO[ListTopicRulesResponse] =
    FF.liftF(ListTopicRulesOp(request))

  def listV2LoggingLevels(
    request: ListV2LoggingLevelsRequest
  ): IotIO[ListV2LoggingLevelsResponse] =
    FF.liftF(ListV2LoggingLevelsOp(request))

  def listViolationEvents(
    request: ListViolationEventsRequest
  ): IotIO[ListViolationEventsResponse] =
    FF.liftF(ListViolationEventsOp(request))

  def registerCACertificate(
    request: RegisterCaCertificateRequest
  ): IotIO[RegisterCaCertificateResponse] =
    FF.liftF(RegisterCACertificateOp(request))

  def registerCertificate(
    request: RegisterCertificateRequest
  ): IotIO[RegisterCertificateResponse] =
    FF.liftF(RegisterCertificateOp(request))

  def registerCertificateWithoutCA(
    request: RegisterCertificateWithoutCaRequest
  ): IotIO[RegisterCertificateWithoutCaResponse] =
    FF.liftF(RegisterCertificateWithoutCAOp(request))

  def registerThing(
    request: RegisterThingRequest
  ): IotIO[RegisterThingResponse] =
    FF.liftF(RegisterThingOp(request))

  def rejectCertificateTransfer(
    request: RejectCertificateTransferRequest
  ): IotIO[RejectCertificateTransferResponse] =
    FF.liftF(RejectCertificateTransferOp(request))

  def removeThingFromBillingGroup(
    request: RemoveThingFromBillingGroupRequest
  ): IotIO[RemoveThingFromBillingGroupResponse] =
    FF.liftF(RemoveThingFromBillingGroupOp(request))

  def removeThingFromThingGroup(
    request: RemoveThingFromThingGroupRequest
  ): IotIO[RemoveThingFromThingGroupResponse] =
    FF.liftF(RemoveThingFromThingGroupOp(request))

  def replaceTopicRule(
    request: ReplaceTopicRuleRequest
  ): IotIO[ReplaceTopicRuleResponse] =
    FF.liftF(ReplaceTopicRuleOp(request))

  def searchIndex(
    request: SearchIndexRequest
  ): IotIO[SearchIndexResponse] =
    FF.liftF(SearchIndexOp(request))

  def setDefaultAuthorizer(
    request: SetDefaultAuthorizerRequest
  ): IotIO[SetDefaultAuthorizerResponse] =
    FF.liftF(SetDefaultAuthorizerOp(request))

  def setDefaultPolicyVersion(
    request: SetDefaultPolicyVersionRequest
  ): IotIO[SetDefaultPolicyVersionResponse] =
    FF.liftF(SetDefaultPolicyVersionOp(request))

  def setLoggingOptions(
    request: SetLoggingOptionsRequest
  ): IotIO[SetLoggingOptionsResponse] =
    FF.liftF(SetLoggingOptionsOp(request))

  def setV2LoggingLevel(
    request: SetV2LoggingLevelRequest
  ): IotIO[SetV2LoggingLevelResponse] =
    FF.liftF(SetV2LoggingLevelOp(request))

  def setV2LoggingOptions(
    request: SetV2LoggingOptionsRequest
  ): IotIO[SetV2LoggingOptionsResponse] =
    FF.liftF(SetV2LoggingOptionsOp(request))

  def startAuditMitigationActionsTask(
    request: StartAuditMitigationActionsTaskRequest
  ): IotIO[StartAuditMitigationActionsTaskResponse] =
    FF.liftF(StartAuditMitigationActionsTaskOp(request))

  def startDetectMitigationActionsTask(
    request: StartDetectMitigationActionsTaskRequest
  ): IotIO[StartDetectMitigationActionsTaskResponse] =
    FF.liftF(StartDetectMitigationActionsTaskOp(request))

  def startOnDemandAuditTask(
    request: StartOnDemandAuditTaskRequest
  ): IotIO[StartOnDemandAuditTaskResponse] =
    FF.liftF(StartOnDemandAuditTaskOp(request))

  def startThingRegistrationTask(
    request: StartThingRegistrationTaskRequest
  ): IotIO[StartThingRegistrationTaskResponse] =
    FF.liftF(StartThingRegistrationTaskOp(request))

  def stopThingRegistrationTask(
    request: StopThingRegistrationTaskRequest
  ): IotIO[StopThingRegistrationTaskResponse] =
    FF.liftF(StopThingRegistrationTaskOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IotIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testAuthorization(
    request: TestAuthorizationRequest
  ): IotIO[TestAuthorizationResponse] =
    FF.liftF(TestAuthorizationOp(request))

  def testInvokeAuthorizer(
    request: TestInvokeAuthorizerRequest
  ): IotIO[TestInvokeAuthorizerResponse] =
    FF.liftF(TestInvokeAuthorizerOp(request))

  def transferCertificate(
    request: TransferCertificateRequest
  ): IotIO[TransferCertificateResponse] =
    FF.liftF(TransferCertificateOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IotIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccountAuditConfiguration(
    request: UpdateAccountAuditConfigurationRequest
  ): IotIO[UpdateAccountAuditConfigurationResponse] =
    FF.liftF(UpdateAccountAuditConfigurationOp(request))

  def updateAuditSuppression(
    request: UpdateAuditSuppressionRequest
  ): IotIO[UpdateAuditSuppressionResponse] =
    FF.liftF(UpdateAuditSuppressionOp(request))

  def updateAuthorizer(
    request: UpdateAuthorizerRequest
  ): IotIO[UpdateAuthorizerResponse] =
    FF.liftF(UpdateAuthorizerOp(request))

  def updateBillingGroup(
    request: UpdateBillingGroupRequest
  ): IotIO[UpdateBillingGroupResponse] =
    FF.liftF(UpdateBillingGroupOp(request))

  def updateCACertificate(
    request: UpdateCaCertificateRequest
  ): IotIO[UpdateCaCertificateResponse] =
    FF.liftF(UpdateCACertificateOp(request))

  def updateCertificate(
    request: UpdateCertificateRequest
  ): IotIO[UpdateCertificateResponse] =
    FF.liftF(UpdateCertificateOp(request))

  def updateCustomMetric(
    request: UpdateCustomMetricRequest
  ): IotIO[UpdateCustomMetricResponse] =
    FF.liftF(UpdateCustomMetricOp(request))

  def updateDimension(
    request: UpdateDimensionRequest
  ): IotIO[UpdateDimensionResponse] =
    FF.liftF(UpdateDimensionOp(request))

  def updateDomainConfiguration(
    request: UpdateDomainConfigurationRequest
  ): IotIO[UpdateDomainConfigurationResponse] =
    FF.liftF(UpdateDomainConfigurationOp(request))

  def updateDynamicThingGroup(
    request: UpdateDynamicThingGroupRequest
  ): IotIO[UpdateDynamicThingGroupResponse] =
    FF.liftF(UpdateDynamicThingGroupOp(request))

  def updateEventConfigurations(
    request: UpdateEventConfigurationsRequest
  ): IotIO[UpdateEventConfigurationsResponse] =
    FF.liftF(UpdateEventConfigurationsOp(request))

  def updateIndexingConfiguration(
    request: UpdateIndexingConfigurationRequest
  ): IotIO[UpdateIndexingConfigurationResponse] =
    FF.liftF(UpdateIndexingConfigurationOp(request))

  def updateJob(
    request: UpdateJobRequest
  ): IotIO[UpdateJobResponse] =
    FF.liftF(UpdateJobOp(request))

  def updateMitigationAction(
    request: UpdateMitigationActionRequest
  ): IotIO[UpdateMitigationActionResponse] =
    FF.liftF(UpdateMitigationActionOp(request))

  def updateProvisioningTemplate(
    request: UpdateProvisioningTemplateRequest
  ): IotIO[UpdateProvisioningTemplateResponse] =
    FF.liftF(UpdateProvisioningTemplateOp(request))

  def updateRoleAlias(
    request: UpdateRoleAliasRequest
  ): IotIO[UpdateRoleAliasResponse] =
    FF.liftF(UpdateRoleAliasOp(request))

  def updateScheduledAudit(
    request: UpdateScheduledAuditRequest
  ): IotIO[UpdateScheduledAuditResponse] =
    FF.liftF(UpdateScheduledAuditOp(request))

  def updateSecurityProfile(
    request: UpdateSecurityProfileRequest
  ): IotIO[UpdateSecurityProfileResponse] =
    FF.liftF(UpdateSecurityProfileOp(request))

  def updateStream(
    request: UpdateStreamRequest
  ): IotIO[UpdateStreamResponse] =
    FF.liftF(UpdateStreamOp(request))

  def updateThing(
    request: UpdateThingRequest
  ): IotIO[UpdateThingResponse] =
    FF.liftF(UpdateThingOp(request))

  def updateThingGroup(
    request: UpdateThingGroupRequest
  ): IotIO[UpdateThingGroupResponse] =
    FF.liftF(UpdateThingGroupOp(request))

  def updateThingGroupsForThing(
    request: UpdateThingGroupsForThingRequest
  ): IotIO[UpdateThingGroupsForThingResponse] =
    FF.liftF(UpdateThingGroupsForThingOp(request))

  def updateTopicRuleDestination(
    request: UpdateTopicRuleDestinationRequest
  ): IotIO[UpdateTopicRuleDestinationResponse] =
    FF.liftF(UpdateTopicRuleDestinationOp(request))

  def validateSecurityProfileBehaviors(
    request: ValidateSecurityProfileBehaviorsRequest
  ): IotIO[ValidateSecurityProfileBehaviorsResponse] =
    FF.liftF(ValidateSecurityProfileBehaviorsOp(request))
}
