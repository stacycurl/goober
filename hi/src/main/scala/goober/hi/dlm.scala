package goober.hi

import goober.free.dlm.DlmIO
import software.amazon.awssdk.services.dlm.model._


object dlm {
  import goober.free.{dlm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def action(
      name: Option[String] = None,
      crossRegionCopy: Option[List[CrossRegionCopyAction]] = None
    ): Action =
      Action
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(crossRegionCopy)(_.crossRegionCopy(_))
        .build

    def createLifecyclePolicyRequest(
      executionRoleArn: Option[String] = None,
      description: Option[String] = None,
      state: Option[String] = None,
      policyDetails: Option[PolicyDetails] = None,
      tags: Option[TagMap] = None
    ): CreateLifecyclePolicyRequest =
      CreateLifecyclePolicyRequest
        .builder
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(state)(_.state(_))
        .ifSome(policyDetails)(_.policyDetails(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLifecyclePolicyResponse(
      policyId: Option[String] = None
    ): CreateLifecyclePolicyResponse =
      CreateLifecyclePolicyResponse
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def createRule(
      location: Option[String] = None,
      interval: Option[Int] = None,
      intervalUnit: Option[String] = None,
      times: Option[List[Time]] = None,
      cronExpression: Option[String] = None
    ): CreateRule =
      CreateRule
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(intervalUnit)(_.intervalUnit(_))
        .ifSome(times)(_.times(_))
        .ifSome(cronExpression)(_.cronExpression(_))
        .build

    def crossRegionCopyAction(
      target: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      retainRule: Option[CrossRegionCopyRetainRule] = None
    ): CrossRegionCopyAction =
      CrossRegionCopyAction
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(retainRule)(_.retainRule(_))
        .build

    def crossRegionCopyRetainRule(
      interval: Option[Int] = None,
      intervalUnit: Option[String] = None
    ): CrossRegionCopyRetainRule =
      CrossRegionCopyRetainRule
        .builder
        .ifSome(interval)(_.interval(_))
        .ifSome(intervalUnit)(_.intervalUnit(_))
        .build

    def crossRegionCopyRule(
      targetRegion: Option[String] = None,
      target: Option[String] = None,
      encrypted: Option[Boolean] = None,
      cmkArn: Option[String] = None,
      copyTags: Option[Boolean] = None,
      retainRule: Option[CrossRegionCopyRetainRule] = None
    ): CrossRegionCopyRule =
      CrossRegionCopyRule
        .builder
        .ifSome(targetRegion)(_.targetRegion(_))
        .ifSome(target)(_.target(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(cmkArn)(_.cmkArn(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(retainRule)(_.retainRule(_))
        .build

    def deleteLifecyclePolicyRequest(
      policyId: Option[String] = None
    ): DeleteLifecyclePolicyRequest =
      DeleteLifecyclePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def deleteLifecyclePolicyResponse(

    ): DeleteLifecyclePolicyResponse =
      DeleteLifecyclePolicyResponse
        .builder

        .build

    def encryptionConfiguration(
      encrypted: Option[Boolean] = None,
      cmkArn: Option[String] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(cmkArn)(_.cmkArn(_))
        .build

    def eventParameters(
      eventType: Option[String] = None,
      snapshotOwner: Option[List[AwsAccountId]] = None,
      descriptionRegex: Option[String] = None
    ): EventParameters =
      EventParameters
        .builder
        .ifSome(eventType)(_.eventType(_))
        .ifSome(snapshotOwner)(_.snapshotOwner(_))
        .ifSome(descriptionRegex)(_.descriptionRegex(_))
        .build

    def eventSource(
      `type`: Option[String] = None,
      parameters: Option[EventParameters] = None
    ): EventSource =
      EventSource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def fastRestoreRule(
      count: Option[Int] = None,
      interval: Option[Int] = None,
      intervalUnit: Option[String] = None,
      availabilityZones: Option[List[AvailabilityZone]] = None
    ): FastRestoreRule =
      FastRestoreRule
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(intervalUnit)(_.intervalUnit(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def getLifecyclePoliciesRequest(
      policyIds: Option[List[PolicyId]] = None,
      state: Option[String] = None,
      resourceTypes: Option[List[ResourceTypeValues]] = None,
      targetTags: Option[List[TagFilter]] = None,
      tagsToAdd: Option[List[TagFilter]] = None
    ): GetLifecyclePoliciesRequest =
      GetLifecyclePoliciesRequest
        .builder
        .ifSome(policyIds)(_.policyIds(_))
        .ifSome(state)(_.state(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(targetTags)(_.targetTags(_))
        .ifSome(tagsToAdd)(_.tagsToAdd(_))
        .build

    def getLifecyclePoliciesResponse(
      policies: Option[List[LifecyclePolicySummary]] = None
    ): GetLifecyclePoliciesResponse =
      GetLifecyclePoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .build

    def getLifecyclePolicyRequest(
      policyId: Option[String] = None
    ): GetLifecyclePolicyRequest =
      GetLifecyclePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def getLifecyclePolicyResponse(
      policy: Option[LifecyclePolicy] = None
    ): GetLifecyclePolicyResponse =
      GetLifecyclePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      code: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def invalidRequestException(
      message: Option[String] = None,
      code: Option[String] = None,
      requiredParameters: Option[List[Parameter]] = None,
      mutuallyExclusiveParameters: Option[List[Parameter]] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .ifSome(requiredParameters)(_.requiredParameters(_))
        .ifSome(mutuallyExclusiveParameters)(_.mutuallyExclusiveParameters(_))
        .build

    def lifecyclePolicy(
      policyId: Option[String] = None,
      description: Option[String] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      executionRoleArn: Option[String] = None,
      dateCreated: Option[Timestamp] = None,
      dateModified: Option[Timestamp] = None,
      policyDetails: Option[PolicyDetails] = None,
      tags: Option[TagMap] = None,
      policyArn: Option[String] = None
    ): LifecyclePolicy =
      LifecyclePolicy
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(description)(_.description(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateModified)(_.dateModified(_))
        .ifSome(policyDetails)(_.policyDetails(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def lifecyclePolicySummary(
      policyId: Option[String] = None,
      description: Option[String] = None,
      state: Option[String] = None,
      tags: Option[TagMap] = None,
      policyType: Option[String] = None
    ): LifecyclePolicySummary =
      LifecyclePolicySummary
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(description)(_.description(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(policyType)(_.policyType(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      code: Option[String] = None,
      resourceType: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def parameters(
      excludeBootVolume: Option[Boolean] = None,
      noReboot: Option[Boolean] = None
    ): Parameters =
      Parameters
        .builder
        .ifSome(excludeBootVolume)(_.excludeBootVolume(_))
        .ifSome(noReboot)(_.noReboot(_))
        .build

    def policyDetails(
      policyType: Option[String] = None,
      resourceTypes: Option[List[ResourceTypeValues]] = None,
      resourceLocations: Option[List[ResourceLocationValues]] = None,
      targetTags: Option[List[Tag]] = None,
      schedules: Option[List[Schedule]] = None,
      parameters: Option[Parameters] = None,
      eventSource: Option[EventSource] = None,
      actions: Option[List[Action]] = None
    ): PolicyDetails =
      PolicyDetails
        .builder
        .ifSome(policyType)(_.policyType(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(resourceLocations)(_.resourceLocations(_))
        .ifSome(targetTags)(_.targetTags(_))
        .ifSome(schedules)(_.schedules(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(actions)(_.actions(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      code: Option[String] = None,
      resourceType: Option[String] = None,
      resourceIds: Option[List[PolicyId]] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def retainRule(
      count: Option[Int] = None,
      interval: Option[Int] = None,
      intervalUnit: Option[String] = None
    ): RetainRule =
      RetainRule
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(intervalUnit)(_.intervalUnit(_))
        .build

    def schedule(
      name: Option[String] = None,
      copyTags: Option[Boolean] = None,
      tagsToAdd: Option[List[Tag]] = None,
      variableTags: Option[List[Tag]] = None,
      createRule: Option[CreateRule] = None,
      retainRule: Option[RetainRule] = None,
      fastRestoreRule: Option[FastRestoreRule] = None,
      crossRegionCopyRules: Option[List[CrossRegionCopyRule]] = None,
      shareRules: Option[List[ShareRule]] = None
    ): Schedule =
      Schedule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(tagsToAdd)(_.tagsToAdd(_))
        .ifSome(variableTags)(_.variableTags(_))
        .ifSome(createRule)(_.createRule(_))
        .ifSome(retainRule)(_.retainRule(_))
        .ifSome(fastRestoreRule)(_.fastRestoreRule(_))
        .ifSome(crossRegionCopyRules)(_.crossRegionCopyRules(_))
        .ifSome(shareRules)(_.shareRules(_))
        .build

    def shareRule(
      targetAccounts: Option[List[AwsAccountId]] = None,
      unshareInterval: Option[Int] = None,
      unshareIntervalUnit: Option[String] = None
    ): ShareRule =
      ShareRule
        .builder
        .ifSome(targetAccounts)(_.targetAccounts(_))
        .ifSome(unshareInterval)(_.unshareInterval(_))
        .ifSome(unshareIntervalUnit)(_.unshareIntervalUnit(_))
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
      tags: Option[TagMap] = None
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

    def updateLifecyclePolicyRequest(
      policyId: Option[String] = None,
      executionRoleArn: Option[String] = None,
      state: Option[String] = None,
      description: Option[String] = None,
      policyDetails: Option[PolicyDetails] = None
    ): UpdateLifecyclePolicyRequest =
      UpdateLifecyclePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .ifSome(policyDetails)(_.policyDetails(_))
        .build

    def updateLifecyclePolicyResponse(

    ): UpdateLifecyclePolicyResponse =
      UpdateLifecyclePolicyResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
