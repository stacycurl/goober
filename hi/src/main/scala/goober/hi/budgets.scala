package goober.hi

import goober.free.budgets.BudgetsIO
import software.amazon.awssdk.services.budgets.model._


object budgets {
  import goober.free.{budgets ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def action(
      actionId: Option[String] = None,
      budgetName: Option[String] = None,
      notificationType: Option[String] = None,
      actionType: Option[String] = None,
      actionThreshold: Option[ActionThreshold] = None,
      definition: Option[Definition] = None,
      executionRoleArn: Option[String] = None,
      approvalModel: Option[String] = None,
      status: Option[String] = None,
      subscribers: Option[List[Subscriber]] = None
    ): Action =
      Action
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notificationType)(_.notificationType(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(actionThreshold)(_.actionThreshold(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(approvalModel)(_.approvalModel(_))
        .ifSome(status)(_.status(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def actionHistory(
      timestamp: Option[GenericTimestamp] = None,
      status: Option[String] = None,
      eventType: Option[String] = None,
      actionHistoryDetails: Option[ActionHistoryDetails] = None
    ): ActionHistory =
      ActionHistory
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(actionHistoryDetails)(_.actionHistoryDetails(_))
        .build

    def actionHistoryDetails(
      message: Option[String] = None,
      action: Option[Action] = None
    ): ActionHistoryDetails =
      ActionHistoryDetails
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(action)(_.action(_))
        .build

    def actionThreshold(
      actionThresholdValue: Option[NotificationThreshold] = None,
      actionThresholdType: Option[String] = None
    ): ActionThreshold =
      ActionThreshold
        .builder
        .ifSome(actionThresholdValue)(_.actionThresholdValue(_))
        .ifSome(actionThresholdType)(_.actionThresholdType(_))
        .build

    def budget(
      budgetName: Option[String] = None,
      budgetLimit: Option[Spend] = None,
      plannedBudgetLimits: Option[PlannedBudgetLimits] = None,
      costFilters: Option[CostFilters] = None,
      costTypes: Option[CostTypes] = None,
      timeUnit: Option[String] = None,
      timePeriod: Option[TimePeriod] = None,
      calculatedSpend: Option[CalculatedSpend] = None,
      budgetType: Option[String] = None,
      lastUpdatedTime: Option[GenericTimestamp] = None
    ): Budget =
      Budget
        .builder
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(budgetLimit)(_.budgetLimit(_))
        .ifSome(plannedBudgetLimits)(_.plannedBudgetLimits(_))
        .ifSome(costFilters)(_.costFilters(_))
        .ifSome(costTypes)(_.costTypes(_))
        .ifSome(timeUnit)(_.timeUnit(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(calculatedSpend)(_.calculatedSpend(_))
        .ifSome(budgetType)(_.budgetType(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def budgetPerformanceHistory(
      budgetName: Option[String] = None,
      budgetType: Option[String] = None,
      costFilters: Option[CostFilters] = None,
      costTypes: Option[CostTypes] = None,
      timeUnit: Option[String] = None,
      budgetedAndActualAmountsList: Option[List[BudgetedAndActualAmounts]] = None
    ): BudgetPerformanceHistory =
      BudgetPerformanceHistory
        .builder
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(budgetType)(_.budgetType(_))
        .ifSome(costFilters)(_.costFilters(_))
        .ifSome(costTypes)(_.costTypes(_))
        .ifSome(timeUnit)(_.timeUnit(_))
        .ifSome(budgetedAndActualAmountsList)(_.budgetedAndActualAmountsList(_))
        .build

    def budgetedAndActualAmounts(
      budgetedAmount: Option[Spend] = None,
      actualAmount: Option[Spend] = None,
      timePeriod: Option[TimePeriod] = None
    ): BudgetedAndActualAmounts =
      BudgetedAndActualAmounts
        .builder
        .ifSome(budgetedAmount)(_.budgetedAmount(_))
        .ifSome(actualAmount)(_.actualAmount(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .build

    def calculatedSpend(
      actualSpend: Option[Spend] = None,
      forecastedSpend: Option[Spend] = None
    ): CalculatedSpend =
      CalculatedSpend
        .builder
        .ifSome(actualSpend)(_.actualSpend(_))
        .ifSome(forecastedSpend)(_.forecastedSpend(_))
        .build

    def costTypes(
      includeTax: Option[Boolean] = None,
      includeSubscription: Option[Boolean] = None,
      useBlended: Option[Boolean] = None,
      includeRefund: Option[Boolean] = None,
      includeCredit: Option[Boolean] = None,
      includeUpfront: Option[Boolean] = None,
      includeRecurring: Option[Boolean] = None,
      includeOtherSubscription: Option[Boolean] = None,
      includeSupport: Option[Boolean] = None,
      includeDiscount: Option[Boolean] = None,
      useAmortized: Option[Boolean] = None
    ): CostTypes =
      CostTypes
        .builder
        .ifSome(includeTax)(_.includeTax(_))
        .ifSome(includeSubscription)(_.includeSubscription(_))
        .ifSome(useBlended)(_.useBlended(_))
        .ifSome(includeRefund)(_.includeRefund(_))
        .ifSome(includeCredit)(_.includeCredit(_))
        .ifSome(includeUpfront)(_.includeUpfront(_))
        .ifSome(includeRecurring)(_.includeRecurring(_))
        .ifSome(includeOtherSubscription)(_.includeOtherSubscription(_))
        .ifSome(includeSupport)(_.includeSupport(_))
        .ifSome(includeDiscount)(_.includeDiscount(_))
        .ifSome(useAmortized)(_.useAmortized(_))
        .build

    def createBudgetActionRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notificationType: Option[String] = None,
      actionType: Option[String] = None,
      actionThreshold: Option[ActionThreshold] = None,
      definition: Option[Definition] = None,
      executionRoleArn: Option[String] = None,
      approvalModel: Option[String] = None,
      subscribers: Option[List[Subscriber]] = None
    ): CreateBudgetActionRequest =
      CreateBudgetActionRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notificationType)(_.notificationType(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(actionThreshold)(_.actionThreshold(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(approvalModel)(_.approvalModel(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def createBudgetActionResponse(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None
    ): CreateBudgetActionResponse =
      CreateBudgetActionResponse
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def createBudgetRequest(
      accountId: Option[String] = None,
      budget: Option[Budget] = None,
      notificationsWithSubscribers: Option[List[NotificationWithSubscribers]] = None
    ): CreateBudgetRequest =
      CreateBudgetRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budget)(_.budget(_))
        .ifSome(notificationsWithSubscribers)(_.notificationsWithSubscribers(_))
        .build

    def createBudgetResponse(

    ): CreateBudgetResponse =
      CreateBudgetResponse
        .builder

        .build

    def createNotificationRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notification: Option[Notification] = None,
      subscribers: Option[List[Subscriber]] = None
    ): CreateNotificationRequest =
      CreateNotificationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def createNotificationResponse(

    ): CreateNotificationResponse =
      CreateNotificationResponse
        .builder

        .build

    def createSubscriberRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notification: Option[Notification] = None,
      subscriber: Option[Subscriber] = None
    ): CreateSubscriberRequest =
      CreateSubscriberRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(subscriber)(_.subscriber(_))
        .build

    def createSubscriberResponse(

    ): CreateSubscriberResponse =
      CreateSubscriberResponse
        .builder

        .build

    def creationLimitExceededException(
      message: Option[String] = None
    ): CreationLimitExceededException =
      CreationLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def definition(
      iamActionDefinition: Option[IamActionDefinition] = None,
      scpActionDefinition: Option[ScpActionDefinition] = None,
      ssmActionDefinition: Option[SsmActionDefinition] = None
    ): Definition =
      Definition
        .builder
        .ifSome(iamActionDefinition)(_.iamActionDefinition(_))
        .ifSome(scpActionDefinition)(_.scpActionDefinition(_))
        .ifSome(ssmActionDefinition)(_.ssmActionDefinition(_))
        .build

    def deleteBudgetActionRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None
    ): DeleteBudgetActionRequest =
      DeleteBudgetActionRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def deleteBudgetActionResponse(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      action: Option[Action] = None
    ): DeleteBudgetActionResponse =
      DeleteBudgetActionResponse
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(action)(_.action(_))
        .build

    def deleteBudgetRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None
    ): DeleteBudgetRequest =
      DeleteBudgetRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .build

    def deleteBudgetResponse(

    ): DeleteBudgetResponse =
      DeleteBudgetResponse
        .builder

        .build

    def deleteNotificationRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notification: Option[Notification] = None
    ): DeleteNotificationRequest =
      DeleteNotificationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notification)(_.notification(_))
        .build

    def deleteNotificationResponse(

    ): DeleteNotificationResponse =
      DeleteNotificationResponse
        .builder

        .build

    def deleteSubscriberRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notification: Option[Notification] = None,
      subscriber: Option[Subscriber] = None
    ): DeleteSubscriberRequest =
      DeleteSubscriberRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(subscriber)(_.subscriber(_))
        .build

    def deleteSubscriberResponse(

    ): DeleteSubscriberResponse =
      DeleteSubscriberResponse
        .builder

        .build

    def describeBudgetActionHistoriesRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None,
      timePeriod: Option[TimePeriod] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetActionHistoriesRequest =
      DescribeBudgetActionHistoriesRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetActionHistoriesResponse(
      actionHistories: Option[List[ActionHistory]] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetActionHistoriesResponse =
      DescribeBudgetActionHistoriesResponse
        .builder
        .ifSome(actionHistories)(_.actionHistories(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetActionRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None
    ): DescribeBudgetActionRequest =
      DescribeBudgetActionRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def describeBudgetActionResponse(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      action: Option[Action] = None
    ): DescribeBudgetActionResponse =
      DescribeBudgetActionResponse
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(action)(_.action(_))
        .build

    def describeBudgetActionsForAccountRequest(
      accountId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetActionsForAccountRequest =
      DescribeBudgetActionsForAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetActionsForAccountResponse(
      actions: Option[List[Action]] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetActionsForAccountResponse =
      DescribeBudgetActionsForAccountResponse
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetActionsForBudgetRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetActionsForBudgetRequest =
      DescribeBudgetActionsForBudgetRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetActionsForBudgetResponse(
      actions: Option[List[Action]] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetActionsForBudgetResponse =
      DescribeBudgetActionsForBudgetResponse
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetPerformanceHistoryRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      timePeriod: Option[TimePeriod] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetPerformanceHistoryRequest =
      DescribeBudgetPerformanceHistoryRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetPerformanceHistoryResponse(
      budgetPerformanceHistory: Option[BudgetPerformanceHistory] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetPerformanceHistoryResponse =
      DescribeBudgetPerformanceHistoryResponse
        .builder
        .ifSome(budgetPerformanceHistory)(_.budgetPerformanceHistory(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None
    ): DescribeBudgetRequest =
      DescribeBudgetRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .build

    def describeBudgetResponse(
      budget: Option[Budget] = None
    ): DescribeBudgetResponse =
      DescribeBudgetResponse
        .builder
        .ifSome(budget)(_.budget(_))
        .build

    def describeBudgetsRequest(
      accountId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetsRequest =
      DescribeBudgetsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBudgetsResponse(
      budgets: Option[List[Budget]] = None,
      nextToken: Option[String] = None
    ): DescribeBudgetsResponse =
      DescribeBudgetsResponse
        .builder
        .ifSome(budgets)(_.budgets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNotificationsForBudgetRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeNotificationsForBudgetRequest =
      DescribeNotificationsForBudgetRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNotificationsForBudgetResponse(
      notifications: Option[List[Notification]] = None,
      nextToken: Option[String] = None
    ): DescribeNotificationsForBudgetResponse =
      DescribeNotificationsForBudgetResponse
        .builder
        .ifSome(notifications)(_.notifications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSubscribersForNotificationRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notification: Option[Notification] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeSubscribersForNotificationRequest =
      DescribeSubscribersForNotificationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSubscribersForNotificationResponse(
      subscribers: Option[List[Subscriber]] = None,
      nextToken: Option[String] = None
    ): DescribeSubscribersForNotificationResponse =
      DescribeSubscribersForNotificationResponse
        .builder
        .ifSome(subscribers)(_.subscribers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def duplicateRecordException(
      message: Option[String] = None
    ): DuplicateRecordException =
      DuplicateRecordException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def executeBudgetActionRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None,
      executionType: Option[String] = None
    ): ExecuteBudgetActionRequest =
      ExecuteBudgetActionRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .ifSome(executionType)(_.executionType(_))
        .build

    def executeBudgetActionResponse(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None,
      executionType: Option[String] = None
    ): ExecuteBudgetActionResponse =
      ExecuteBudgetActionResponse
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .ifSome(executionType)(_.executionType(_))
        .build

    def expiredNextTokenException(
      message: Option[String] = None
    ): ExpiredNextTokenException =
      ExpiredNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def iamActionDefinition(
      policyArn: Option[String] = None,
      roles: Option[List[Role]] = None,
      groups: Option[List[Group]] = None,
      users: Option[List[User]] = None
    ): IamActionDefinition =
      IamActionDefinition
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(users)(_.users(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
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

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notification(
      notificationType: Option[String] = None,
      comparisonOperator: Option[String] = None,
      threshold: Option[NotificationThreshold] = None,
      thresholdType: Option[String] = None,
      notificationState: Option[String] = None
    ): Notification =
      Notification
        .builder
        .ifSome(notificationType)(_.notificationType(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(thresholdType)(_.thresholdType(_))
        .ifSome(notificationState)(_.notificationState(_))
        .build

    def notificationWithSubscribers(
      notification: Option[Notification] = None,
      subscribers: Option[List[Subscriber]] = None
    ): NotificationWithSubscribers =
      NotificationWithSubscribers
        .builder
        .ifSome(notification)(_.notification(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def resourceLockedException(
      message: Option[String] = None
    ): ResourceLockedException =
      ResourceLockedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def scpActionDefinition(
      policyId: Option[String] = None,
      targetIds: Option[List[TargetId]] = None
    ): ScpActionDefinition =
      ScpActionDefinition
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(targetIds)(_.targetIds(_))
        .build

    def spend(
      amount: Option[String] = None,
      unit: Option[String] = None
    ): Spend =
      Spend
        .builder
        .ifSome(amount)(_.amount(_))
        .ifSome(unit)(_.unit(_))
        .build

    def ssmActionDefinition(
      actionSubType: Option[String] = None,
      region: Option[String] = None,
      instanceIds: Option[List[InstanceId]] = None
    ): SsmActionDefinition =
      SsmActionDefinition
        .builder
        .ifSome(actionSubType)(_.actionSubType(_))
        .ifSome(region)(_.region(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def subscriber(
      subscriptionType: Option[String] = None,
      address: Option[String] = None
    ): Subscriber =
      Subscriber
        .builder
        .ifSome(subscriptionType)(_.subscriptionType(_))
        .ifSome(address)(_.address(_))
        .build

    def timePeriod(
      start: Option[GenericTimestamp] = None,
      end: Option[GenericTimestamp] = None
    ): TimePeriod =
      TimePeriod
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .build

    def updateBudgetActionRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      actionId: Option[String] = None,
      notificationType: Option[String] = None,
      actionThreshold: Option[ActionThreshold] = None,
      definition: Option[Definition] = None,
      executionRoleArn: Option[String] = None,
      approvalModel: Option[String] = None,
      subscribers: Option[List[Subscriber]] = None
    ): UpdateBudgetActionRequest =
      UpdateBudgetActionRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(actionId)(_.actionId(_))
        .ifSome(notificationType)(_.notificationType(_))
        .ifSome(actionThreshold)(_.actionThreshold(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(approvalModel)(_.approvalModel(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def updateBudgetActionResponse(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      oldAction: Option[Action] = None,
      newAction: Option[Action] = None
    ): UpdateBudgetActionResponse =
      UpdateBudgetActionResponse
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(oldAction)(_.oldAction(_))
        .ifSome(newAction)(_.newAction(_))
        .build

    def updateBudgetRequest(
      accountId: Option[String] = None,
      newBudget: Option[Budget] = None
    ): UpdateBudgetRequest =
      UpdateBudgetRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(newBudget)(_.newBudget(_))
        .build

    def updateBudgetResponse(

    ): UpdateBudgetResponse =
      UpdateBudgetResponse
        .builder

        .build

    def updateNotificationRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      oldNotification: Option[Notification] = None,
      newNotification: Option[Notification] = None
    ): UpdateNotificationRequest =
      UpdateNotificationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(oldNotification)(_.oldNotification(_))
        .ifSome(newNotification)(_.newNotification(_))
        .build

    def updateNotificationResponse(

    ): UpdateNotificationResponse =
      UpdateNotificationResponse
        .builder

        .build

    def updateSubscriberRequest(
      accountId: Option[String] = None,
      budgetName: Option[String] = None,
      notification: Option[Notification] = None,
      oldSubscriber: Option[Subscriber] = None,
      newSubscriber: Option[Subscriber] = None
    ): UpdateSubscriberRequest =
      UpdateSubscriberRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(oldSubscriber)(_.oldSubscriber(_))
        .ifSome(newSubscriber)(_.newSubscriber(_))
        .build

    def updateSubscriberResponse(

    ): UpdateSubscriberResponse =
      UpdateSubscriberResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
