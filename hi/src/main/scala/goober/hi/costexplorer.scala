package goober.hi

import goober.free.costexplorer.CostExplorerIO
import software.amazon.awssdk.services.costexplorer.model._


object costexplorer {
  import goober.free.{costexplorer ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def anomaly(
      anomalyId: Option[String] = None,
      anomalyStartDate: Option[String] = None,
      anomalyEndDate: Option[String] = None,
      dimensionValue: Option[String] = None,
      rootCauses: Option[List[RootCause]] = None,
      anomalyScore: Option[AnomalyScore] = None,
      impact: Option[Impact] = None,
      monitorArn: Option[String] = None,
      feedback: Option[String] = None
    ): Anomaly =
      Anomaly
        .builder
        .ifSome(anomalyId)(_.anomalyId(_))
        .ifSome(anomalyStartDate)(_.anomalyStartDate(_))
        .ifSome(anomalyEndDate)(_.anomalyEndDate(_))
        .ifSome(dimensionValue)(_.dimensionValue(_))
        .ifSome(rootCauses)(_.rootCauses(_))
        .ifSome(anomalyScore)(_.anomalyScore(_))
        .ifSome(impact)(_.impact(_))
        .ifSome(monitorArn)(_.monitorArn(_))
        .ifSome(feedback)(_.feedback(_))
        .build

    def anomalyDateInterval(
      startDate: Option[String] = None,
      endDate: Option[String] = None
    ): AnomalyDateInterval =
      AnomalyDateInterval
        .builder
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .build

    def anomalyMonitor(
      monitorArn: Option[String] = None,
      monitorName: Option[String] = None,
      creationDate: Option[String] = None,
      lastUpdatedDate: Option[String] = None,
      lastEvaluatedDate: Option[String] = None,
      monitorType: Option[String] = None,
      monitorDimension: Option[String] = None,
      monitorSpecification: Option[Expression] = None,
      dimensionalValueCount: Option[Int] = None
    ): AnomalyMonitor =
      AnomalyMonitor
        .builder
        .ifSome(monitorArn)(_.monitorArn(_))
        .ifSome(monitorName)(_.monitorName(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(lastEvaluatedDate)(_.lastEvaluatedDate(_))
        .ifSome(monitorType)(_.monitorType(_))
        .ifSome(monitorDimension)(_.monitorDimension(_))
        .ifSome(monitorSpecification)(_.monitorSpecification(_))
        .ifSome(dimensionalValueCount)(_.dimensionalValueCount(_))
        .build

    def anomalyScore(
      maxScore: Option[GenericDouble] = None,
      currentScore: Option[GenericDouble] = None
    ): AnomalyScore =
      AnomalyScore
        .builder
        .ifSome(maxScore)(_.maxScore(_))
        .ifSome(currentScore)(_.currentScore(_))
        .build

    def anomalySubscription(
      subscriptionArn: Option[String] = None,
      accountId: Option[String] = None,
      monitorArnList: Option[List[Arn]] = None,
      subscribers: Option[List[Subscriber]] = None,
      threshold: Option[NullableNonNegativeDouble] = None,
      frequency: Option[String] = None,
      subscriptionName: Option[String] = None
    ): AnomalySubscription =
      AnomalySubscription
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(monitorArnList)(_.monitorArnList(_))
        .ifSome(subscribers)(_.subscribers(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .build

    def billExpirationException(
      message: Option[String] = None
    ): BillExpirationException =
      BillExpirationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def costCategory(
      costCategoryArn: Option[String] = None,
      effectiveStart: Option[String] = None,
      effectiveEnd: Option[String] = None,
      name: Option[String] = None,
      ruleVersion: Option[String] = None,
      rules: Option[List[CostCategoryRule]] = None,
      processingStatus: Option[List[CostCategoryProcessingStatus]] = None,
      defaultValue: Option[String] = None
    ): CostCategory =
      CostCategory
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(effectiveStart)(_.effectiveStart(_))
        .ifSome(effectiveEnd)(_.effectiveEnd(_))
        .ifSome(name)(_.name(_))
        .ifSome(ruleVersion)(_.ruleVersion(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(processingStatus)(_.processingStatus(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def costCategoryInheritedValueDimension(
      dimensionName: Option[String] = None,
      dimensionKey: Option[String] = None
    ): CostCategoryInheritedValueDimension =
      CostCategoryInheritedValueDimension
        .builder
        .ifSome(dimensionName)(_.dimensionName(_))
        .ifSome(dimensionKey)(_.dimensionKey(_))
        .build

    def costCategoryProcessingStatus(
      component: Option[String] = None,
      status: Option[String] = None
    ): CostCategoryProcessingStatus =
      CostCategoryProcessingStatus
        .builder
        .ifSome(component)(_.component(_))
        .ifSome(status)(_.status(_))
        .build

    def costCategoryReference(
      costCategoryArn: Option[String] = None,
      name: Option[String] = None,
      effectiveStart: Option[String] = None,
      effectiveEnd: Option[String] = None,
      numberOfRules: Option[Int] = None,
      processingStatus: Option[List[CostCategoryProcessingStatus]] = None,
      values: Option[List[CostCategoryValue]] = None,
      defaultValue: Option[String] = None
    ): CostCategoryReference =
      CostCategoryReference
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(effectiveStart)(_.effectiveStart(_))
        .ifSome(effectiveEnd)(_.effectiveEnd(_))
        .ifSome(numberOfRules)(_.numberOfRules(_))
        .ifSome(processingStatus)(_.processingStatus(_))
        .ifSome(values)(_.values(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def costCategoryRule(
      value: Option[String] = None,
      rule: Option[Expression] = None,
      inheritedValue: Option[CostCategoryInheritedValueDimension] = None,
      `type`: Option[String] = None
    ): CostCategoryRule =
      CostCategoryRule
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(rule)(_.rule(_))
        .ifSome(inheritedValue)(_.inheritedValue(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def costCategoryValues(
      key: Option[String] = None,
      values: Option[List[Value]] = None,
      matchOptions: Option[List[MatchOption]] = None
    ): CostCategoryValues =
      CostCategoryValues
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(matchOptions)(_.matchOptions(_))
        .build

    def coverage(
      coverageHours: Option[CoverageHours] = None,
      coverageNormalizedUnits: Option[CoverageNormalizedUnits] = None,
      coverageCost: Option[CoverageCost] = None
    ): Coverage =
      Coverage
        .builder
        .ifSome(coverageHours)(_.coverageHours(_))
        .ifSome(coverageNormalizedUnits)(_.coverageNormalizedUnits(_))
        .ifSome(coverageCost)(_.coverageCost(_))
        .build

    def coverageByTime(
      timePeriod: Option[DateInterval] = None,
      groups: Option[List[ReservationCoverageGroup]] = None,
      total: Option[Coverage] = None
    ): CoverageByTime =
      CoverageByTime
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(total)(_.total(_))
        .build

    def coverageCost(
      onDemandCost: Option[String] = None
    ): CoverageCost =
      CoverageCost
        .builder
        .ifSome(onDemandCost)(_.onDemandCost(_))
        .build

    def coverageHours(
      onDemandHours: Option[String] = None,
      reservedHours: Option[String] = None,
      totalRunningHours: Option[String] = None,
      coverageHoursPercentage: Option[String] = None
    ): CoverageHours =
      CoverageHours
        .builder
        .ifSome(onDemandHours)(_.onDemandHours(_))
        .ifSome(reservedHours)(_.reservedHours(_))
        .ifSome(totalRunningHours)(_.totalRunningHours(_))
        .ifSome(coverageHoursPercentage)(_.coverageHoursPercentage(_))
        .build

    def coverageNormalizedUnits(
      onDemandNormalizedUnits: Option[String] = None,
      reservedNormalizedUnits: Option[String] = None,
      totalRunningNormalizedUnits: Option[String] = None,
      coverageNormalizedUnitsPercentage: Option[String] = None
    ): CoverageNormalizedUnits =
      CoverageNormalizedUnits
        .builder
        .ifSome(onDemandNormalizedUnits)(_.onDemandNormalizedUnits(_))
        .ifSome(reservedNormalizedUnits)(_.reservedNormalizedUnits(_))
        .ifSome(totalRunningNormalizedUnits)(_.totalRunningNormalizedUnits(_))
        .ifSome(coverageNormalizedUnitsPercentage)(_.coverageNormalizedUnitsPercentage(_))
        .build

    def createAnomalyMonitorRequest(
      anomalyMonitor: Option[AnomalyMonitor] = None
    ): CreateAnomalyMonitorRequest =
      CreateAnomalyMonitorRequest
        .builder
        .ifSome(anomalyMonitor)(_.anomalyMonitor(_))
        .build

    def createAnomalyMonitorResponse(
      monitorArn: Option[String] = None
    ): CreateAnomalyMonitorResponse =
      CreateAnomalyMonitorResponse
        .builder
        .ifSome(monitorArn)(_.monitorArn(_))
        .build

    def createAnomalySubscriptionRequest(
      anomalySubscription: Option[AnomalySubscription] = None
    ): CreateAnomalySubscriptionRequest =
      CreateAnomalySubscriptionRequest
        .builder
        .ifSome(anomalySubscription)(_.anomalySubscription(_))
        .build

    def createAnomalySubscriptionResponse(
      subscriptionArn: Option[String] = None
    ): CreateAnomalySubscriptionResponse =
      CreateAnomalySubscriptionResponse
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def createCostCategoryDefinitionRequest(
      name: Option[String] = None,
      ruleVersion: Option[String] = None,
      rules: Option[List[CostCategoryRule]] = None,
      defaultValue: Option[String] = None
    ): CreateCostCategoryDefinitionRequest =
      CreateCostCategoryDefinitionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ruleVersion)(_.ruleVersion(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def createCostCategoryDefinitionResponse(
      costCategoryArn: Option[String] = None,
      effectiveStart: Option[String] = None
    ): CreateCostCategoryDefinitionResponse =
      CreateCostCategoryDefinitionResponse
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(effectiveStart)(_.effectiveStart(_))
        .build

    def currentInstance(
      resourceId: Option[String] = None,
      instanceName: Option[String] = None,
      tags: Option[List[TagValues]] = None,
      resourceDetails: Option[ResourceDetails] = None,
      resourceUtilization: Option[ResourceUtilization] = None,
      reservationCoveredHoursInLookbackPeriod: Option[String] = None,
      savingsPlansCoveredHoursInLookbackPeriod: Option[String] = None,
      onDemandHoursInLookbackPeriod: Option[String] = None,
      totalRunningHoursInLookbackPeriod: Option[String] = None,
      monthlyCost: Option[String] = None,
      currencyCode: Option[String] = None
    ): CurrentInstance =
      CurrentInstance
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(resourceDetails)(_.resourceDetails(_))
        .ifSome(resourceUtilization)(_.resourceUtilization(_))
        .ifSome(reservationCoveredHoursInLookbackPeriod)(_.reservationCoveredHoursInLookbackPeriod(_))
        .ifSome(savingsPlansCoveredHoursInLookbackPeriod)(_.savingsPlansCoveredHoursInLookbackPeriod(_))
        .ifSome(onDemandHoursInLookbackPeriod)(_.onDemandHoursInLookbackPeriod(_))
        .ifSome(totalRunningHoursInLookbackPeriod)(_.totalRunningHoursInLookbackPeriod(_))
        .ifSome(monthlyCost)(_.monthlyCost(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .build

    def dataUnavailableException(
      message: Option[String] = None
    ): DataUnavailableException =
      DataUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dateInterval(
      start: Option[String] = None,
      end: Option[String] = None
    ): DateInterval =
      DateInterval
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .build

    def deleteAnomalyMonitorRequest(
      monitorArn: Option[String] = None
    ): DeleteAnomalyMonitorRequest =
      DeleteAnomalyMonitorRequest
        .builder
        .ifSome(monitorArn)(_.monitorArn(_))
        .build

    def deleteAnomalyMonitorResponse(

    ): DeleteAnomalyMonitorResponse =
      DeleteAnomalyMonitorResponse
        .builder

        .build

    def deleteAnomalySubscriptionRequest(
      subscriptionArn: Option[String] = None
    ): DeleteAnomalySubscriptionRequest =
      DeleteAnomalySubscriptionRequest
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def deleteAnomalySubscriptionResponse(

    ): DeleteAnomalySubscriptionResponse =
      DeleteAnomalySubscriptionResponse
        .builder

        .build

    def deleteCostCategoryDefinitionRequest(
      costCategoryArn: Option[String] = None
    ): DeleteCostCategoryDefinitionRequest =
      DeleteCostCategoryDefinitionRequest
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .build

    def deleteCostCategoryDefinitionResponse(
      costCategoryArn: Option[String] = None,
      effectiveEnd: Option[String] = None
    ): DeleteCostCategoryDefinitionResponse =
      DeleteCostCategoryDefinitionResponse
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(effectiveEnd)(_.effectiveEnd(_))
        .build

    def describeCostCategoryDefinitionRequest(
      costCategoryArn: Option[String] = None,
      effectiveOn: Option[String] = None
    ): DescribeCostCategoryDefinitionRequest =
      DescribeCostCategoryDefinitionRequest
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(effectiveOn)(_.effectiveOn(_))
        .build

    def describeCostCategoryDefinitionResponse(
      costCategory: Option[CostCategory] = None
    ): DescribeCostCategoryDefinitionResponse =
      DescribeCostCategoryDefinitionResponse
        .builder
        .ifSome(costCategory)(_.costCategory(_))
        .build

    def dimensionValues(
      key: Option[String] = None,
      values: Option[List[Value]] = None,
      matchOptions: Option[List[MatchOption]] = None
    ): DimensionValues =
      DimensionValues
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(matchOptions)(_.matchOptions(_))
        .build

    def dimensionValuesWithAttributes(
      value: Option[String] = None,
      attributes: Option[Attributes] = None
    ): DimensionValuesWithAttributes =
      DimensionValuesWithAttributes
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def diskResourceUtilization(
      diskReadOpsPerSecond: Option[String] = None,
      diskWriteOpsPerSecond: Option[String] = None,
      diskReadBytesPerSecond: Option[String] = None,
      diskWriteBytesPerSecond: Option[String] = None
    ): DiskResourceUtilization =
      DiskResourceUtilization
        .builder
        .ifSome(diskReadOpsPerSecond)(_.diskReadOpsPerSecond(_))
        .ifSome(diskWriteOpsPerSecond)(_.diskWriteOpsPerSecond(_))
        .ifSome(diskReadBytesPerSecond)(_.diskReadBytesPerSecond(_))
        .ifSome(diskWriteBytesPerSecond)(_.diskWriteBytesPerSecond(_))
        .build

    def eBSResourceUtilization(
      ebsReadOpsPerSecond: Option[String] = None,
      ebsWriteOpsPerSecond: Option[String] = None,
      ebsReadBytesPerSecond: Option[String] = None,
      ebsWriteBytesPerSecond: Option[String] = None
    ): EBSResourceUtilization =
      EBSResourceUtilization
        .builder
        .ifSome(ebsReadOpsPerSecond)(_.ebsReadOpsPerSecond(_))
        .ifSome(ebsWriteOpsPerSecond)(_.ebsWriteOpsPerSecond(_))
        .ifSome(ebsReadBytesPerSecond)(_.ebsReadBytesPerSecond(_))
        .ifSome(ebsWriteBytesPerSecond)(_.ebsWriteBytesPerSecond(_))
        .build

    def eC2InstanceDetails(
      family: Option[String] = None,
      instanceType: Option[String] = None,
      region: Option[String] = None,
      availabilityZone: Option[String] = None,
      platform: Option[String] = None,
      tenancy: Option[String] = None,
      currentGeneration: Option[Boolean] = None,
      sizeFlexEligible: Option[Boolean] = None
    ): EC2InstanceDetails =
      EC2InstanceDetails
        .builder
        .ifSome(family)(_.family(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(region)(_.region(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(tenancy)(_.tenancy(_))
        .ifSome(currentGeneration)(_.currentGeneration(_))
        .ifSome(sizeFlexEligible)(_.sizeFlexEligible(_))
        .build

    def eC2ResourceDetails(
      hourlyOnDemandRate: Option[String] = None,
      instanceType: Option[String] = None,
      platform: Option[String] = None,
      region: Option[String] = None,
      sku: Option[String] = None,
      memory: Option[String] = None,
      networkPerformance: Option[String] = None,
      storage: Option[String] = None,
      vcpu: Option[String] = None
    ): EC2ResourceDetails =
      EC2ResourceDetails
        .builder
        .ifSome(hourlyOnDemandRate)(_.hourlyOnDemandRate(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(region)(_.region(_))
        .ifSome(sku)(_.sku(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(networkPerformance)(_.networkPerformance(_))
        .ifSome(storage)(_.storage(_))
        .ifSome(vcpu)(_.vcpu(_))
        .build

    def eC2ResourceUtilization(
      maxCpuUtilizationPercentage: Option[String] = None,
      maxMemoryUtilizationPercentage: Option[String] = None,
      maxStorageUtilizationPercentage: Option[String] = None,
      eBSResourceUtilization: Option[EBSResourceUtilization] = None,
      diskResourceUtilization: Option[DiskResourceUtilization] = None,
      networkResourceUtilization: Option[NetworkResourceUtilization] = None
    ): EC2ResourceUtilization =
      EC2ResourceUtilization
        .builder
        .ifSome(maxCpuUtilizationPercentage)(_.maxCpuUtilizationPercentage(_))
        .ifSome(maxMemoryUtilizationPercentage)(_.maxMemoryUtilizationPercentage(_))
        .ifSome(maxStorageUtilizationPercentage)(_.maxStorageUtilizationPercentage(_))
        .ifSome(eBSResourceUtilization)(_.eBSResourceUtilization(_))
        .ifSome(diskResourceUtilization)(_.diskResourceUtilization(_))
        .ifSome(networkResourceUtilization)(_.networkResourceUtilization(_))
        .build

    def eC2Specification(
      offeringClass: Option[String] = None
    ): EC2Specification =
      EC2Specification
        .builder
        .ifSome(offeringClass)(_.offeringClass(_))
        .build

    def eSInstanceDetails(
      instanceClass: Option[String] = None,
      instanceSize: Option[String] = None,
      region: Option[String] = None,
      currentGeneration: Option[Boolean] = None,
      sizeFlexEligible: Option[Boolean] = None
    ): ESInstanceDetails =
      ESInstanceDetails
        .builder
        .ifSome(instanceClass)(_.instanceClass(_))
        .ifSome(instanceSize)(_.instanceSize(_))
        .ifSome(region)(_.region(_))
        .ifSome(currentGeneration)(_.currentGeneration(_))
        .ifSome(sizeFlexEligible)(_.sizeFlexEligible(_))
        .build

    def elastiCacheInstanceDetails(
      family: Option[String] = None,
      nodeType: Option[String] = None,
      region: Option[String] = None,
      productDescription: Option[String] = None,
      currentGeneration: Option[Boolean] = None,
      sizeFlexEligible: Option[Boolean] = None
    ): ElastiCacheInstanceDetails =
      ElastiCacheInstanceDetails
        .builder
        .ifSome(family)(_.family(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(region)(_.region(_))
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(currentGeneration)(_.currentGeneration(_))
        .ifSome(sizeFlexEligible)(_.sizeFlexEligible(_))
        .build

    def expression(
      or: Option[List[Expression]] = None,
      and: Option[List[Expression]] = None,
      not: Option[Expression] = None,
      dimensions: Option[DimensionValues] = None,
      tags: Option[TagValues] = None,
      costCategories: Option[CostCategoryValues] = None
    ): Expression =
      Expression
        .builder
        .ifSome(or)(_.or(_))
        .ifSome(and)(_.and(_))
        .ifSome(not)(_.not(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(costCategories)(_.costCategories(_))
        .build

    def getAnomaliesRequest(
      monitorArn: Option[String] = None,
      dateInterval: Option[AnomalyDateInterval] = None,
      feedback: Option[String] = None,
      totalImpact: Option[TotalImpactFilter] = None,
      nextPageToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAnomaliesRequest =
      GetAnomaliesRequest
        .builder
        .ifSome(monitorArn)(_.monitorArn(_))
        .ifSome(dateInterval)(_.dateInterval(_))
        .ifSome(feedback)(_.feedback(_))
        .ifSome(totalImpact)(_.totalImpact(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getAnomaliesResponse(
      anomalies: Option[List[Anomaly]] = None,
      nextPageToken: Option[String] = None
    ): GetAnomaliesResponse =
      GetAnomaliesResponse
        .builder
        .ifSome(anomalies)(_.anomalies(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getAnomalyMonitorsRequest(
      monitorArnList: Option[List[Value]] = None,
      nextPageToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAnomalyMonitorsRequest =
      GetAnomalyMonitorsRequest
        .builder
        .ifSome(monitorArnList)(_.monitorArnList(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getAnomalyMonitorsResponse(
      anomalyMonitors: Option[List[AnomalyMonitor]] = None,
      nextPageToken: Option[String] = None
    ): GetAnomalyMonitorsResponse =
      GetAnomalyMonitorsResponse
        .builder
        .ifSome(anomalyMonitors)(_.anomalyMonitors(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getAnomalySubscriptionsRequest(
      subscriptionArnList: Option[List[Value]] = None,
      monitorArn: Option[String] = None,
      nextPageToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAnomalySubscriptionsRequest =
      GetAnomalySubscriptionsRequest
        .builder
        .ifSome(subscriptionArnList)(_.subscriptionArnList(_))
        .ifSome(monitorArn)(_.monitorArn(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getAnomalySubscriptionsResponse(
      anomalySubscriptions: Option[List[AnomalySubscription]] = None,
      nextPageToken: Option[String] = None
    ): GetAnomalySubscriptionsResponse =
      GetAnomalySubscriptionsResponse
        .builder
        .ifSome(anomalySubscriptions)(_.anomalySubscriptions(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getCostAndUsageRequest(
      timePeriod: Option[DateInterval] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      metrics: Option[List[MetricName]] = None,
      groupBy: Option[List[GroupDefinition]] = None,
      nextPageToken: Option[String] = None
    ): GetCostAndUsageRequest =
      GetCostAndUsageRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getCostAndUsageResponse(
      nextPageToken: Option[String] = None,
      groupDefinitions: Option[List[GroupDefinition]] = None,
      resultsByTime: Option[List[ResultByTime]] = None,
      dimensionValueAttributes: Option[List[DimensionValuesWithAttributes]] = None
    ): GetCostAndUsageResponse =
      GetCostAndUsageResponse
        .builder
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(groupDefinitions)(_.groupDefinitions(_))
        .ifSome(resultsByTime)(_.resultsByTime(_))
        .ifSome(dimensionValueAttributes)(_.dimensionValueAttributes(_))
        .build

    def getCostAndUsageWithResourcesRequest(
      timePeriod: Option[DateInterval] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      metrics: Option[List[MetricName]] = None,
      groupBy: Option[List[GroupDefinition]] = None,
      nextPageToken: Option[String] = None
    ): GetCostAndUsageWithResourcesRequest =
      GetCostAndUsageWithResourcesRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getCostAndUsageWithResourcesResponse(
      nextPageToken: Option[String] = None,
      groupDefinitions: Option[List[GroupDefinition]] = None,
      resultsByTime: Option[List[ResultByTime]] = None,
      dimensionValueAttributes: Option[List[DimensionValuesWithAttributes]] = None
    ): GetCostAndUsageWithResourcesResponse =
      GetCostAndUsageWithResourcesResponse
        .builder
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(groupDefinitions)(_.groupDefinitions(_))
        .ifSome(resultsByTime)(_.resultsByTime(_))
        .ifSome(dimensionValueAttributes)(_.dimensionValueAttributes(_))
        .build

    def getCostCategoriesRequest(
      searchString: Option[String] = None,
      timePeriod: Option[DateInterval] = None,
      costCategoryName: Option[String] = None,
      filter: Option[Expression] = None,
      sortBy: Option[List[SortDefinition]] = None,
      maxResults: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): GetCostCategoriesRequest =
      GetCostCategoriesRequest
        .builder
        .ifSome(searchString)(_.searchString(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(costCategoryName)(_.costCategoryName(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getCostCategoriesResponse(
      nextPageToken: Option[String] = None,
      costCategoryNames: Option[List[CostCategoryName]] = None,
      costCategoryValues: Option[List[CostCategoryValue]] = None,
      returnSize: Option[Int] = None,
      totalSize: Option[Int] = None
    ): GetCostCategoriesResponse =
      GetCostCategoriesResponse
        .builder
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(costCategoryNames)(_.costCategoryNames(_))
        .ifSome(costCategoryValues)(_.costCategoryValues(_))
        .ifSome(returnSize)(_.returnSize(_))
        .ifSome(totalSize)(_.totalSize(_))
        .build

    def getCostForecastRequest(
      timePeriod: Option[DateInterval] = None,
      metric: Option[String] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      predictionIntervalLevel: Option[Int] = None
    ): GetCostForecastRequest =
      GetCostForecastRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(metric)(_.metric(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(predictionIntervalLevel)(_.predictionIntervalLevel(_))
        .build

    def getCostForecastResponse(
      total: Option[MetricValue] = None,
      forecastResultsByTime: Option[List[ForecastResult]] = None
    ): GetCostForecastResponse =
      GetCostForecastResponse
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(forecastResultsByTime)(_.forecastResultsByTime(_))
        .build

    def getDimensionValuesRequest(
      searchString: Option[String] = None,
      timePeriod: Option[DateInterval] = None,
      dimension: Option[String] = None,
      context: Option[String] = None,
      filter: Option[Expression] = None,
      sortBy: Option[List[SortDefinition]] = None,
      maxResults: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): GetDimensionValuesRequest =
      GetDimensionValuesRequest
        .builder
        .ifSome(searchString)(_.searchString(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(dimension)(_.dimension(_))
        .ifSome(context)(_.context(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getDimensionValuesResponse(
      dimensionValues: Option[List[DimensionValuesWithAttributes]] = None,
      returnSize: Option[Int] = None,
      totalSize: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): GetDimensionValuesResponse =
      GetDimensionValuesResponse
        .builder
        .ifSome(dimensionValues)(_.dimensionValues(_))
        .ifSome(returnSize)(_.returnSize(_))
        .ifSome(totalSize)(_.totalSize(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getReservationCoverageRequest(
      timePeriod: Option[DateInterval] = None,
      groupBy: Option[List[GroupDefinition]] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      metrics: Option[List[MetricName]] = None,
      nextPageToken: Option[String] = None,
      sortBy: Option[SortDefinition] = None,
      maxResults: Option[Int] = None
    ): GetReservationCoverageRequest =
      GetReservationCoverageRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getReservationCoverageResponse(
      coveragesByTime: Option[List[CoverageByTime]] = None,
      total: Option[Coverage] = None,
      nextPageToken: Option[String] = None
    ): GetReservationCoverageResponse =
      GetReservationCoverageResponse
        .builder
        .ifSome(coveragesByTime)(_.coveragesByTime(_))
        .ifSome(total)(_.total(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getReservationPurchaseRecommendationRequest(
      accountId: Option[String] = None,
      service: Option[String] = None,
      filter: Option[Expression] = None,
      accountScope: Option[String] = None,
      lookbackPeriodInDays: Option[String] = None,
      termInYears: Option[String] = None,
      paymentOption: Option[String] = None,
      serviceSpecification: Option[ServiceSpecification] = None,
      pageSize: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): GetReservationPurchaseRecommendationRequest =
      GetReservationPurchaseRecommendationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(service)(_.service(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(accountScope)(_.accountScope(_))
        .ifSome(lookbackPeriodInDays)(_.lookbackPeriodInDays(_))
        .ifSome(termInYears)(_.termInYears(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(serviceSpecification)(_.serviceSpecification(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getReservationPurchaseRecommendationResponse(
      metadata: Option[ReservationPurchaseRecommendationMetadata] = None,
      recommendations: Option[List[ReservationPurchaseRecommendation]] = None,
      nextPageToken: Option[String] = None
    ): GetReservationPurchaseRecommendationResponse =
      GetReservationPurchaseRecommendationResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(recommendations)(_.recommendations(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getReservationUtilizationRequest(
      timePeriod: Option[DateInterval] = None,
      groupBy: Option[List[GroupDefinition]] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      sortBy: Option[SortDefinition] = None,
      nextPageToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetReservationUtilizationRequest =
      GetReservationUtilizationRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getReservationUtilizationResponse(
      utilizationsByTime: Option[List[UtilizationByTime]] = None,
      total: Option[ReservationAggregates] = None,
      nextPageToken: Option[String] = None
    ): GetReservationUtilizationResponse =
      GetReservationUtilizationResponse
        .builder
        .ifSome(utilizationsByTime)(_.utilizationsByTime(_))
        .ifSome(total)(_.total(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getRightsizingRecommendationRequest(
      filter: Option[Expression] = None,
      configuration: Option[RightsizingRecommendationConfiguration] = None,
      service: Option[String] = None,
      pageSize: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): GetRightsizingRecommendationRequest =
      GetRightsizingRecommendationRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(service)(_.service(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getRightsizingRecommendationResponse(
      metadata: Option[RightsizingRecommendationMetadata] = None,
      summary: Option[RightsizingRecommendationSummary] = None,
      rightsizingRecommendations: Option[List[RightsizingRecommendation]] = None,
      nextPageToken: Option[String] = None,
      configuration: Option[RightsizingRecommendationConfiguration] = None
    ): GetRightsizingRecommendationResponse =
      GetRightsizingRecommendationResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(summary)(_.summary(_))
        .ifSome(rightsizingRecommendations)(_.rightsizingRecommendations(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def getSavingsPlansCoverageRequest(
      timePeriod: Option[DateInterval] = None,
      groupBy: Option[List[GroupDefinition]] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      metrics: Option[List[MetricName]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortBy: Option[SortDefinition] = None
    ): GetSavingsPlansCoverageRequest =
      GetSavingsPlansCoverageRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getSavingsPlansCoverageResponse(
      savingsPlansCoverages: Option[List[SavingsPlansCoverage]] = None,
      nextToken: Option[String] = None
    ): GetSavingsPlansCoverageResponse =
      GetSavingsPlansCoverageResponse
        .builder
        .ifSome(savingsPlansCoverages)(_.savingsPlansCoverages(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSavingsPlansPurchaseRecommendationRequest(
      savingsPlansType: Option[String] = None,
      termInYears: Option[String] = None,
      paymentOption: Option[String] = None,
      accountScope: Option[String] = None,
      nextPageToken: Option[String] = None,
      pageSize: Option[Int] = None,
      lookbackPeriodInDays: Option[String] = None,
      filter: Option[Expression] = None
    ): GetSavingsPlansPurchaseRecommendationRequest =
      GetSavingsPlansPurchaseRecommendationRequest
        .builder
        .ifSome(savingsPlansType)(_.savingsPlansType(_))
        .ifSome(termInYears)(_.termInYears(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(accountScope)(_.accountScope(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(lookbackPeriodInDays)(_.lookbackPeriodInDays(_))
        .ifSome(filter)(_.filter(_))
        .build

    def getSavingsPlansPurchaseRecommendationResponse(
      metadata: Option[SavingsPlansPurchaseRecommendationMetadata] = None,
      savingsPlansPurchaseRecommendation: Option[SavingsPlansPurchaseRecommendation] = None,
      nextPageToken: Option[String] = None
    ): GetSavingsPlansPurchaseRecommendationResponse =
      GetSavingsPlansPurchaseRecommendationResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(savingsPlansPurchaseRecommendation)(_.savingsPlansPurchaseRecommendation(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getSavingsPlansUtilizationDetailsRequest(
      timePeriod: Option[DateInterval] = None,
      filter: Option[Expression] = None,
      dataType: Option[List[SavingsPlansDataType]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortBy: Option[SortDefinition] = None
    ): GetSavingsPlansUtilizationDetailsRequest =
      GetSavingsPlansUtilizationDetailsRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getSavingsPlansUtilizationDetailsResponse(
      savingsPlansUtilizationDetails: Option[List[SavingsPlansUtilizationDetail]] = None,
      total: Option[SavingsPlansUtilizationAggregates] = None,
      timePeriod: Option[DateInterval] = None,
      nextToken: Option[String] = None
    ): GetSavingsPlansUtilizationDetailsResponse =
      GetSavingsPlansUtilizationDetailsResponse
        .builder
        .ifSome(savingsPlansUtilizationDetails)(_.savingsPlansUtilizationDetails(_))
        .ifSome(total)(_.total(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSavingsPlansUtilizationRequest(
      timePeriod: Option[DateInterval] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      sortBy: Option[SortDefinition] = None
    ): GetSavingsPlansUtilizationRequest =
      GetSavingsPlansUtilizationRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getSavingsPlansUtilizationResponse(
      savingsPlansUtilizationsByTime: Option[List[SavingsPlansUtilizationByTime]] = None,
      total: Option[SavingsPlansUtilizationAggregates] = None
    ): GetSavingsPlansUtilizationResponse =
      GetSavingsPlansUtilizationResponse
        .builder
        .ifSome(savingsPlansUtilizationsByTime)(_.savingsPlansUtilizationsByTime(_))
        .ifSome(total)(_.total(_))
        .build

    def getTagsRequest(
      searchString: Option[String] = None,
      timePeriod: Option[DateInterval] = None,
      tagKey: Option[String] = None,
      filter: Option[Expression] = None,
      sortBy: Option[List[SortDefinition]] = None,
      maxResults: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): GetTagsRequest =
      GetTagsRequest
        .builder
        .ifSome(searchString)(_.searchString(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def getTagsResponse(
      nextPageToken: Option[String] = None,
      tags: Option[List[Entity]] = None,
      returnSize: Option[Int] = None,
      totalSize: Option[Int] = None
    ): GetTagsResponse =
      GetTagsResponse
        .builder
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(returnSize)(_.returnSize(_))
        .ifSome(totalSize)(_.totalSize(_))
        .build

    def getUsageForecastRequest(
      timePeriod: Option[DateInterval] = None,
      metric: Option[String] = None,
      granularity: Option[String] = None,
      filter: Option[Expression] = None,
      predictionIntervalLevel: Option[Int] = None
    ): GetUsageForecastRequest =
      GetUsageForecastRequest
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(metric)(_.metric(_))
        .ifSome(granularity)(_.granularity(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(predictionIntervalLevel)(_.predictionIntervalLevel(_))
        .build

    def getUsageForecastResponse(
      total: Option[MetricValue] = None,
      forecastResultsByTime: Option[List[ForecastResult]] = None
    ): GetUsageForecastResponse =
      GetUsageForecastResponse
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(forecastResultsByTime)(_.forecastResultsByTime(_))
        .build

    def group(
      keys: Option[List[Key]] = None,
      metrics: Option[Metrics] = None
    ): Group =
      Group
        .builder
        .ifSome(keys)(_.keys(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def groupDefinition(
      `type`: Option[String] = None,
      key: Option[String] = None
    ): GroupDefinition =
      GroupDefinition
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(key)(_.key(_))
        .build

    def impact(
      maxImpact: Option[GenericDouble] = None,
      totalImpact: Option[GenericDouble] = None
    ): Impact =
      Impact
        .builder
        .ifSome(maxImpact)(_.maxImpact(_))
        .ifSome(totalImpact)(_.totalImpact(_))
        .build

    def instanceDetails(
      eC2InstanceDetails: Option[EC2InstanceDetails] = None,
      rDSInstanceDetails: Option[RDSInstanceDetails] = None,
      redshiftInstanceDetails: Option[RedshiftInstanceDetails] = None,
      elastiCacheInstanceDetails: Option[ElastiCacheInstanceDetails] = None,
      eSInstanceDetails: Option[ESInstanceDetails] = None
    ): InstanceDetails =
      InstanceDetails
        .builder
        .ifSome(eC2InstanceDetails)(_.eC2InstanceDetails(_))
        .ifSome(rDSInstanceDetails)(_.rDSInstanceDetails(_))
        .ifSome(redshiftInstanceDetails)(_.redshiftInstanceDetails(_))
        .ifSome(elastiCacheInstanceDetails)(_.elastiCacheInstanceDetails(_))
        .ifSome(eSInstanceDetails)(_.eSInstanceDetails(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
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

    def listCostCategoryDefinitionsRequest(
      effectiveOn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCostCategoryDefinitionsRequest =
      ListCostCategoryDefinitionsRequest
        .builder
        .ifSome(effectiveOn)(_.effectiveOn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCostCategoryDefinitionsResponse(
      costCategoryReferences: Option[List[CostCategoryReference]] = None,
      nextToken: Option[String] = None
    ): ListCostCategoryDefinitionsResponse =
      ListCostCategoryDefinitionsResponse
        .builder
        .ifSome(costCategoryReferences)(_.costCategoryReferences(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def metricValue(
      amount: Option[String] = None,
      unit: Option[String] = None
    ): MetricValue =
      MetricValue
        .builder
        .ifSome(amount)(_.amount(_))
        .ifSome(unit)(_.unit(_))
        .build

    def modifyRecommendationDetail(
      targetInstances: Option[List[TargetInstance]] = None
    ): ModifyRecommendationDetail =
      ModifyRecommendationDetail
        .builder
        .ifSome(targetInstances)(_.targetInstances(_))
        .build

    def networkResourceUtilization(
      networkInBytesPerSecond: Option[String] = None,
      networkOutBytesPerSecond: Option[String] = None,
      networkPacketsInPerSecond: Option[String] = None,
      networkPacketsOutPerSecond: Option[String] = None
    ): NetworkResourceUtilization =
      NetworkResourceUtilization
        .builder
        .ifSome(networkInBytesPerSecond)(_.networkInBytesPerSecond(_))
        .ifSome(networkOutBytesPerSecond)(_.networkOutBytesPerSecond(_))
        .ifSome(networkPacketsInPerSecond)(_.networkPacketsInPerSecond(_))
        .ifSome(networkPacketsOutPerSecond)(_.networkPacketsOutPerSecond(_))
        .build

    def provideAnomalyFeedbackRequest(
      anomalyId: Option[String] = None,
      feedback: Option[String] = None
    ): ProvideAnomalyFeedbackRequest =
      ProvideAnomalyFeedbackRequest
        .builder
        .ifSome(anomalyId)(_.anomalyId(_))
        .ifSome(feedback)(_.feedback(_))
        .build

    def provideAnomalyFeedbackResponse(
      anomalyId: Option[String] = None
    ): ProvideAnomalyFeedbackResponse =
      ProvideAnomalyFeedbackResponse
        .builder
        .ifSome(anomalyId)(_.anomalyId(_))
        .build

    def rDSInstanceDetails(
      family: Option[String] = None,
      instanceType: Option[String] = None,
      region: Option[String] = None,
      databaseEngine: Option[String] = None,
      databaseEdition: Option[String] = None,
      deploymentOption: Option[String] = None,
      licenseModel: Option[String] = None,
      currentGeneration: Option[Boolean] = None,
      sizeFlexEligible: Option[Boolean] = None
    ): RDSInstanceDetails =
      RDSInstanceDetails
        .builder
        .ifSome(family)(_.family(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(region)(_.region(_))
        .ifSome(databaseEngine)(_.databaseEngine(_))
        .ifSome(databaseEdition)(_.databaseEdition(_))
        .ifSome(deploymentOption)(_.deploymentOption(_))
        .ifSome(licenseModel)(_.licenseModel(_))
        .ifSome(currentGeneration)(_.currentGeneration(_))
        .ifSome(sizeFlexEligible)(_.sizeFlexEligible(_))
        .build

    def redshiftInstanceDetails(
      family: Option[String] = None,
      nodeType: Option[String] = None,
      region: Option[String] = None,
      currentGeneration: Option[Boolean] = None,
      sizeFlexEligible: Option[Boolean] = None
    ): RedshiftInstanceDetails =
      RedshiftInstanceDetails
        .builder
        .ifSome(family)(_.family(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(region)(_.region(_))
        .ifSome(currentGeneration)(_.currentGeneration(_))
        .ifSome(sizeFlexEligible)(_.sizeFlexEligible(_))
        .build

    def requestChangedException(
      message: Option[String] = None
    ): RequestChangedException =
      RequestChangedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def reservationAggregates(
      utilizationPercentage: Option[String] = None,
      utilizationPercentageInUnits: Option[String] = None,
      purchasedHours: Option[String] = None,
      purchasedUnits: Option[String] = None,
      totalActualHours: Option[String] = None,
      totalActualUnits: Option[String] = None,
      unusedHours: Option[String] = None,
      unusedUnits: Option[String] = None,
      onDemandCostOfRIHoursUsed: Option[String] = None,
      netRISavings: Option[String] = None,
      totalPotentialRISavings: Option[String] = None,
      amortizedUpfrontFee: Option[String] = None,
      amortizedRecurringFee: Option[String] = None,
      totalAmortizedFee: Option[String] = None,
      rICostForUnusedHours: Option[String] = None,
      realizedSavings: Option[String] = None,
      unrealizedSavings: Option[String] = None
    ): ReservationAggregates =
      ReservationAggregates
        .builder
        .ifSome(utilizationPercentage)(_.utilizationPercentage(_))
        .ifSome(utilizationPercentageInUnits)(_.utilizationPercentageInUnits(_))
        .ifSome(purchasedHours)(_.purchasedHours(_))
        .ifSome(purchasedUnits)(_.purchasedUnits(_))
        .ifSome(totalActualHours)(_.totalActualHours(_))
        .ifSome(totalActualUnits)(_.totalActualUnits(_))
        .ifSome(unusedHours)(_.unusedHours(_))
        .ifSome(unusedUnits)(_.unusedUnits(_))
        .ifSome(onDemandCostOfRIHoursUsed)(_.onDemandCostOfRIHoursUsed(_))
        .ifSome(netRISavings)(_.netRISavings(_))
        .ifSome(totalPotentialRISavings)(_.totalPotentialRISavings(_))
        .ifSome(amortizedUpfrontFee)(_.amortizedUpfrontFee(_))
        .ifSome(amortizedRecurringFee)(_.amortizedRecurringFee(_))
        .ifSome(totalAmortizedFee)(_.totalAmortizedFee(_))
        .ifSome(rICostForUnusedHours)(_.rICostForUnusedHours(_))
        .ifSome(realizedSavings)(_.realizedSavings(_))
        .ifSome(unrealizedSavings)(_.unrealizedSavings(_))
        .build

    def reservationCoverageGroup(
      attributes: Option[Attributes] = None,
      coverage: Option[Coverage] = None
    ): ReservationCoverageGroup =
      ReservationCoverageGroup
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(coverage)(_.coverage(_))
        .build

    def reservationPurchaseRecommendation(
      accountScope: Option[String] = None,
      lookbackPeriodInDays: Option[String] = None,
      termInYears: Option[String] = None,
      paymentOption: Option[String] = None,
      serviceSpecification: Option[ServiceSpecification] = None,
      recommendationDetails: Option[List[ReservationPurchaseRecommendationDetail]] = None,
      recommendationSummary: Option[ReservationPurchaseRecommendationSummary] = None
    ): ReservationPurchaseRecommendation =
      ReservationPurchaseRecommendation
        .builder
        .ifSome(accountScope)(_.accountScope(_))
        .ifSome(lookbackPeriodInDays)(_.lookbackPeriodInDays(_))
        .ifSome(termInYears)(_.termInYears(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(serviceSpecification)(_.serviceSpecification(_))
        .ifSome(recommendationDetails)(_.recommendationDetails(_))
        .ifSome(recommendationSummary)(_.recommendationSummary(_))
        .build

    def reservationPurchaseRecommendationDetail(
      accountId: Option[String] = None,
      instanceDetails: Option[InstanceDetails] = None,
      recommendedNumberOfInstancesToPurchase: Option[String] = None,
      recommendedNormalizedUnitsToPurchase: Option[String] = None,
      minimumNumberOfInstancesUsedPerHour: Option[String] = None,
      minimumNormalizedUnitsUsedPerHour: Option[String] = None,
      maximumNumberOfInstancesUsedPerHour: Option[String] = None,
      maximumNormalizedUnitsUsedPerHour: Option[String] = None,
      averageNumberOfInstancesUsedPerHour: Option[String] = None,
      averageNormalizedUnitsUsedPerHour: Option[String] = None,
      averageUtilization: Option[String] = None,
      estimatedBreakEvenInMonths: Option[String] = None,
      currencyCode: Option[String] = None,
      estimatedMonthlySavingsAmount: Option[String] = None,
      estimatedMonthlySavingsPercentage: Option[String] = None,
      estimatedMonthlyOnDemandCost: Option[String] = None,
      estimatedReservationCostForLookbackPeriod: Option[String] = None,
      upfrontCost: Option[String] = None,
      recurringStandardMonthlyCost: Option[String] = None
    ): ReservationPurchaseRecommendationDetail =
      ReservationPurchaseRecommendationDetail
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(instanceDetails)(_.instanceDetails(_))
        .ifSome(recommendedNumberOfInstancesToPurchase)(_.recommendedNumberOfInstancesToPurchase(_))
        .ifSome(recommendedNormalizedUnitsToPurchase)(_.recommendedNormalizedUnitsToPurchase(_))
        .ifSome(minimumNumberOfInstancesUsedPerHour)(_.minimumNumberOfInstancesUsedPerHour(_))
        .ifSome(minimumNormalizedUnitsUsedPerHour)(_.minimumNormalizedUnitsUsedPerHour(_))
        .ifSome(maximumNumberOfInstancesUsedPerHour)(_.maximumNumberOfInstancesUsedPerHour(_))
        .ifSome(maximumNormalizedUnitsUsedPerHour)(_.maximumNormalizedUnitsUsedPerHour(_))
        .ifSome(averageNumberOfInstancesUsedPerHour)(_.averageNumberOfInstancesUsedPerHour(_))
        .ifSome(averageNormalizedUnitsUsedPerHour)(_.averageNormalizedUnitsUsedPerHour(_))
        .ifSome(averageUtilization)(_.averageUtilization(_))
        .ifSome(estimatedBreakEvenInMonths)(_.estimatedBreakEvenInMonths(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(estimatedMonthlySavingsAmount)(_.estimatedMonthlySavingsAmount(_))
        .ifSome(estimatedMonthlySavingsPercentage)(_.estimatedMonthlySavingsPercentage(_))
        .ifSome(estimatedMonthlyOnDemandCost)(_.estimatedMonthlyOnDemandCost(_))
        .ifSome(estimatedReservationCostForLookbackPeriod)(_.estimatedReservationCostForLookbackPeriod(_))
        .ifSome(upfrontCost)(_.upfrontCost(_))
        .ifSome(recurringStandardMonthlyCost)(_.recurringStandardMonthlyCost(_))
        .build

    def reservationPurchaseRecommendationMetadata(
      recommendationId: Option[String] = None,
      generationTimestamp: Option[String] = None
    ): ReservationPurchaseRecommendationMetadata =
      ReservationPurchaseRecommendationMetadata
        .builder
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(generationTimestamp)(_.generationTimestamp(_))
        .build

    def reservationPurchaseRecommendationSummary(
      totalEstimatedMonthlySavingsAmount: Option[String] = None,
      totalEstimatedMonthlySavingsPercentage: Option[String] = None,
      currencyCode: Option[String] = None
    ): ReservationPurchaseRecommendationSummary =
      ReservationPurchaseRecommendationSummary
        .builder
        .ifSome(totalEstimatedMonthlySavingsAmount)(_.totalEstimatedMonthlySavingsAmount(_))
        .ifSome(totalEstimatedMonthlySavingsPercentage)(_.totalEstimatedMonthlySavingsPercentage(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .build

    def reservationUtilizationGroup(
      key: Option[String] = None,
      value: Option[String] = None,
      attributes: Option[Attributes] = None,
      utilization: Option[ReservationAggregates] = None
    ): ReservationUtilizationGroup =
      ReservationUtilizationGroup
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(utilization)(_.utilization(_))
        .build

    def resourceDetails(
      eC2ResourceDetails: Option[EC2ResourceDetails] = None
    ): ResourceDetails =
      ResourceDetails
        .builder
        .ifSome(eC2ResourceDetails)(_.eC2ResourceDetails(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceUtilization(
      eC2ResourceUtilization: Option[EC2ResourceUtilization] = None
    ): ResourceUtilization =
      ResourceUtilization
        .builder
        .ifSome(eC2ResourceUtilization)(_.eC2ResourceUtilization(_))
        .build

    def resultByTime(
      timePeriod: Option[DateInterval] = None,
      total: Option[Metrics] = None,
      groups: Option[List[Group]] = None,
      estimated: Option[Boolean] = None
    ): ResultByTime =
      ResultByTime
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(total)(_.total(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(estimated)(_.estimated(_))
        .build

    def rightsizingRecommendation(
      accountId: Option[String] = None,
      currentInstance: Option[CurrentInstance] = None,
      rightsizingType: Option[String] = None,
      modifyRecommendationDetail: Option[ModifyRecommendationDetail] = None,
      terminateRecommendationDetail: Option[TerminateRecommendationDetail] = None,
      findingReasonCodes: Option[List[FindingReasonCode]] = None
    ): RightsizingRecommendation =
      RightsizingRecommendation
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(currentInstance)(_.currentInstance(_))
        .ifSome(rightsizingType)(_.rightsizingType(_))
        .ifSome(modifyRecommendationDetail)(_.modifyRecommendationDetail(_))
        .ifSome(terminateRecommendationDetail)(_.terminateRecommendationDetail(_))
        .ifSome(findingReasonCodes)(_.findingReasonCodes(_))
        .build

    def rightsizingRecommendationConfiguration(
      recommendationTarget: Option[String] = None,
      benefitsConsidered: Option[Boolean] = None
    ): RightsizingRecommendationConfiguration =
      RightsizingRecommendationConfiguration
        .builder
        .ifSome(recommendationTarget)(_.recommendationTarget(_))
        .ifSome(benefitsConsidered)(_.benefitsConsidered(_))
        .build

    def rightsizingRecommendationMetadata(
      recommendationId: Option[String] = None,
      generationTimestamp: Option[String] = None,
      lookbackPeriodInDays: Option[String] = None,
      additionalMetadata: Option[String] = None
    ): RightsizingRecommendationMetadata =
      RightsizingRecommendationMetadata
        .builder
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(generationTimestamp)(_.generationTimestamp(_))
        .ifSome(lookbackPeriodInDays)(_.lookbackPeriodInDays(_))
        .ifSome(additionalMetadata)(_.additionalMetadata(_))
        .build

    def rightsizingRecommendationSummary(
      totalRecommendationCount: Option[String] = None,
      estimatedTotalMonthlySavingsAmount: Option[String] = None,
      savingsCurrencyCode: Option[String] = None,
      savingsPercentage: Option[String] = None
    ): RightsizingRecommendationSummary =
      RightsizingRecommendationSummary
        .builder
        .ifSome(totalRecommendationCount)(_.totalRecommendationCount(_))
        .ifSome(estimatedTotalMonthlySavingsAmount)(_.estimatedTotalMonthlySavingsAmount(_))
        .ifSome(savingsCurrencyCode)(_.savingsCurrencyCode(_))
        .ifSome(savingsPercentage)(_.savingsPercentage(_))
        .build

    def rootCause(
      service: Option[String] = None,
      region: Option[String] = None,
      linkedAccount: Option[String] = None,
      usageType: Option[String] = None
    ): RootCause =
      RootCause
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(region)(_.region(_))
        .ifSome(linkedAccount)(_.linkedAccount(_))
        .ifSome(usageType)(_.usageType(_))
        .build

    def savingsPlansAmortizedCommitment(
      amortizedRecurringCommitment: Option[String] = None,
      amortizedUpfrontCommitment: Option[String] = None,
      totalAmortizedCommitment: Option[String] = None
    ): SavingsPlansAmortizedCommitment =
      SavingsPlansAmortizedCommitment
        .builder
        .ifSome(amortizedRecurringCommitment)(_.amortizedRecurringCommitment(_))
        .ifSome(amortizedUpfrontCommitment)(_.amortizedUpfrontCommitment(_))
        .ifSome(totalAmortizedCommitment)(_.totalAmortizedCommitment(_))
        .build

    def savingsPlansCoverage(
      attributes: Option[Attributes] = None,
      coverage: Option[SavingsPlansCoverageData] = None,
      timePeriod: Option[DateInterval] = None
    ): SavingsPlansCoverage =
      SavingsPlansCoverage
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(coverage)(_.coverage(_))
        .ifSome(timePeriod)(_.timePeriod(_))
        .build

    def savingsPlansCoverageData(
      spendCoveredBySavingsPlans: Option[String] = None,
      onDemandCost: Option[String] = None,
      totalCost: Option[String] = None,
      coveragePercentage: Option[String] = None
    ): SavingsPlansCoverageData =
      SavingsPlansCoverageData
        .builder
        .ifSome(spendCoveredBySavingsPlans)(_.spendCoveredBySavingsPlans(_))
        .ifSome(onDemandCost)(_.onDemandCost(_))
        .ifSome(totalCost)(_.totalCost(_))
        .ifSome(coveragePercentage)(_.coveragePercentage(_))
        .build

    def savingsPlansDetails(
      region: Option[String] = None,
      instanceFamily: Option[String] = None,
      offeringId: Option[String] = None
    ): SavingsPlansDetails =
      SavingsPlansDetails
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(instanceFamily)(_.instanceFamily(_))
        .ifSome(offeringId)(_.offeringId(_))
        .build

    def savingsPlansPurchaseRecommendation(
      accountScope: Option[String] = None,
      savingsPlansType: Option[String] = None,
      termInYears: Option[String] = None,
      paymentOption: Option[String] = None,
      lookbackPeriodInDays: Option[String] = None,
      savingsPlansPurchaseRecommendationDetails: Option[List[SavingsPlansPurchaseRecommendationDetail]] = None,
      savingsPlansPurchaseRecommendationSummary: Option[SavingsPlansPurchaseRecommendationSummary] = None
    ): SavingsPlansPurchaseRecommendation =
      SavingsPlansPurchaseRecommendation
        .builder
        .ifSome(accountScope)(_.accountScope(_))
        .ifSome(savingsPlansType)(_.savingsPlansType(_))
        .ifSome(termInYears)(_.termInYears(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(lookbackPeriodInDays)(_.lookbackPeriodInDays(_))
        .ifSome(savingsPlansPurchaseRecommendationDetails)(_.savingsPlansPurchaseRecommendationDetails(_))
        .ifSome(savingsPlansPurchaseRecommendationSummary)(_.savingsPlansPurchaseRecommendationSummary(_))
        .build

    def savingsPlansPurchaseRecommendationDetail(
      savingsPlansDetails: Option[SavingsPlansDetails] = None,
      accountId: Option[String] = None,
      upfrontCost: Option[String] = None,
      estimatedROI: Option[String] = None,
      currencyCode: Option[String] = None,
      estimatedSPCost: Option[String] = None,
      estimatedOnDemandCost: Option[String] = None,
      estimatedOnDemandCostWithCurrentCommitment: Option[String] = None,
      estimatedSavingsAmount: Option[String] = None,
      estimatedSavingsPercentage: Option[String] = None,
      hourlyCommitmentToPurchase: Option[String] = None,
      estimatedAverageUtilization: Option[String] = None,
      estimatedMonthlySavingsAmount: Option[String] = None,
      currentMinimumHourlyOnDemandSpend: Option[String] = None,
      currentMaximumHourlyOnDemandSpend: Option[String] = None,
      currentAverageHourlyOnDemandSpend: Option[String] = None
    ): SavingsPlansPurchaseRecommendationDetail =
      SavingsPlansPurchaseRecommendationDetail
        .builder
        .ifSome(savingsPlansDetails)(_.savingsPlansDetails(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(upfrontCost)(_.upfrontCost(_))
        .ifSome(estimatedROI)(_.estimatedROI(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(estimatedSPCost)(_.estimatedSPCost(_))
        .ifSome(estimatedOnDemandCost)(_.estimatedOnDemandCost(_))
        .ifSome(estimatedOnDemandCostWithCurrentCommitment)(_.estimatedOnDemandCostWithCurrentCommitment(_))
        .ifSome(estimatedSavingsAmount)(_.estimatedSavingsAmount(_))
        .ifSome(estimatedSavingsPercentage)(_.estimatedSavingsPercentage(_))
        .ifSome(hourlyCommitmentToPurchase)(_.hourlyCommitmentToPurchase(_))
        .ifSome(estimatedAverageUtilization)(_.estimatedAverageUtilization(_))
        .ifSome(estimatedMonthlySavingsAmount)(_.estimatedMonthlySavingsAmount(_))
        .ifSome(currentMinimumHourlyOnDemandSpend)(_.currentMinimumHourlyOnDemandSpend(_))
        .ifSome(currentMaximumHourlyOnDemandSpend)(_.currentMaximumHourlyOnDemandSpend(_))
        .ifSome(currentAverageHourlyOnDemandSpend)(_.currentAverageHourlyOnDemandSpend(_))
        .build

    def savingsPlansPurchaseRecommendationMetadata(
      recommendationId: Option[String] = None,
      generationTimestamp: Option[String] = None,
      additionalMetadata: Option[String] = None
    ): SavingsPlansPurchaseRecommendationMetadata =
      SavingsPlansPurchaseRecommendationMetadata
        .builder
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(generationTimestamp)(_.generationTimestamp(_))
        .ifSome(additionalMetadata)(_.additionalMetadata(_))
        .build

    def savingsPlansPurchaseRecommendationSummary(
      estimatedROI: Option[String] = None,
      currencyCode: Option[String] = None,
      estimatedTotalCost: Option[String] = None,
      currentOnDemandSpend: Option[String] = None,
      estimatedSavingsAmount: Option[String] = None,
      totalRecommendationCount: Option[String] = None,
      dailyCommitmentToPurchase: Option[String] = None,
      hourlyCommitmentToPurchase: Option[String] = None,
      estimatedSavingsPercentage: Option[String] = None,
      estimatedMonthlySavingsAmount: Option[String] = None,
      estimatedOnDemandCostWithCurrentCommitment: Option[String] = None
    ): SavingsPlansPurchaseRecommendationSummary =
      SavingsPlansPurchaseRecommendationSummary
        .builder
        .ifSome(estimatedROI)(_.estimatedROI(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(estimatedTotalCost)(_.estimatedTotalCost(_))
        .ifSome(currentOnDemandSpend)(_.currentOnDemandSpend(_))
        .ifSome(estimatedSavingsAmount)(_.estimatedSavingsAmount(_))
        .ifSome(totalRecommendationCount)(_.totalRecommendationCount(_))
        .ifSome(dailyCommitmentToPurchase)(_.dailyCommitmentToPurchase(_))
        .ifSome(hourlyCommitmentToPurchase)(_.hourlyCommitmentToPurchase(_))
        .ifSome(estimatedSavingsPercentage)(_.estimatedSavingsPercentage(_))
        .ifSome(estimatedMonthlySavingsAmount)(_.estimatedMonthlySavingsAmount(_))
        .ifSome(estimatedOnDemandCostWithCurrentCommitment)(_.estimatedOnDemandCostWithCurrentCommitment(_))
        .build

    def savingsPlansSavings(
      netSavings: Option[String] = None,
      onDemandCostEquivalent: Option[String] = None
    ): SavingsPlansSavings =
      SavingsPlansSavings
        .builder
        .ifSome(netSavings)(_.netSavings(_))
        .ifSome(onDemandCostEquivalent)(_.onDemandCostEquivalent(_))
        .build

    def savingsPlansUtilization(
      totalCommitment: Option[String] = None,
      usedCommitment: Option[String] = None,
      unusedCommitment: Option[String] = None,
      utilizationPercentage: Option[String] = None
    ): SavingsPlansUtilization =
      SavingsPlansUtilization
        .builder
        .ifSome(totalCommitment)(_.totalCommitment(_))
        .ifSome(usedCommitment)(_.usedCommitment(_))
        .ifSome(unusedCommitment)(_.unusedCommitment(_))
        .ifSome(utilizationPercentage)(_.utilizationPercentage(_))
        .build

    def savingsPlansUtilizationAggregates(
      utilization: Option[SavingsPlansUtilization] = None,
      savings: Option[SavingsPlansSavings] = None,
      amortizedCommitment: Option[SavingsPlansAmortizedCommitment] = None
    ): SavingsPlansUtilizationAggregates =
      SavingsPlansUtilizationAggregates
        .builder
        .ifSome(utilization)(_.utilization(_))
        .ifSome(savings)(_.savings(_))
        .ifSome(amortizedCommitment)(_.amortizedCommitment(_))
        .build

    def savingsPlansUtilizationByTime(
      timePeriod: Option[DateInterval] = None,
      utilization: Option[SavingsPlansUtilization] = None,
      savings: Option[SavingsPlansSavings] = None,
      amortizedCommitment: Option[SavingsPlansAmortizedCommitment] = None
    ): SavingsPlansUtilizationByTime =
      SavingsPlansUtilizationByTime
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(utilization)(_.utilization(_))
        .ifSome(savings)(_.savings(_))
        .ifSome(amortizedCommitment)(_.amortizedCommitment(_))
        .build

    def savingsPlansUtilizationDetail(
      savingsPlanArn: Option[String] = None,
      attributes: Option[Attributes] = None,
      utilization: Option[SavingsPlansUtilization] = None,
      savings: Option[SavingsPlansSavings] = None,
      amortizedCommitment: Option[SavingsPlansAmortizedCommitment] = None
    ): SavingsPlansUtilizationDetail =
      SavingsPlansUtilizationDetail
        .builder
        .ifSome(savingsPlanArn)(_.savingsPlanArn(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(utilization)(_.utilization(_))
        .ifSome(savings)(_.savings(_))
        .ifSome(amortizedCommitment)(_.amortizedCommitment(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceSpecification(
      eC2Specification: Option[EC2Specification] = None
    ): ServiceSpecification =
      ServiceSpecification
        .builder
        .ifSome(eC2Specification)(_.eC2Specification(_))
        .build

    def sortDefinition(
      key: Option[String] = None,
      sortOrder: Option[String] = None
    ): SortDefinition =
      SortDefinition
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def subscriber(
      address: Option[String] = None,
      `type`: Option[String] = None,
      status: Option[String] = None
    ): Subscriber =
      Subscriber
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .build

    def tagValues(
      key: Option[String] = None,
      values: Option[List[Value]] = None,
      matchOptions: Option[List[MatchOption]] = None
    ): TagValues =
      TagValues
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(matchOptions)(_.matchOptions(_))
        .build

    def targetInstance(
      estimatedMonthlyCost: Option[String] = None,
      estimatedMonthlySavings: Option[String] = None,
      currencyCode: Option[String] = None,
      defaultTargetInstance: Option[Boolean] = None,
      resourceDetails: Option[ResourceDetails] = None,
      expectedResourceUtilization: Option[ResourceUtilization] = None,
      platformDifferences: Option[List[PlatformDifference]] = None
    ): TargetInstance =
      TargetInstance
        .builder
        .ifSome(estimatedMonthlyCost)(_.estimatedMonthlyCost(_))
        .ifSome(estimatedMonthlySavings)(_.estimatedMonthlySavings(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(defaultTargetInstance)(_.defaultTargetInstance(_))
        .ifSome(resourceDetails)(_.resourceDetails(_))
        .ifSome(expectedResourceUtilization)(_.expectedResourceUtilization(_))
        .ifSome(platformDifferences)(_.platformDifferences(_))
        .build

    def terminateRecommendationDetail(
      estimatedMonthlySavings: Option[String] = None,
      currencyCode: Option[String] = None
    ): TerminateRecommendationDetail =
      TerminateRecommendationDetail
        .builder
        .ifSome(estimatedMonthlySavings)(_.estimatedMonthlySavings(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .build

    def totalImpactFilter(
      numericOperator: Option[String] = None,
      startValue: Option[GenericDouble] = None,
      endValue: Option[GenericDouble] = None
    ): TotalImpactFilter =
      TotalImpactFilter
        .builder
        .ifSome(numericOperator)(_.numericOperator(_))
        .ifSome(startValue)(_.startValue(_))
        .ifSome(endValue)(_.endValue(_))
        .build

    def unknownMonitorException(
      message: Option[String] = None
    ): UnknownMonitorException =
      UnknownMonitorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unknownSubscriptionException(
      message: Option[String] = None
    ): UnknownSubscriptionException =
      UnknownSubscriptionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unresolvableUsageUnitException(
      message: Option[String] = None
    ): UnresolvableUsageUnitException =
      UnresolvableUsageUnitException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateAnomalyMonitorRequest(
      monitorArn: Option[String] = None,
      monitorName: Option[String] = None
    ): UpdateAnomalyMonitorRequest =
      UpdateAnomalyMonitorRequest
        .builder
        .ifSome(monitorArn)(_.monitorArn(_))
        .ifSome(monitorName)(_.monitorName(_))
        .build

    def updateAnomalyMonitorResponse(
      monitorArn: Option[String] = None
    ): UpdateAnomalyMonitorResponse =
      UpdateAnomalyMonitorResponse
        .builder
        .ifSome(monitorArn)(_.monitorArn(_))
        .build

    def updateAnomalySubscriptionRequest(
      subscriptionArn: Option[String] = None,
      threshold: Option[NullableNonNegativeDouble] = None,
      frequency: Option[String] = None,
      monitorArnList: Option[List[Arn]] = None,
      subscribers: Option[List[Subscriber]] = None,
      subscriptionName: Option[String] = None
    ): UpdateAnomalySubscriptionRequest =
      UpdateAnomalySubscriptionRequest
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(monitorArnList)(_.monitorArnList(_))
        .ifSome(subscribers)(_.subscribers(_))
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .build

    def updateAnomalySubscriptionResponse(
      subscriptionArn: Option[String] = None
    ): UpdateAnomalySubscriptionResponse =
      UpdateAnomalySubscriptionResponse
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def updateCostCategoryDefinitionRequest(
      costCategoryArn: Option[String] = None,
      ruleVersion: Option[String] = None,
      rules: Option[List[CostCategoryRule]] = None,
      defaultValue: Option[String] = None
    ): UpdateCostCategoryDefinitionRequest =
      UpdateCostCategoryDefinitionRequest
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(ruleVersion)(_.ruleVersion(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def updateCostCategoryDefinitionResponse(
      costCategoryArn: Option[String] = None,
      effectiveStart: Option[String] = None
    ): UpdateCostCategoryDefinitionResponse =
      UpdateCostCategoryDefinitionResponse
        .builder
        .ifSome(costCategoryArn)(_.costCategoryArn(_))
        .ifSome(effectiveStart)(_.effectiveStart(_))
        .build

    def utilizationByTime(
      timePeriod: Option[DateInterval] = None,
      groups: Option[List[ReservationUtilizationGroup]] = None,
      total: Option[ReservationAggregates] = None
    ): UtilizationByTime =
      UtilizationByTime
        .builder
        .ifSome(timePeriod)(_.timePeriod(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(total)(_.total(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
