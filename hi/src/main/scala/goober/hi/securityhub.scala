package goober.hi

import goober.free.securityhub.SecurityHubIO
import software.amazon.awssdk.services.securityhub.model._


object securityhub {
  import goober.free.{securityhub ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // AcceptAdministratorInvitationRequest
    // AcceptInvitationRequest
    // BatchDisableStandardsRequest
    // BatchEnableStandardsRequest
    // BatchImportFindingsRequest
    // BatchUpdateFindingsRequest
    // CreateActionTargetRequest
    // CreateInsightRequest
    // CreateMembersRequest
    // DeclineInvitationsRequest
    // DeleteActionTargetRequest
    // DeleteInsightRequest
    // DeleteInvitationsRequest
    // DeleteMembersRequest
    // DescribeActionTargetsRequest
    // DescribeHubRequest
    // DescribeOrganizationConfigurationRequest
    // DescribeProductsRequest
    // DescribeStandardsControlsRequest
    // DescribeStandardsRequest
    // DisableImportFindingsForProductRequest
    // DisableOrganizationAdminAccountRequest
    // DisableSecurityHubRequest
    // DisassociateFromAdministratorAccountRequest
    // DisassociateFromMasterAccountRequest
    // DisassociateMembersRequest
    // EnableImportFindingsForProductRequest
    // EnableOrganizationAdminAccountRequest
    // EnableSecurityHubRequest
    // GetAdministratorAccountRequest
    // GetEnabledStandardsRequest
    // GetFindingsRequest
    // GetInsightResultsRequest
    // GetInsightsRequest
    // GetInvitationsCountRequest
    // GetMasterAccountRequest
    // GetMembersRequest
    // InviteMembersRequest
    // ListEnabledProductsForImportRequest
    // ListInvitationsRequest
    // ListMembersRequest
    // ListOrganizationAdminAccountsRequest
    // ListTagsForResourceRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateActionTargetRequest
    // UpdateFindingsRequest
    // UpdateInsightRequest
    // UpdateOrganizationConfigurationRequest
    // UpdateSecurityHubConfigurationRequest
    // UpdateStandardsControlRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
