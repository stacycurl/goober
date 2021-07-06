package goober.hi

import goober.free.ses.SesIO
import software.amazon.awssdk.services.ses.model._


object ses {
  import goober.free.{ses ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CloneReceiptRuleSetRequest
    // CreateConfigurationSetEventDestinationRequest
    // CreateConfigurationSetRequest
    // CreateConfigurationSetTrackingOptionsRequest
    // CreateCustomVerificationEmailTemplateRequest
    // CreateReceiptFilterRequest
    // CreateReceiptRuleRequest
    // CreateReceiptRuleSetRequest
    // CreateTemplateRequest
    // DeleteConfigurationSetEventDestinationRequest
    // DeleteConfigurationSetRequest
    // DeleteConfigurationSetTrackingOptionsRequest
    // DeleteCustomVerificationEmailTemplateRequest
    // DeleteIdentityPolicyRequest
    // DeleteIdentityRequest
    // DeleteReceiptFilterRequest
    // DeleteReceiptRuleRequest
    // DeleteReceiptRuleSetRequest
    // DeleteTemplateRequest
    // DeleteVerifiedEmailAddressRequest
    // DescribeActiveReceiptRuleSetRequest
    // DescribeConfigurationSetRequest
    // DescribeReceiptRuleRequest
    // DescribeReceiptRuleSetRequest
    // GetAccountSendingEnabledRequest
    // GetCustomVerificationEmailTemplateRequest
    // GetIdentityDkimAttributesRequest
    // GetIdentityMailFromDomainAttributesRequest
    // GetIdentityNotificationAttributesRequest
    // GetIdentityPoliciesRequest
    // GetIdentityVerificationAttributesRequest
    // GetSendQuotaRequest
    // GetSendStatisticsRequest
    // GetTemplateRequest
    // ListConfigurationSetsRequest
    // ListCustomVerificationEmailTemplatesRequest
    // ListIdentitiesRequest
    // ListIdentityPoliciesRequest
    // ListReceiptFiltersRequest
    // ListReceiptRuleSetsRequest
    // ListTemplatesRequest
    // ListVerifiedEmailAddressesRequest
    // PutConfigurationSetDeliveryOptionsRequest
    // PutIdentityPolicyRequest
    // ReorderReceiptRuleSetRequest
    // SendBounceRequest
    // SendBulkTemplatedEmailRequest
    // SendCustomVerificationEmailRequest
    // SendEmailRequest
    // SendRawEmailRequest
    // SendTemplatedEmailRequest
    // SetActiveReceiptRuleSetRequest
    // SetIdentityDkimEnabledRequest
    // SetIdentityFeedbackForwardingEnabledRequest
    // SetIdentityHeadersInNotificationsEnabledRequest
    // SetIdentityMailFromDomainRequest
    // SetIdentityNotificationTopicRequest
    // SetReceiptRulePositionRequest
    // TestRenderTemplateRequest
    // UpdateAccountSendingEnabledRequest
    // UpdateConfigurationSetEventDestinationRequest
    // UpdateConfigurationSetReputationMetricsEnabledRequest
    // UpdateConfigurationSetSendingEnabledRequest
    // UpdateConfigurationSetTrackingOptionsRequest
    // UpdateCustomVerificationEmailTemplateRequest
    // UpdateReceiptRuleRequest
    // UpdateTemplateRequest
    // VerifyDomainDkimRequest
    // VerifyDomainIdentityRequest
    // VerifyEmailAddressRequest
    // VerifyEmailIdentityRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
