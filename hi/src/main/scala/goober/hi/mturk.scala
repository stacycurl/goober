package goober.hi

import goober.free.mturk.MTurkIO
import software.amazon.awssdk.services.mturk.model._


object mturk {
  import goober.free.{mturk ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptQualificationRequestRequest(
      qualificationRequestId: Option[String] = None,
      integerValue: Option[Int] = None
    ): AcceptQualificationRequestRequest =
      AcceptQualificationRequestRequest
        .builder
        .ifSome(qualificationRequestId)(_.qualificationRequestId(_))
        .ifSome(integerValue)(_.integerValue(_))
        .build

    def acceptQualificationRequestResponse(

    ): AcceptQualificationRequestResponse =
      AcceptQualificationRequestResponse
        .builder

        .build

    def approveAssignmentRequest(
      assignmentId: Option[String] = None,
      requesterFeedback: Option[String] = None,
      overrideRejection: Option[Boolean] = None
    ): ApproveAssignmentRequest =
      ApproveAssignmentRequest
        .builder
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(requesterFeedback)(_.requesterFeedback(_))
        .ifSome(overrideRejection)(_.overrideRejection(_))
        .build

    def approveAssignmentResponse(

    ): ApproveAssignmentResponse =
      ApproveAssignmentResponse
        .builder

        .build

    def assignment(
      assignmentId: Option[String] = None,
      workerId: Option[String] = None,
      hITId: Option[String] = None,
      assignmentStatus: Option[String] = None,
      autoApprovalTime: Option[Timestamp] = None,
      acceptTime: Option[Timestamp] = None,
      submitTime: Option[Timestamp] = None,
      approvalTime: Option[Timestamp] = None,
      rejectionTime: Option[Timestamp] = None,
      deadline: Option[Timestamp] = None,
      answer: Option[String] = None,
      requesterFeedback: Option[String] = None
    ): Assignment =
      Assignment
        .builder
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(workerId)(_.workerId(_))
        .ifSome(hITId)(_.hITId(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(autoApprovalTime)(_.autoApprovalTime(_))
        .ifSome(acceptTime)(_.acceptTime(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(approvalTime)(_.approvalTime(_))
        .ifSome(rejectionTime)(_.rejectionTime(_))
        .ifSome(deadline)(_.deadline(_))
        .ifSome(answer)(_.answer(_))
        .ifSome(requesterFeedback)(_.requesterFeedback(_))
        .build

    def associateQualificationWithWorkerRequest(
      qualificationTypeId: Option[String] = None,
      workerId: Option[String] = None,
      integerValue: Option[Int] = None,
      sendNotification: Option[Boolean] = None
    ): AssociateQualificationWithWorkerRequest =
      AssociateQualificationWithWorkerRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(workerId)(_.workerId(_))
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(sendNotification)(_.sendNotification(_))
        .build

    def associateQualificationWithWorkerResponse(

    ): AssociateQualificationWithWorkerResponse =
      AssociateQualificationWithWorkerResponse
        .builder

        .build

    def bonusPayment(
      workerId: Option[String] = None,
      bonusAmount: Option[String] = None,
      assignmentId: Option[String] = None,
      reason: Option[String] = None,
      grantTime: Option[Timestamp] = None
    ): BonusPayment =
      BonusPayment
        .builder
        .ifSome(workerId)(_.workerId(_))
        .ifSome(bonusAmount)(_.bonusAmount(_))
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(grantTime)(_.grantTime(_))
        .build

    def createAdditionalAssignmentsForHITRequest(
      hITId: Option[String] = None,
      numberOfAdditionalAssignments: Option[Int] = None,
      uniqueRequestToken: Option[String] = None
    ): CreateAdditionalAssignmentsForHITRequest =
      CreateAdditionalAssignmentsForHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(numberOfAdditionalAssignments)(_.numberOfAdditionalAssignments(_))
        .ifSome(uniqueRequestToken)(_.uniqueRequestToken(_))
        .build

    def createAdditionalAssignmentsForHITResponse(

    ): CreateAdditionalAssignmentsForHITResponse =
      CreateAdditionalAssignmentsForHITResponse
        .builder

        .build

    def createHITRequest(
      maxAssignments: Option[Int] = None,
      autoApprovalDelayInSeconds: Option[Long] = None,
      lifetimeInSeconds: Option[Long] = None,
      assignmentDurationInSeconds: Option[Long] = None,
      reward: Option[String] = None,
      title: Option[String] = None,
      keywords: Option[String] = None,
      description: Option[String] = None,
      question: Option[String] = None,
      requesterAnnotation: Option[String] = None,
      qualificationRequirements: Option[List[QualificationRequirement]] = None,
      uniqueRequestToken: Option[String] = None,
      assignmentReviewPolicy: Option[ReviewPolicy] = None,
      hITReviewPolicy: Option[ReviewPolicy] = None,
      hITLayoutId: Option[String] = None,
      hITLayoutParameters: Option[List[HITLayoutParameter]] = None
    ): CreateHITRequest =
      CreateHITRequest
        .builder
        .ifSome(maxAssignments)(_.maxAssignments(_))
        .ifSome(autoApprovalDelayInSeconds)(_.autoApprovalDelayInSeconds(_))
        .ifSome(lifetimeInSeconds)(_.lifetimeInSeconds(_))
        .ifSome(assignmentDurationInSeconds)(_.assignmentDurationInSeconds(_))
        .ifSome(reward)(_.reward(_))
        .ifSome(title)(_.title(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(description)(_.description(_))
        .ifSome(question)(_.question(_))
        .ifSome(requesterAnnotation)(_.requesterAnnotation(_))
        .ifSome(qualificationRequirements)(_.qualificationRequirements(_))
        .ifSome(uniqueRequestToken)(_.uniqueRequestToken(_))
        .ifSome(assignmentReviewPolicy)(_.assignmentReviewPolicy(_))
        .ifSome(hITReviewPolicy)(_.hITReviewPolicy(_))
        .ifSome(hITLayoutId)(_.hITLayoutId(_))
        .ifSome(hITLayoutParameters)(_.hITLayoutParameters(_))
        .build

    def createHITResponse(
      hIT: Option[HIT] = None
    ): CreateHITResponse =
      CreateHITResponse
        .builder
        .ifSome(hIT)(_.hIT(_))
        .build

    def createHITTypeRequest(
      autoApprovalDelayInSeconds: Option[Long] = None,
      assignmentDurationInSeconds: Option[Long] = None,
      reward: Option[String] = None,
      title: Option[String] = None,
      keywords: Option[String] = None,
      description: Option[String] = None,
      qualificationRequirements: Option[List[QualificationRequirement]] = None
    ): CreateHITTypeRequest =
      CreateHITTypeRequest
        .builder
        .ifSome(autoApprovalDelayInSeconds)(_.autoApprovalDelayInSeconds(_))
        .ifSome(assignmentDurationInSeconds)(_.assignmentDurationInSeconds(_))
        .ifSome(reward)(_.reward(_))
        .ifSome(title)(_.title(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(description)(_.description(_))
        .ifSome(qualificationRequirements)(_.qualificationRequirements(_))
        .build

    def createHITTypeResponse(
      hITTypeId: Option[String] = None
    ): CreateHITTypeResponse =
      CreateHITTypeResponse
        .builder
        .ifSome(hITTypeId)(_.hITTypeId(_))
        .build

    def createHITWithHITTypeRequest(
      hITTypeId: Option[String] = None,
      maxAssignments: Option[Int] = None,
      lifetimeInSeconds: Option[Long] = None,
      question: Option[String] = None,
      requesterAnnotation: Option[String] = None,
      uniqueRequestToken: Option[String] = None,
      assignmentReviewPolicy: Option[ReviewPolicy] = None,
      hITReviewPolicy: Option[ReviewPolicy] = None,
      hITLayoutId: Option[String] = None,
      hITLayoutParameters: Option[List[HITLayoutParameter]] = None
    ): CreateHITWithHITTypeRequest =
      CreateHITWithHITTypeRequest
        .builder
        .ifSome(hITTypeId)(_.hITTypeId(_))
        .ifSome(maxAssignments)(_.maxAssignments(_))
        .ifSome(lifetimeInSeconds)(_.lifetimeInSeconds(_))
        .ifSome(question)(_.question(_))
        .ifSome(requesterAnnotation)(_.requesterAnnotation(_))
        .ifSome(uniqueRequestToken)(_.uniqueRequestToken(_))
        .ifSome(assignmentReviewPolicy)(_.assignmentReviewPolicy(_))
        .ifSome(hITReviewPolicy)(_.hITReviewPolicy(_))
        .ifSome(hITLayoutId)(_.hITLayoutId(_))
        .ifSome(hITLayoutParameters)(_.hITLayoutParameters(_))
        .build

    def createHITWithHITTypeResponse(
      hIT: Option[HIT] = None
    ): CreateHITWithHITTypeResponse =
      CreateHITWithHITTypeResponse
        .builder
        .ifSome(hIT)(_.hIT(_))
        .build

    def createQualificationTypeRequest(
      name: Option[String] = None,
      keywords: Option[String] = None,
      description: Option[String] = None,
      qualificationTypeStatus: Option[String] = None,
      retryDelayInSeconds: Option[Long] = None,
      test: Option[String] = None,
      answerKey: Option[String] = None,
      testDurationInSeconds: Option[Long] = None,
      autoGranted: Option[Boolean] = None,
      autoGrantedValue: Option[Int] = None
    ): CreateQualificationTypeRequest =
      CreateQualificationTypeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(description)(_.description(_))
        .ifSome(qualificationTypeStatus)(_.qualificationTypeStatus(_))
        .ifSome(retryDelayInSeconds)(_.retryDelayInSeconds(_))
        .ifSome(test)(_.test(_))
        .ifSome(answerKey)(_.answerKey(_))
        .ifSome(testDurationInSeconds)(_.testDurationInSeconds(_))
        .ifSome(autoGranted)(_.autoGranted(_))
        .ifSome(autoGrantedValue)(_.autoGrantedValue(_))
        .build

    def createQualificationTypeResponse(
      qualificationType: Option[QualificationType] = None
    ): CreateQualificationTypeResponse =
      CreateQualificationTypeResponse
        .builder
        .ifSome(qualificationType)(_.qualificationType(_))
        .build

    def createWorkerBlockRequest(
      workerId: Option[String] = None,
      reason: Option[String] = None
    ): CreateWorkerBlockRequest =
      CreateWorkerBlockRequest
        .builder
        .ifSome(workerId)(_.workerId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def createWorkerBlockResponse(

    ): CreateWorkerBlockResponse =
      CreateWorkerBlockResponse
        .builder

        .build

    def deleteHITRequest(
      hITId: Option[String] = None
    ): DeleteHITRequest =
      DeleteHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .build

    def deleteHITResponse(

    ): DeleteHITResponse =
      DeleteHITResponse
        .builder

        .build

    def deleteQualificationTypeRequest(
      qualificationTypeId: Option[String] = None
    ): DeleteQualificationTypeRequest =
      DeleteQualificationTypeRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .build

    def deleteQualificationTypeResponse(

    ): DeleteQualificationTypeResponse =
      DeleteQualificationTypeResponse
        .builder

        .build

    def deleteWorkerBlockRequest(
      workerId: Option[String] = None,
      reason: Option[String] = None
    ): DeleteWorkerBlockRequest =
      DeleteWorkerBlockRequest
        .builder
        .ifSome(workerId)(_.workerId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def deleteWorkerBlockResponse(

    ): DeleteWorkerBlockResponse =
      DeleteWorkerBlockResponse
        .builder

        .build

    def disassociateQualificationFromWorkerRequest(
      workerId: Option[String] = None,
      qualificationTypeId: Option[String] = None,
      reason: Option[String] = None
    ): DisassociateQualificationFromWorkerRequest =
      DisassociateQualificationFromWorkerRequest
        .builder
        .ifSome(workerId)(_.workerId(_))
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def disassociateQualificationFromWorkerResponse(

    ): DisassociateQualificationFromWorkerResponse =
      DisassociateQualificationFromWorkerResponse
        .builder

        .build

    def getAccountBalanceRequest(

    ): GetAccountBalanceRequest =
      GetAccountBalanceRequest
        .builder

        .build

    def getAccountBalanceResponse(
      availableBalance: Option[String] = None,
      onHoldBalance: Option[String] = None
    ): GetAccountBalanceResponse =
      GetAccountBalanceResponse
        .builder
        .ifSome(availableBalance)(_.availableBalance(_))
        .ifSome(onHoldBalance)(_.onHoldBalance(_))
        .build

    def getAssignmentRequest(
      assignmentId: Option[String] = None
    ): GetAssignmentRequest =
      GetAssignmentRequest
        .builder
        .ifSome(assignmentId)(_.assignmentId(_))
        .build

    def getAssignmentResponse(
      assignment: Option[Assignment] = None,
      hIT: Option[HIT] = None
    ): GetAssignmentResponse =
      GetAssignmentResponse
        .builder
        .ifSome(assignment)(_.assignment(_))
        .ifSome(hIT)(_.hIT(_))
        .build

    def getFileUploadURLRequest(
      assignmentId: Option[String] = None,
      questionIdentifier: Option[String] = None
    ): GetFileUploadURLRequest =
      GetFileUploadURLRequest
        .builder
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(questionIdentifier)(_.questionIdentifier(_))
        .build

    def getFileUploadURLResponse(
      fileUploadURL: Option[String] = None
    ): GetFileUploadURLResponse =
      GetFileUploadURLResponse
        .builder
        .ifSome(fileUploadURL)(_.fileUploadURL(_))
        .build

    def getHITRequest(
      hITId: Option[String] = None
    ): GetHITRequest =
      GetHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .build

    def getHITResponse(
      hIT: Option[HIT] = None
    ): GetHITResponse =
      GetHITResponse
        .builder
        .ifSome(hIT)(_.hIT(_))
        .build

    def getQualificationScoreRequest(
      qualificationTypeId: Option[String] = None,
      workerId: Option[String] = None
    ): GetQualificationScoreRequest =
      GetQualificationScoreRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(workerId)(_.workerId(_))
        .build

    def getQualificationScoreResponse(
      qualification: Option[Qualification] = None
    ): GetQualificationScoreResponse =
      GetQualificationScoreResponse
        .builder
        .ifSome(qualification)(_.qualification(_))
        .build

    def getQualificationTypeRequest(
      qualificationTypeId: Option[String] = None
    ): GetQualificationTypeRequest =
      GetQualificationTypeRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .build

    def getQualificationTypeResponse(
      qualificationType: Option[QualificationType] = None
    ): GetQualificationTypeResponse =
      GetQualificationTypeResponse
        .builder
        .ifSome(qualificationType)(_.qualificationType(_))
        .build

    def hIT(
      hITId: Option[String] = None,
      hITTypeId: Option[String] = None,
      hITGroupId: Option[String] = None,
      hITLayoutId: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      question: Option[String] = None,
      keywords: Option[String] = None,
      hITStatus: Option[String] = None,
      maxAssignments: Option[Int] = None,
      reward: Option[String] = None,
      autoApprovalDelayInSeconds: Option[Long] = None,
      expiration: Option[Timestamp] = None,
      assignmentDurationInSeconds: Option[Long] = None,
      requesterAnnotation: Option[String] = None,
      qualificationRequirements: Option[List[QualificationRequirement]] = None,
      hITReviewStatus: Option[String] = None,
      numberOfAssignmentsPending: Option[Int] = None,
      numberOfAssignmentsAvailable: Option[Int] = None,
      numberOfAssignmentsCompleted: Option[Int] = None
    ): HIT =
      HIT
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(hITTypeId)(_.hITTypeId(_))
        .ifSome(hITGroupId)(_.hITGroupId(_))
        .ifSome(hITLayoutId)(_.hITLayoutId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(question)(_.question(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(hITStatus)(_.hITStatus(_))
        .ifSome(maxAssignments)(_.maxAssignments(_))
        .ifSome(reward)(_.reward(_))
        .ifSome(autoApprovalDelayInSeconds)(_.autoApprovalDelayInSeconds(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(assignmentDurationInSeconds)(_.assignmentDurationInSeconds(_))
        .ifSome(requesterAnnotation)(_.requesterAnnotation(_))
        .ifSome(qualificationRequirements)(_.qualificationRequirements(_))
        .ifSome(hITReviewStatus)(_.hITReviewStatus(_))
        .ifSome(numberOfAssignmentsPending)(_.numberOfAssignmentsPending(_))
        .ifSome(numberOfAssignmentsAvailable)(_.numberOfAssignmentsAvailable(_))
        .ifSome(numberOfAssignmentsCompleted)(_.numberOfAssignmentsCompleted(_))
        .build

    def hITLayoutParameter(
      name: Option[String] = None,
      value: Option[String] = None
    ): HITLayoutParameter =
      HITLayoutParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def listAssignmentsForHITRequest(
      hITId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      assignmentStatuses: Option[List[AssignmentStatus]] = None
    ): ListAssignmentsForHITRequest =
      ListAssignmentsForHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(assignmentStatuses)(_.assignmentStatuses(_))
        .build

    def listAssignmentsForHITResponse(
      nextToken: Option[String] = None,
      numResults: Option[Int] = None,
      assignments: Option[List[Assignment]] = None
    ): ListAssignmentsForHITResponse =
      ListAssignmentsForHITResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(assignments)(_.assignments(_))
        .build

    def listBonusPaymentsRequest(
      hITId: Option[String] = None,
      assignmentId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBonusPaymentsRequest =
      ListBonusPaymentsRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBonusPaymentsResponse(
      numResults: Option[Int] = None,
      nextToken: Option[String] = None,
      bonusPayments: Option[List[BonusPayment]] = None
    ): ListBonusPaymentsResponse =
      ListBonusPaymentsResponse
        .builder
        .ifSome(numResults)(_.numResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(bonusPayments)(_.bonusPayments(_))
        .build

    def listHITsForQualificationTypeRequest(
      qualificationTypeId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHITsForQualificationTypeRequest =
      ListHITsForQualificationTypeRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHITsForQualificationTypeResponse(
      nextToken: Option[String] = None,
      numResults: Option[Int] = None,
      hITs: Option[List[HIT]] = None
    ): ListHITsForQualificationTypeResponse =
      ListHITsForQualificationTypeResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(hITs)(_.hITs(_))
        .build

    def listHITsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHITsRequest =
      ListHITsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHITsResponse(
      nextToken: Option[String] = None,
      numResults: Option[Int] = None,
      hITs: Option[List[HIT]] = None
    ): ListHITsResponse =
      ListHITsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(hITs)(_.hITs(_))
        .build

    def listQualificationRequestsRequest(
      qualificationTypeId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListQualificationRequestsRequest =
      ListQualificationRequestsRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQualificationRequestsResponse(
      numResults: Option[Int] = None,
      nextToken: Option[String] = None,
      qualificationRequests: Option[List[QualificationRequest]] = None
    ): ListQualificationRequestsResponse =
      ListQualificationRequestsResponse
        .builder
        .ifSome(numResults)(_.numResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(qualificationRequests)(_.qualificationRequests(_))
        .build

    def listQualificationTypesRequest(
      query: Option[String] = None,
      mustBeRequestable: Option[Boolean] = None,
      mustBeOwnedByCaller: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListQualificationTypesRequest =
      ListQualificationTypesRequest
        .builder
        .ifSome(query)(_.query(_))
        .ifSome(mustBeRequestable)(_.mustBeRequestable(_))
        .ifSome(mustBeOwnedByCaller)(_.mustBeOwnedByCaller(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQualificationTypesResponse(
      numResults: Option[Int] = None,
      nextToken: Option[String] = None,
      qualificationTypes: Option[List[QualificationType]] = None
    ): ListQualificationTypesResponse =
      ListQualificationTypesResponse
        .builder
        .ifSome(numResults)(_.numResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(qualificationTypes)(_.qualificationTypes(_))
        .build

    def listReviewPolicyResultsForHITRequest(
      hITId: Option[String] = None,
      policyLevels: Option[List[ReviewPolicyLevel]] = None,
      retrieveActions: Option[Boolean] = None,
      retrieveResults: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListReviewPolicyResultsForHITRequest =
      ListReviewPolicyResultsForHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(policyLevels)(_.policyLevels(_))
        .ifSome(retrieveActions)(_.retrieveActions(_))
        .ifSome(retrieveResults)(_.retrieveResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listReviewPolicyResultsForHITResponse(
      hITId: Option[String] = None,
      assignmentReviewPolicy: Option[ReviewPolicy] = None,
      hITReviewPolicy: Option[ReviewPolicy] = None,
      assignmentReviewReport: Option[ReviewReport] = None,
      hITReviewReport: Option[ReviewReport] = None,
      nextToken: Option[String] = None
    ): ListReviewPolicyResultsForHITResponse =
      ListReviewPolicyResultsForHITResponse
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(assignmentReviewPolicy)(_.assignmentReviewPolicy(_))
        .ifSome(hITReviewPolicy)(_.hITReviewPolicy(_))
        .ifSome(assignmentReviewReport)(_.assignmentReviewReport(_))
        .ifSome(hITReviewReport)(_.hITReviewReport(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReviewableHITsRequest(
      hITTypeId: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListReviewableHITsRequest =
      ListReviewableHITsRequest
        .builder
        .ifSome(hITTypeId)(_.hITTypeId(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listReviewableHITsResponse(
      nextToken: Option[String] = None,
      numResults: Option[Int] = None,
      hITs: Option[List[HIT]] = None
    ): ListReviewableHITsResponse =
      ListReviewableHITsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(hITs)(_.hITs(_))
        .build

    def listWorkerBlocksRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkerBlocksRequest =
      ListWorkerBlocksRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkerBlocksResponse(
      nextToken: Option[String] = None,
      numResults: Option[Int] = None,
      workerBlocks: Option[List[WorkerBlock]] = None
    ): ListWorkerBlocksResponse =
      ListWorkerBlocksResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(workerBlocks)(_.workerBlocks(_))
        .build

    def listWorkersWithQualificationTypeRequest(
      qualificationTypeId: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkersWithQualificationTypeRequest =
      ListWorkersWithQualificationTypeRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkersWithQualificationTypeResponse(
      nextToken: Option[String] = None,
      numResults: Option[Int] = None,
      qualifications: Option[List[Qualification]] = None
    ): ListWorkersWithQualificationTypeResponse =
      ListWorkersWithQualificationTypeResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(numResults)(_.numResults(_))
        .ifSome(qualifications)(_.qualifications(_))
        .build

    def locale(
      country: Option[String] = None,
      subdivision: Option[String] = None
    ): Locale =
      Locale
        .builder
        .ifSome(country)(_.country(_))
        .ifSome(subdivision)(_.subdivision(_))
        .build

    def notificationSpecification(
      destination: Option[String] = None,
      transport: Option[String] = None,
      version: Option[String] = None,
      eventTypes: Option[List[EventType]] = None
    ): NotificationSpecification =
      NotificationSpecification
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(transport)(_.transport(_))
        .ifSome(version)(_.version(_))
        .ifSome(eventTypes)(_.eventTypes(_))
        .build

    def notifyWorkersFailureStatus(
      notifyWorkersFailureCode: Option[String] = None,
      notifyWorkersFailureMessage: Option[String] = None,
      workerId: Option[String] = None
    ): NotifyWorkersFailureStatus =
      NotifyWorkersFailureStatus
        .builder
        .ifSome(notifyWorkersFailureCode)(_.notifyWorkersFailureCode(_))
        .ifSome(notifyWorkersFailureMessage)(_.notifyWorkersFailureMessage(_))
        .ifSome(workerId)(_.workerId(_))
        .build

    def notifyWorkersRequest(
      subject: Option[String] = None,
      messageText: Option[String] = None,
      workerIds: Option[List[CustomerId]] = None
    ): NotifyWorkersRequest =
      NotifyWorkersRequest
        .builder
        .ifSome(subject)(_.subject(_))
        .ifSome(messageText)(_.messageText(_))
        .ifSome(workerIds)(_.workerIds(_))
        .build

    def notifyWorkersResponse(
      notifyWorkersFailureStatuses: Option[List[NotifyWorkersFailureStatus]] = None
    ): NotifyWorkersResponse =
      NotifyWorkersResponse
        .builder
        .ifSome(notifyWorkersFailureStatuses)(_.notifyWorkersFailureStatuses(_))
        .build

    def parameterMapEntry(
      key: Option[String] = None,
      values: Option[List[String]] = None
    ): ParameterMapEntry =
      ParameterMapEntry
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def policyParameter(
      key: Option[String] = None,
      values: Option[List[String]] = None,
      mapEntries: Option[List[ParameterMapEntry]] = None
    ): PolicyParameter =
      PolicyParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(mapEntries)(_.mapEntries(_))
        .build

    def qualification(
      qualificationTypeId: Option[String] = None,
      workerId: Option[String] = None,
      grantTime: Option[Timestamp] = None,
      integerValue: Option[Int] = None,
      localeValue: Option[Locale] = None,
      status: Option[String] = None
    ): Qualification =
      Qualification
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(workerId)(_.workerId(_))
        .ifSome(grantTime)(_.grantTime(_))
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(localeValue)(_.localeValue(_))
        .ifSome(status)(_.status(_))
        .build

    def qualificationRequest(
      qualificationRequestId: Option[String] = None,
      qualificationTypeId: Option[String] = None,
      workerId: Option[String] = None,
      test: Option[String] = None,
      answer: Option[String] = None,
      submitTime: Option[Timestamp] = None
    ): QualificationRequest =
      QualificationRequest
        .builder
        .ifSome(qualificationRequestId)(_.qualificationRequestId(_))
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(workerId)(_.workerId(_))
        .ifSome(test)(_.test(_))
        .ifSome(answer)(_.answer(_))
        .ifSome(submitTime)(_.submitTime(_))
        .build

    def qualificationRequirement(
      qualificationTypeId: Option[String] = None,
      comparator: Option[String] = None,
      integerValues: Option[List[Integer]] = None,
      localeValues: Option[List[Locale]] = None,
      requiredToPreview: Option[Boolean] = None,
      actionsGuarded: Option[String] = None
    ): QualificationRequirement =
      QualificationRequirement
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(comparator)(_.comparator(_))
        .ifSome(integerValues)(_.integerValues(_))
        .ifSome(localeValues)(_.localeValues(_))
        .ifSome(requiredToPreview)(_.requiredToPreview(_))
        .ifSome(actionsGuarded)(_.actionsGuarded(_))
        .build

    def qualificationType(
      qualificationTypeId: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      keywords: Option[String] = None,
      qualificationTypeStatus: Option[String] = None,
      test: Option[String] = None,
      testDurationInSeconds: Option[Long] = None,
      answerKey: Option[String] = None,
      retryDelayInSeconds: Option[Long] = None,
      isRequestable: Option[Boolean] = None,
      autoGranted: Option[Boolean] = None,
      autoGrantedValue: Option[Int] = None
    ): QualificationType =
      QualificationType
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(qualificationTypeStatus)(_.qualificationTypeStatus(_))
        .ifSome(test)(_.test(_))
        .ifSome(testDurationInSeconds)(_.testDurationInSeconds(_))
        .ifSome(answerKey)(_.answerKey(_))
        .ifSome(retryDelayInSeconds)(_.retryDelayInSeconds(_))
        .ifSome(isRequestable)(_.isRequestable(_))
        .ifSome(autoGranted)(_.autoGranted(_))
        .ifSome(autoGrantedValue)(_.autoGrantedValue(_))
        .build

    def rejectAssignmentRequest(
      assignmentId: Option[String] = None,
      requesterFeedback: Option[String] = None
    ): RejectAssignmentRequest =
      RejectAssignmentRequest
        .builder
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(requesterFeedback)(_.requesterFeedback(_))
        .build

    def rejectAssignmentResponse(

    ): RejectAssignmentResponse =
      RejectAssignmentResponse
        .builder

        .build

    def rejectQualificationRequestRequest(
      qualificationRequestId: Option[String] = None,
      reason: Option[String] = None
    ): RejectQualificationRequestRequest =
      RejectQualificationRequestRequest
        .builder
        .ifSome(qualificationRequestId)(_.qualificationRequestId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def rejectQualificationRequestResponse(

    ): RejectQualificationRequestResponse =
      RejectQualificationRequestResponse
        .builder

        .build

    def requestError(
      message: Option[String] = None,
      turkErrorCode: Option[String] = None
    ): RequestError =
      RequestError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(turkErrorCode)(_.turkErrorCode(_))
        .build

    def reviewActionDetail(
      actionId: Option[String] = None,
      actionName: Option[String] = None,
      targetId: Option[String] = None,
      targetType: Option[String] = None,
      status: Option[String] = None,
      completeTime: Option[Timestamp] = None,
      result: Option[String] = None,
      errorCode: Option[String] = None
    ): ReviewActionDetail =
      ReviewActionDetail
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(status)(_.status(_))
        .ifSome(completeTime)(_.completeTime(_))
        .ifSome(result)(_.result(_))
        .ifSome(errorCode)(_.errorCode(_))
        .build

    def reviewPolicy(
      policyName: Option[String] = None,
      parameters: Option[List[PolicyParameter]] = None
    ): ReviewPolicy =
      ReviewPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def reviewReport(
      reviewResults: Option[List[ReviewResultDetail]] = None,
      reviewActions: Option[List[ReviewActionDetail]] = None
    ): ReviewReport =
      ReviewReport
        .builder
        .ifSome(reviewResults)(_.reviewResults(_))
        .ifSome(reviewActions)(_.reviewActions(_))
        .build

    def reviewResultDetail(
      actionId: Option[String] = None,
      subjectId: Option[String] = None,
      subjectType: Option[String] = None,
      questionId: Option[String] = None,
      key: Option[String] = None,
      value: Option[String] = None
    ): ReviewResultDetail =
      ReviewResultDetail
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(subjectId)(_.subjectId(_))
        .ifSome(subjectType)(_.subjectType(_))
        .ifSome(questionId)(_.questionId(_))
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def sendBonusRequest(
      workerId: Option[String] = None,
      bonusAmount: Option[String] = None,
      assignmentId: Option[String] = None,
      reason: Option[String] = None,
      uniqueRequestToken: Option[String] = None
    ): SendBonusRequest =
      SendBonusRequest
        .builder
        .ifSome(workerId)(_.workerId(_))
        .ifSome(bonusAmount)(_.bonusAmount(_))
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(uniqueRequestToken)(_.uniqueRequestToken(_))
        .build

    def sendBonusResponse(

    ): SendBonusResponse =
      SendBonusResponse
        .builder

        .build

    def sendTestEventNotificationRequest(
      notification: Option[NotificationSpecification] = None,
      testEventType: Option[String] = None
    ): SendTestEventNotificationRequest =
      SendTestEventNotificationRequest
        .builder
        .ifSome(notification)(_.notification(_))
        .ifSome(testEventType)(_.testEventType(_))
        .build

    def sendTestEventNotificationResponse(

    ): SendTestEventNotificationResponse =
      SendTestEventNotificationResponse
        .builder

        .build

    def serviceFault(
      message: Option[String] = None,
      turkErrorCode: Option[String] = None
    ): ServiceFault =
      ServiceFault
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(turkErrorCode)(_.turkErrorCode(_))
        .build

    def updateExpirationForHITRequest(
      hITId: Option[String] = None,
      expireAt: Option[Timestamp] = None
    ): UpdateExpirationForHITRequest =
      UpdateExpirationForHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(expireAt)(_.expireAt(_))
        .build

    def updateExpirationForHITResponse(

    ): UpdateExpirationForHITResponse =
      UpdateExpirationForHITResponse
        .builder

        .build

    def updateHITReviewStatusRequest(
      hITId: Option[String] = None,
      revert: Option[Boolean] = None
    ): UpdateHITReviewStatusRequest =
      UpdateHITReviewStatusRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(revert)(_.revert(_))
        .build

    def updateHITReviewStatusResponse(

    ): UpdateHITReviewStatusResponse =
      UpdateHITReviewStatusResponse
        .builder

        .build

    def updateHITTypeOfHITRequest(
      hITId: Option[String] = None,
      hITTypeId: Option[String] = None
    ): UpdateHITTypeOfHITRequest =
      UpdateHITTypeOfHITRequest
        .builder
        .ifSome(hITId)(_.hITId(_))
        .ifSome(hITTypeId)(_.hITTypeId(_))
        .build

    def updateHITTypeOfHITResponse(

    ): UpdateHITTypeOfHITResponse =
      UpdateHITTypeOfHITResponse
        .builder

        .build

    def updateNotificationSettingsRequest(
      hITTypeId: Option[String] = None,
      notification: Option[NotificationSpecification] = None,
      active: Option[Boolean] = None
    ): UpdateNotificationSettingsRequest =
      UpdateNotificationSettingsRequest
        .builder
        .ifSome(hITTypeId)(_.hITTypeId(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(active)(_.active(_))
        .build

    def updateNotificationSettingsResponse(

    ): UpdateNotificationSettingsResponse =
      UpdateNotificationSettingsResponse
        .builder

        .build

    def updateQualificationTypeRequest(
      qualificationTypeId: Option[String] = None,
      description: Option[String] = None,
      qualificationTypeStatus: Option[String] = None,
      test: Option[String] = None,
      answerKey: Option[String] = None,
      testDurationInSeconds: Option[Long] = None,
      retryDelayInSeconds: Option[Long] = None,
      autoGranted: Option[Boolean] = None,
      autoGrantedValue: Option[Int] = None
    ): UpdateQualificationTypeRequest =
      UpdateQualificationTypeRequest
        .builder
        .ifSome(qualificationTypeId)(_.qualificationTypeId(_))
        .ifSome(description)(_.description(_))
        .ifSome(qualificationTypeStatus)(_.qualificationTypeStatus(_))
        .ifSome(test)(_.test(_))
        .ifSome(answerKey)(_.answerKey(_))
        .ifSome(testDurationInSeconds)(_.testDurationInSeconds(_))
        .ifSome(retryDelayInSeconds)(_.retryDelayInSeconds(_))
        .ifSome(autoGranted)(_.autoGranted(_))
        .ifSome(autoGrantedValue)(_.autoGrantedValue(_))
        .build

    def updateQualificationTypeResponse(
      qualificationType: Option[QualificationType] = None
    ): UpdateQualificationTypeResponse =
      UpdateQualificationTypeResponse
        .builder
        .ifSome(qualificationType)(_.qualificationType(_))
        .build

    def workerBlock(
      workerId: Option[String] = None,
      reason: Option[String] = None
    ): WorkerBlock =
      WorkerBlock
        .builder
        .ifSome(workerId)(_.workerId(_))
        .ifSome(reason)(_.reason(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
