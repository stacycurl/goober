package goober.hi

import goober.free.location.LocationIO
import software.amazon.awssdk.services.location.model._


object location {
  import goober.free.{location ⇒ free}

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

    def associateTrackerConsumerRequest(
      consumerArn: Option[String] = None,
      trackerName: Option[String] = None
    ): AssociateTrackerConsumerRequest =
      AssociateTrackerConsumerRequest
        .builder
        .ifSome(consumerArn)(_.consumerArn(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def associateTrackerConsumerResponse(

    ): AssociateTrackerConsumerResponse =
      AssociateTrackerConsumerResponse
        .builder

        .build

    def batchDeleteDevicePositionHistoryError(
      deviceId: Option[String] = None,
      error: Option[BatchItemError] = None
    ): BatchDeleteDevicePositionHistoryError =
      BatchDeleteDevicePositionHistoryError
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(error)(_.error(_))
        .build

    def batchDeleteDevicePositionHistoryRequest(
      deviceIds: Option[List[Id]] = None,
      trackerName: Option[String] = None
    ): BatchDeleteDevicePositionHistoryRequest =
      BatchDeleteDevicePositionHistoryRequest
        .builder
        .ifSome(deviceIds)(_.deviceIds(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def batchDeleteDevicePositionHistoryResponse(
      errors: Option[List[BatchDeleteDevicePositionHistoryError]] = None
    ): BatchDeleteDevicePositionHistoryResponse =
      BatchDeleteDevicePositionHistoryResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeleteGeofenceError(
      error: Option[BatchItemError] = None,
      geofenceId: Option[String] = None
    ): BatchDeleteGeofenceError =
      BatchDeleteGeofenceError
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .build

    def batchDeleteGeofenceRequest(
      collectionName: Option[String] = None,
      geofenceIds: Option[List[Id]] = None
    ): BatchDeleteGeofenceRequest =
      BatchDeleteGeofenceRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(geofenceIds)(_.geofenceIds(_))
        .build

    def batchDeleteGeofenceResponse(
      errors: Option[List[BatchDeleteGeofenceError]] = None
    ): BatchDeleteGeofenceResponse =
      BatchDeleteGeofenceResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchEvaluateGeofencesError(
      deviceId: Option[String] = None,
      error: Option[BatchItemError] = None,
      sampleTime: Option[Timestamp] = None
    ): BatchEvaluateGeofencesError =
      BatchEvaluateGeofencesError
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(error)(_.error(_))
        .ifSome(sampleTime)(_.sampleTime(_))
        .build

    def batchEvaluateGeofencesRequest(
      collectionName: Option[String] = None,
      devicePositionUpdates: Option[List[DevicePositionUpdate]] = None
    ): BatchEvaluateGeofencesRequest =
      BatchEvaluateGeofencesRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(devicePositionUpdates)(_.devicePositionUpdates(_))
        .build

    def batchEvaluateGeofencesResponse(
      errors: Option[List[BatchEvaluateGeofencesError]] = None
    ): BatchEvaluateGeofencesResponse =
      BatchEvaluateGeofencesResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchGetDevicePositionError(
      deviceId: Option[String] = None,
      error: Option[BatchItemError] = None
    ): BatchGetDevicePositionError =
      BatchGetDevicePositionError
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(error)(_.error(_))
        .build

    def batchGetDevicePositionRequest(
      deviceIds: Option[List[Id]] = None,
      trackerName: Option[String] = None
    ): BatchGetDevicePositionRequest =
      BatchGetDevicePositionRequest
        .builder
        .ifSome(deviceIds)(_.deviceIds(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def batchGetDevicePositionResponse(
      devicePositions: Option[List[DevicePosition]] = None,
      errors: Option[List[BatchGetDevicePositionError]] = None
    ): BatchGetDevicePositionResponse =
      BatchGetDevicePositionResponse
        .builder
        .ifSome(devicePositions)(_.devicePositions(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchItemError(
      code: Option[String] = None,
      message: Option[String] = None
    ): BatchItemError =
      BatchItemError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def batchPutGeofenceError(
      error: Option[BatchItemError] = None,
      geofenceId: Option[String] = None
    ): BatchPutGeofenceError =
      BatchPutGeofenceError
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .build

    def batchPutGeofenceRequest(
      collectionName: Option[String] = None,
      entries: Option[List[BatchPutGeofenceRequestEntry]] = None
    ): BatchPutGeofenceRequest =
      BatchPutGeofenceRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(entries)(_.entries(_))
        .build

    def batchPutGeofenceRequestEntry(
      geofenceId: Option[String] = None,
      geometry: Option[GeofenceGeometry] = None
    ): BatchPutGeofenceRequestEntry =
      BatchPutGeofenceRequestEntry
        .builder
        .ifSome(geofenceId)(_.geofenceId(_))
        .ifSome(geometry)(_.geometry(_))
        .build

    def batchPutGeofenceResponse(
      errors: Option[List[BatchPutGeofenceError]] = None,
      successes: Option[List[BatchPutGeofenceSuccess]] = None
    ): BatchPutGeofenceResponse =
      BatchPutGeofenceResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .ifSome(successes)(_.successes(_))
        .build

    def batchPutGeofenceSuccess(
      createTime: Option[Timestamp] = None,
      geofenceId: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): BatchPutGeofenceSuccess =
      BatchPutGeofenceSuccess
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def batchUpdateDevicePositionError(
      deviceId: Option[String] = None,
      error: Option[BatchItemError] = None,
      sampleTime: Option[Timestamp] = None
    ): BatchUpdateDevicePositionError =
      BatchUpdateDevicePositionError
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(error)(_.error(_))
        .ifSome(sampleTime)(_.sampleTime(_))
        .build

    def batchUpdateDevicePositionRequest(
      trackerName: Option[String] = None,
      updates: Option[List[DevicePositionUpdate]] = None
    ): BatchUpdateDevicePositionRequest =
      BatchUpdateDevicePositionRequest
        .builder
        .ifSome(trackerName)(_.trackerName(_))
        .ifSome(updates)(_.updates(_))
        .build

    def batchUpdateDevicePositionResponse(
      errors: Option[List[BatchUpdateDevicePositionError]] = None
    ): BatchUpdateDevicePositionResponse =
      BatchUpdateDevicePositionResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def calculateRouteCarModeOptions(
      avoidFerries: Option[Boolean] = None,
      avoidTolls: Option[Boolean] = None
    ): CalculateRouteCarModeOptions =
      CalculateRouteCarModeOptions
        .builder
        .ifSome(avoidFerries)(_.avoidFerries(_))
        .ifSome(avoidTolls)(_.avoidTolls(_))
        .build

    def calculateRouteRequest(
      calculatorName: Option[String] = None,
      carModeOptions: Option[CalculateRouteCarModeOptions] = None,
      departNow: Option[Boolean] = None,
      departurePosition: Option[List[Double]] = None,
      departureTime: Option[Timestamp] = None,
      destinationPosition: Option[List[Double]] = None,
      distanceUnit: Option[String] = None,
      includeLegGeometry: Option[Boolean] = None,
      travelMode: Option[String] = None,
      truckModeOptions: Option[CalculateRouteTruckModeOptions] = None,
      waypointPositions: Option[List[Position]] = None
    ): CalculateRouteRequest =
      CalculateRouteRequest
        .builder
        .ifSome(calculatorName)(_.calculatorName(_))
        .ifSome(carModeOptions)(_.carModeOptions(_))
        .ifSome(departNow)(_.departNow(_))
        .ifSome(departurePosition)(_.departurePosition(_))
        .ifSome(departureTime)(_.departureTime(_))
        .ifSome(destinationPosition)(_.destinationPosition(_))
        .ifSome(distanceUnit)(_.distanceUnit(_))
        .ifSome(includeLegGeometry)(_.includeLegGeometry(_))
        .ifSome(travelMode)(_.travelMode(_))
        .ifSome(truckModeOptions)(_.truckModeOptions(_))
        .ifSome(waypointPositions)(_.waypointPositions(_))
        .build

    def calculateRouteResponse(
      legs: Option[List[Leg]] = None,
      summary: Option[CalculateRouteSummary] = None
    ): CalculateRouteResponse =
      CalculateRouteResponse
        .builder
        .ifSome(legs)(_.legs(_))
        .ifSome(summary)(_.summary(_))
        .build

    def calculateRouteSummary(
      dataSource: Option[String] = None,
      distance: Option[CalculateRouteSummaryDistanceDouble] = None,
      distanceUnit: Option[String] = None,
      durationSeconds: Option[CalculateRouteSummaryDurationSecondsDouble] = None,
      routeBBox: Option[List[Double]] = None
    ): CalculateRouteSummary =
      CalculateRouteSummary
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(distance)(_.distance(_))
        .ifSome(distanceUnit)(_.distanceUnit(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(routeBBox)(_.routeBBox(_))
        .build

    def calculateRouteTruckModeOptions(
      avoidFerries: Option[Boolean] = None,
      avoidTolls: Option[Boolean] = None,
      dimensions: Option[TruckDimensions] = None,
      weight: Option[TruckWeight] = None
    ): CalculateRouteTruckModeOptions =
      CalculateRouteTruckModeOptions
        .builder
        .ifSome(avoidFerries)(_.avoidFerries(_))
        .ifSome(avoidTolls)(_.avoidTolls(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(weight)(_.weight(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createGeofenceCollectionRequest(
      collectionName: Option[String] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      pricingPlan: Option[String] = None,
      pricingPlanDataSource: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateGeofenceCollectionRequest =
      CreateGeofenceCollectionRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(pricingPlanDataSource)(_.pricingPlanDataSource(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGeofenceCollectionResponse(
      collectionArn: Option[String] = None,
      collectionName: Option[String] = None,
      createTime: Option[Timestamp] = None
    ): CreateGeofenceCollectionResponse =
      CreateGeofenceCollectionResponse
        .builder
        .ifSome(collectionArn)(_.collectionArn(_))
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(createTime)(_.createTime(_))
        .build

    def createMapRequest(
      configuration: Option[MapConfiguration] = None,
      description: Option[String] = None,
      mapName: Option[String] = None,
      pricingPlan: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateMapRequest =
      CreateMapRequest
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(mapName)(_.mapName(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMapResponse(
      createTime: Option[Timestamp] = None,
      mapArn: Option[String] = None,
      mapName: Option[String] = None
    ): CreateMapResponse =
      CreateMapResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(mapArn)(_.mapArn(_))
        .ifSome(mapName)(_.mapName(_))
        .build

    def createPlaceIndexRequest(
      dataSource: Option[String] = None,
      dataSourceConfiguration: Option[DataSourceConfiguration] = None,
      description: Option[String] = None,
      indexName: Option[String] = None,
      pricingPlan: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreatePlaceIndexRequest =
      CreatePlaceIndexRequest
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(dataSourceConfiguration)(_.dataSourceConfiguration(_))
        .ifSome(description)(_.description(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPlaceIndexResponse(
      createTime: Option[Timestamp] = None,
      indexArn: Option[String] = None,
      indexName: Option[String] = None
    ): CreatePlaceIndexResponse =
      CreatePlaceIndexResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(indexArn)(_.indexArn(_))
        .ifSome(indexName)(_.indexName(_))
        .build

    def createRouteCalculatorRequest(
      calculatorName: Option[String] = None,
      dataSource: Option[String] = None,
      description: Option[String] = None,
      pricingPlan: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateRouteCalculatorRequest =
      CreateRouteCalculatorRequest
        .builder
        .ifSome(calculatorName)(_.calculatorName(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(description)(_.description(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRouteCalculatorResponse(
      calculatorArn: Option[String] = None,
      calculatorName: Option[String] = None,
      createTime: Option[Timestamp] = None
    ): CreateRouteCalculatorResponse =
      CreateRouteCalculatorResponse
        .builder
        .ifSome(calculatorArn)(_.calculatorArn(_))
        .ifSome(calculatorName)(_.calculatorName(_))
        .ifSome(createTime)(_.createTime(_))
        .build

    def createTrackerRequest(
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      pricingPlan: Option[String] = None,
      pricingPlanDataSource: Option[String] = None,
      tags: Option[TagMap] = None,
      trackerName: Option[String] = None
    ): CreateTrackerRequest =
      CreateTrackerRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(pricingPlanDataSource)(_.pricingPlanDataSource(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def createTrackerResponse(
      createTime: Option[Timestamp] = None,
      trackerArn: Option[String] = None,
      trackerName: Option[String] = None
    ): CreateTrackerResponse =
      CreateTrackerResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(trackerArn)(_.trackerArn(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def dataSourceConfiguration(
      intendedUse: Option[String] = None
    ): DataSourceConfiguration =
      DataSourceConfiguration
        .builder
        .ifSome(intendedUse)(_.intendedUse(_))
        .build

    def deleteGeofenceCollectionRequest(
      collectionName: Option[String] = None
    ): DeleteGeofenceCollectionRequest =
      DeleteGeofenceCollectionRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .build

    def deleteGeofenceCollectionResponse(

    ): DeleteGeofenceCollectionResponse =
      DeleteGeofenceCollectionResponse
        .builder

        .build

    def deleteMapRequest(
      mapName: Option[String] = None
    ): DeleteMapRequest =
      DeleteMapRequest
        .builder
        .ifSome(mapName)(_.mapName(_))
        .build

    def deleteMapResponse(

    ): DeleteMapResponse =
      DeleteMapResponse
        .builder

        .build

    def deletePlaceIndexRequest(
      indexName: Option[String] = None
    ): DeletePlaceIndexRequest =
      DeletePlaceIndexRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .build

    def deletePlaceIndexResponse(

    ): DeletePlaceIndexResponse =
      DeletePlaceIndexResponse
        .builder

        .build

    def deleteRouteCalculatorRequest(
      calculatorName: Option[String] = None
    ): DeleteRouteCalculatorRequest =
      DeleteRouteCalculatorRequest
        .builder
        .ifSome(calculatorName)(_.calculatorName(_))
        .build

    def deleteRouteCalculatorResponse(

    ): DeleteRouteCalculatorResponse =
      DeleteRouteCalculatorResponse
        .builder

        .build

    def deleteTrackerRequest(
      trackerName: Option[String] = None
    ): DeleteTrackerRequest =
      DeleteTrackerRequest
        .builder
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def deleteTrackerResponse(

    ): DeleteTrackerResponse =
      DeleteTrackerResponse
        .builder

        .build

    def describeGeofenceCollectionRequest(
      collectionName: Option[String] = None
    ): DescribeGeofenceCollectionRequest =
      DescribeGeofenceCollectionRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .build

    def describeGeofenceCollectionResponse(
      collectionArn: Option[String] = None,
      collectionName: Option[String] = None,
      createTime: Option[Timestamp] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      pricingPlan: Option[String] = None,
      pricingPlanDataSource: Option[String] = None,
      tags: Option[TagMap] = None,
      updateTime: Option[Timestamp] = None
    ): DescribeGeofenceCollectionResponse =
      DescribeGeofenceCollectionResponse
        .builder
        .ifSome(collectionArn)(_.collectionArn(_))
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(pricingPlanDataSource)(_.pricingPlanDataSource(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def describeMapRequest(
      mapName: Option[String] = None
    ): DescribeMapRequest =
      DescribeMapRequest
        .builder
        .ifSome(mapName)(_.mapName(_))
        .build

    def describeMapResponse(
      configuration: Option[MapConfiguration] = None,
      createTime: Option[Timestamp] = None,
      dataSource: Option[String] = None,
      description: Option[String] = None,
      mapArn: Option[String] = None,
      mapName: Option[String] = None,
      pricingPlan: Option[String] = None,
      tags: Option[TagMap] = None,
      updateTime: Option[Timestamp] = None
    ): DescribeMapResponse =
      DescribeMapResponse
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(description)(_.description(_))
        .ifSome(mapArn)(_.mapArn(_))
        .ifSome(mapName)(_.mapName(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def describePlaceIndexRequest(
      indexName: Option[String] = None
    ): DescribePlaceIndexRequest =
      DescribePlaceIndexRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .build

    def describePlaceIndexResponse(
      createTime: Option[Timestamp] = None,
      dataSource: Option[String] = None,
      dataSourceConfiguration: Option[DataSourceConfiguration] = None,
      description: Option[String] = None,
      indexArn: Option[String] = None,
      indexName: Option[String] = None,
      pricingPlan: Option[String] = None,
      tags: Option[TagMap] = None,
      updateTime: Option[Timestamp] = None
    ): DescribePlaceIndexResponse =
      DescribePlaceIndexResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(dataSourceConfiguration)(_.dataSourceConfiguration(_))
        .ifSome(description)(_.description(_))
        .ifSome(indexArn)(_.indexArn(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def describeRouteCalculatorRequest(
      calculatorName: Option[String] = None
    ): DescribeRouteCalculatorRequest =
      DescribeRouteCalculatorRequest
        .builder
        .ifSome(calculatorName)(_.calculatorName(_))
        .build

    def describeRouteCalculatorResponse(
      calculatorArn: Option[String] = None,
      calculatorName: Option[String] = None,
      createTime: Option[Timestamp] = None,
      dataSource: Option[String] = None,
      description: Option[String] = None,
      pricingPlan: Option[String] = None,
      tags: Option[TagMap] = None,
      updateTime: Option[Timestamp] = None
    ): DescribeRouteCalculatorResponse =
      DescribeRouteCalculatorResponse
        .builder
        .ifSome(calculatorArn)(_.calculatorArn(_))
        .ifSome(calculatorName)(_.calculatorName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(description)(_.description(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def describeTrackerRequest(
      trackerName: Option[String] = None
    ): DescribeTrackerRequest =
      DescribeTrackerRequest
        .builder
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def describeTrackerResponse(
      createTime: Option[Timestamp] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      pricingPlan: Option[String] = None,
      pricingPlanDataSource: Option[String] = None,
      tags: Option[TagMap] = None,
      trackerArn: Option[String] = None,
      trackerName: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): DescribeTrackerResponse =
      DescribeTrackerResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(pricingPlanDataSource)(_.pricingPlanDataSource(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(trackerArn)(_.trackerArn(_))
        .ifSome(trackerName)(_.trackerName(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def devicePosition(
      deviceId: Option[String] = None,
      position: Option[List[Double]] = None,
      receivedTime: Option[Timestamp] = None,
      sampleTime: Option[Timestamp] = None
    ): DevicePosition =
      DevicePosition
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(position)(_.position(_))
        .ifSome(receivedTime)(_.receivedTime(_))
        .ifSome(sampleTime)(_.sampleTime(_))
        .build

    def devicePositionUpdate(
      deviceId: Option[String] = None,
      position: Option[List[Double]] = None,
      sampleTime: Option[Timestamp] = None
    ): DevicePositionUpdate =
      DevicePositionUpdate
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(position)(_.position(_))
        .ifSome(sampleTime)(_.sampleTime(_))
        .build

    def disassociateTrackerConsumerRequest(
      consumerArn: Option[String] = None,
      trackerName: Option[String] = None
    ): DisassociateTrackerConsumerRequest =
      DisassociateTrackerConsumerRequest
        .builder
        .ifSome(consumerArn)(_.consumerArn(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def disassociateTrackerConsumerResponse(

    ): DisassociateTrackerConsumerResponse =
      DisassociateTrackerConsumerResponse
        .builder

        .build

    def geofenceGeometry(
      polygon: Option[List[LinearRing]] = None
    ): GeofenceGeometry =
      GeofenceGeometry
        .builder
        .ifSome(polygon)(_.polygon(_))
        .build

    def getDevicePositionHistoryRequest(
      deviceId: Option[String] = None,
      endTimeExclusive: Option[Timestamp] = None,
      nextToken: Option[String] = None,
      startTimeInclusive: Option[Timestamp] = None,
      trackerName: Option[String] = None
    ): GetDevicePositionHistoryRequest =
      GetDevicePositionHistoryRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(endTimeExclusive)(_.endTimeExclusive(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTimeInclusive)(_.startTimeInclusive(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def getDevicePositionHistoryResponse(
      devicePositions: Option[List[DevicePosition]] = None,
      nextToken: Option[String] = None
    ): GetDevicePositionHistoryResponse =
      GetDevicePositionHistoryResponse
        .builder
        .ifSome(devicePositions)(_.devicePositions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDevicePositionRequest(
      deviceId: Option[String] = None,
      trackerName: Option[String] = None
    ): GetDevicePositionRequest =
      GetDevicePositionRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def getDevicePositionResponse(
      deviceId: Option[String] = None,
      position: Option[List[Double]] = None,
      receivedTime: Option[Timestamp] = None,
      sampleTime: Option[Timestamp] = None
    ): GetDevicePositionResponse =
      GetDevicePositionResponse
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(position)(_.position(_))
        .ifSome(receivedTime)(_.receivedTime(_))
        .ifSome(sampleTime)(_.sampleTime(_))
        .build

    def getGeofenceRequest(
      collectionName: Option[String] = None,
      geofenceId: Option[String] = None
    ): GetGeofenceRequest =
      GetGeofenceRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .build

    def getGeofenceResponse(
      createTime: Option[Timestamp] = None,
      geofenceId: Option[String] = None,
      geometry: Option[GeofenceGeometry] = None,
      status: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): GetGeofenceResponse =
      GetGeofenceResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .ifSome(geometry)(_.geometry(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def getMapGlyphsRequest(
      fontStack: Option[String] = None,
      fontUnicodeRange: Option[String] = None,
      mapName: Option[String] = None
    ): GetMapGlyphsRequest =
      GetMapGlyphsRequest
        .builder
        .ifSome(fontStack)(_.fontStack(_))
        .ifSome(fontUnicodeRange)(_.fontUnicodeRange(_))
        .ifSome(mapName)(_.mapName(_))
        .build

    def getMapGlyphsResponse(
      blob: Option[Blob] = None,
      contentType: Option[String] = None
    ): GetMapGlyphsResponse =
      GetMapGlyphsResponse
        .builder
        .ifSome(blob)(_.blob(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def getMapSpritesRequest(
      fileName: Option[String] = None,
      mapName: Option[String] = None
    ): GetMapSpritesRequest =
      GetMapSpritesRequest
        .builder
        .ifSome(fileName)(_.fileName(_))
        .ifSome(mapName)(_.mapName(_))
        .build

    def getMapSpritesResponse(
      blob: Option[Blob] = None,
      contentType: Option[String] = None
    ): GetMapSpritesResponse =
      GetMapSpritesResponse
        .builder
        .ifSome(blob)(_.blob(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def getMapStyleDescriptorRequest(
      mapName: Option[String] = None
    ): GetMapStyleDescriptorRequest =
      GetMapStyleDescriptorRequest
        .builder
        .ifSome(mapName)(_.mapName(_))
        .build

    def getMapStyleDescriptorResponse(
      blob: Option[Blob] = None,
      contentType: Option[String] = None
    ): GetMapStyleDescriptorResponse =
      GetMapStyleDescriptorResponse
        .builder
        .ifSome(blob)(_.blob(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def getMapTileRequest(
      mapName: Option[String] = None,
      x: Option[String] = None,
      y: Option[String] = None,
      z: Option[String] = None
    ): GetMapTileRequest =
      GetMapTileRequest
        .builder
        .ifSome(mapName)(_.mapName(_))
        .ifSome(x)(_.x(_))
        .ifSome(y)(_.y(_))
        .ifSome(z)(_.z(_))
        .build

    def getMapTileResponse(
      blob: Option[Blob] = None,
      contentType: Option[String] = None
    ): GetMapTileResponse =
      GetMapTileResponse
        .builder
        .ifSome(blob)(_.blob(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def leg(
      distance: Option[LegDistanceDouble] = None,
      durationSeconds: Option[LegDurationSecondsDouble] = None,
      endPosition: Option[List[Double]] = None,
      geometry: Option[LegGeometry] = None,
      startPosition: Option[List[Double]] = None,
      steps: Option[List[Step]] = None
    ): Leg =
      Leg
        .builder
        .ifSome(distance)(_.distance(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(endPosition)(_.endPosition(_))
        .ifSome(geometry)(_.geometry(_))
        .ifSome(startPosition)(_.startPosition(_))
        .ifSome(steps)(_.steps(_))
        .build

    def legGeometry(
      lineString: Option[List[Position]] = None
    ): LegGeometry =
      LegGeometry
        .builder
        .ifSome(lineString)(_.lineString(_))
        .build

    def listDevicePositionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      trackerName: Option[String] = None
    ): ListDevicePositionsRequest =
      ListDevicePositionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def listDevicePositionsResponse(
      entries: Option[List[ListDevicePositionsResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListDevicePositionsResponse =
      ListDevicePositionsResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevicePositionsResponseEntry(
      deviceId: Option[String] = None,
      position: Option[List[Double]] = None,
      sampleTime: Option[Timestamp] = None
    ): ListDevicePositionsResponseEntry =
      ListDevicePositionsResponseEntry
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(position)(_.position(_))
        .ifSome(sampleTime)(_.sampleTime(_))
        .build

    def listGeofenceCollectionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListGeofenceCollectionsRequest =
      ListGeofenceCollectionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGeofenceCollectionsResponse(
      entries: Option[List[ListGeofenceCollectionsResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListGeofenceCollectionsResponse =
      ListGeofenceCollectionsResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGeofenceCollectionsResponseEntry(
      collectionName: Option[String] = None,
      createTime: Option[Timestamp] = None,
      description: Option[String] = None,
      pricingPlan: Option[String] = None,
      pricingPlanDataSource: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): ListGeofenceCollectionsResponseEntry =
      ListGeofenceCollectionsResponseEntry
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(pricingPlanDataSource)(_.pricingPlanDataSource(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def listGeofenceResponseEntry(
      createTime: Option[Timestamp] = None,
      geofenceId: Option[String] = None,
      geometry: Option[GeofenceGeometry] = None,
      status: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): ListGeofenceResponseEntry =
      ListGeofenceResponseEntry
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .ifSome(geometry)(_.geometry(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def listGeofencesRequest(
      collectionName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListGeofencesRequest =
      ListGeofencesRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGeofencesResponse(
      entries: Option[List[ListGeofenceResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListGeofencesResponse =
      ListGeofencesResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMapsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMapsRequest =
      ListMapsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMapsResponse(
      entries: Option[List[ListMapsResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListMapsResponse =
      ListMapsResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMapsResponseEntry(
      createTime: Option[Timestamp] = None,
      dataSource: Option[String] = None,
      description: Option[String] = None,
      mapName: Option[String] = None,
      pricingPlan: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): ListMapsResponseEntry =
      ListMapsResponseEntry
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(description)(_.description(_))
        .ifSome(mapName)(_.mapName(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def listPlaceIndexesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPlaceIndexesRequest =
      ListPlaceIndexesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlaceIndexesResponse(
      entries: Option[List[ListPlaceIndexesResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListPlaceIndexesResponse =
      ListPlaceIndexesResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlaceIndexesResponseEntry(
      createTime: Option[Timestamp] = None,
      dataSource: Option[String] = None,
      description: Option[String] = None,
      indexName: Option[String] = None,
      pricingPlan: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): ListPlaceIndexesResponseEntry =
      ListPlaceIndexesResponseEntry
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(description)(_.description(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def listRouteCalculatorsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRouteCalculatorsRequest =
      ListRouteCalculatorsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRouteCalculatorsResponse(
      entries: Option[List[ListRouteCalculatorsResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListRouteCalculatorsResponse =
      ListRouteCalculatorsResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRouteCalculatorsResponseEntry(
      calculatorName: Option[String] = None,
      createTime: Option[Timestamp] = None,
      dataSource: Option[String] = None,
      description: Option[String] = None,
      pricingPlan: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): ListRouteCalculatorsResponseEntry =
      ListRouteCalculatorsResponseEntry
        .builder
        .ifSome(calculatorName)(_.calculatorName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(description)(_.description(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(updateTime)(_.updateTime(_))
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

    def listTrackerConsumersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      trackerName: Option[String] = None
    ): ListTrackerConsumersRequest =
      ListTrackerConsumersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(trackerName)(_.trackerName(_))
        .build

    def listTrackerConsumersResponse(
      consumerArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListTrackerConsumersResponse =
      ListTrackerConsumersResponse
        .builder
        .ifSome(consumerArns)(_.consumerArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrackersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTrackersRequest =
      ListTrackersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrackersResponse(
      entries: Option[List[ListTrackersResponseEntry]] = None,
      nextToken: Option[String] = None
    ): ListTrackersResponse =
      ListTrackersResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrackersResponseEntry(
      createTime: Option[Timestamp] = None,
      description: Option[String] = None,
      pricingPlan: Option[String] = None,
      pricingPlanDataSource: Option[String] = None,
      trackerName: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): ListTrackersResponseEntry =
      ListTrackersResponseEntry
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(pricingPlanDataSource)(_.pricingPlanDataSource(_))
        .ifSome(trackerName)(_.trackerName(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def mapConfiguration(
      style: Option[String] = None
    ): MapConfiguration =
      MapConfiguration
        .builder
        .ifSome(style)(_.style(_))
        .build

    def place(
      addressNumber: Option[String] = None,
      country: Option[String] = None,
      geometry: Option[PlaceGeometry] = None,
      label: Option[String] = None,
      municipality: Option[String] = None,
      neighborhood: Option[String] = None,
      postalCode: Option[String] = None,
      region: Option[String] = None,
      street: Option[String] = None,
      subRegion: Option[String] = None
    ): Place =
      Place
        .builder
        .ifSome(addressNumber)(_.addressNumber(_))
        .ifSome(country)(_.country(_))
        .ifSome(geometry)(_.geometry(_))
        .ifSome(label)(_.label(_))
        .ifSome(municipality)(_.municipality(_))
        .ifSome(neighborhood)(_.neighborhood(_))
        .ifSome(postalCode)(_.postalCode(_))
        .ifSome(region)(_.region(_))
        .ifSome(street)(_.street(_))
        .ifSome(subRegion)(_.subRegion(_))
        .build

    def placeGeometry(
      point: Option[List[Double]] = None
    ): PlaceGeometry =
      PlaceGeometry
        .builder
        .ifSome(point)(_.point(_))
        .build

    def putGeofenceRequest(
      collectionName: Option[String] = None,
      geofenceId: Option[String] = None,
      geometry: Option[GeofenceGeometry] = None
    ): PutGeofenceRequest =
      PutGeofenceRequest
        .builder
        .ifSome(collectionName)(_.collectionName(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .ifSome(geometry)(_.geometry(_))
        .build

    def putGeofenceResponse(
      createTime: Option[Timestamp] = None,
      geofenceId: Option[String] = None,
      updateTime: Option[Timestamp] = None
    ): PutGeofenceResponse =
      PutGeofenceResponse
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(geofenceId)(_.geofenceId(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def searchPlaceIndexForPositionRequest(
      indexName: Option[String] = None,
      maxResults: Option[Int] = None,
      position: Option[List[Double]] = None
    ): SearchPlaceIndexForPositionRequest =
      SearchPlaceIndexForPositionRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(position)(_.position(_))
        .build

    def searchPlaceIndexForPositionResponse(
      results: Option[List[SearchForPositionResult]] = None,
      summary: Option[SearchPlaceIndexForPositionSummary] = None
    ): SearchPlaceIndexForPositionResponse =
      SearchPlaceIndexForPositionResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(summary)(_.summary(_))
        .build

    def searchPlaceIndexForPositionSummary(
      dataSource: Option[String] = None,
      maxResults: Option[Int] = None,
      position: Option[List[Double]] = None
    ): SearchPlaceIndexForPositionSummary =
      SearchPlaceIndexForPositionSummary
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(position)(_.position(_))
        .build

    def searchPlaceIndexForTextRequest(
      biasPosition: Option[List[Double]] = None,
      filterBBox: Option[List[Double]] = None,
      filterCountries: Option[List[CountryCode]] = None,
      indexName: Option[String] = None,
      maxResults: Option[Int] = None,
      text: Option[String] = None
    ): SearchPlaceIndexForTextRequest =
      SearchPlaceIndexForTextRequest
        .builder
        .ifSome(biasPosition)(_.biasPosition(_))
        .ifSome(filterBBox)(_.filterBBox(_))
        .ifSome(filterCountries)(_.filterCountries(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(text)(_.text(_))
        .build

    def searchPlaceIndexForTextResponse(
      results: Option[List[SearchForTextResult]] = None,
      summary: Option[SearchPlaceIndexForTextSummary] = None
    ): SearchPlaceIndexForTextResponse =
      SearchPlaceIndexForTextResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(summary)(_.summary(_))
        .build

    def searchPlaceIndexForTextSummary(
      biasPosition: Option[List[Double]] = None,
      dataSource: Option[String] = None,
      filterBBox: Option[List[Double]] = None,
      filterCountries: Option[List[CountryCode]] = None,
      maxResults: Option[Int] = None,
      resultBBox: Option[List[Double]] = None,
      text: Option[String] = None
    ): SearchPlaceIndexForTextSummary =
      SearchPlaceIndexForTextSummary
        .builder
        .ifSome(biasPosition)(_.biasPosition(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(filterBBox)(_.filterBBox(_))
        .ifSome(filterCountries)(_.filterCountries(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resultBBox)(_.resultBBox(_))
        .ifSome(text)(_.text(_))
        .build

    def step(
      distance: Option[StepDistanceDouble] = None,
      durationSeconds: Option[StepDurationSecondsDouble] = None,
      endPosition: Option[List[Double]] = None,
      geometryOffset: Option[Int] = None,
      startPosition: Option[List[Double]] = None
    ): Step =
      Step
        .builder
        .ifSome(distance)(_.distance(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(endPosition)(_.endPosition(_))
        .ifSome(geometryOffset)(_.geometryOffset(_))
        .ifSome(startPosition)(_.startPosition(_))
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

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def truckDimensions(
      height: Option[TruckDimensionsHeightDouble] = None,
      length: Option[TruckDimensionsLengthDouble] = None,
      unit: Option[String] = None,
      width: Option[TruckDimensionsWidthDouble] = None
    ): TruckDimensions =
      TruckDimensions
        .builder
        .ifSome(height)(_.height(_))
        .ifSome(length)(_.length(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(width)(_.width(_))
        .build

    def truckWeight(
      total: Option[TruckWeightTotalDouble] = None,
      unit: Option[String] = None
    ): TruckWeight =
      TruckWeight
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(unit)(_.unit(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
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

    def validationException(
      fieldList: Option[List[ValidationExceptionField]] = None,
      message: Option[String] = None,
      reason: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(fieldList)(_.fieldList(_))
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def validationExceptionField(
      message: Option[String] = None,
      name: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(name)(_.name(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
