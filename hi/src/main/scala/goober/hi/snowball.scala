package goober.hi

import goober.free.snowball.SnowballIO
import software.amazon.awssdk.services.snowball.model._


object snowball {
  import goober.free.{snowball ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def address(
      addressId: Option[String] = None,
      name: Option[String] = None,
      company: Option[String] = None,
      street1: Option[String] = None,
      street2: Option[String] = None,
      street3: Option[String] = None,
      city: Option[String] = None,
      stateOrProvince: Option[String] = None,
      prefectureOrDistrict: Option[String] = None,
      landmark: Option[String] = None,
      country: Option[String] = None,
      postalCode: Option[String] = None,
      phoneNumber: Option[String] = None,
      isRestricted: Option[Boolean] = None
    ): Address =
      Address
        .builder
        .ifSome(addressId)(_.addressId(_))
        .ifSome(name)(_.name(_))
        .ifSome(company)(_.company(_))
        .ifSome(street1)(_.street1(_))
        .ifSome(street2)(_.street2(_))
        .ifSome(street3)(_.street3(_))
        .ifSome(city)(_.city(_))
        .ifSome(stateOrProvince)(_.stateOrProvince(_))
        .ifSome(prefectureOrDistrict)(_.prefectureOrDistrict(_))
        .ifSome(landmark)(_.landmark(_))
        .ifSome(country)(_.country(_))
        .ifSome(postalCode)(_.postalCode(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(isRestricted)(_.isRestricted(_))
        .build

    def cancelClusterRequest(
      clusterId: Option[String] = None
    ): CancelClusterRequest =
      CancelClusterRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def cancelJobRequest(
      jobId: Option[String] = None
    ): CancelJobRequest =
      CancelJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def clusterLimitExceededException(
      message: Option[String] = None
    ): ClusterLimitExceededException =
      ClusterLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def clusterListEntry(
      clusterId: Option[String] = None,
      clusterState: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      description: Option[String] = None
    ): ClusterListEntry =
      ClusterListEntry
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(clusterState)(_.clusterState(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(description)(_.description(_))
        .build

    def clusterMetadata(
      clusterId: Option[String] = None,
      description: Option[String] = None,
      kmsKeyARN: Option[String] = None,
      roleARN: Option[String] = None,
      clusterState: Option[String] = None,
      jobType: Option[String] = None,
      snowballType: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      resources: Option[JobResource] = None,
      addressId: Option[String] = None,
      shippingOption: Option[String] = None,
      notification: Option[Notification] = None,
      forwardingAddressId: Option[String] = None,
      taxDocuments: Option[TaxDocuments] = None
    ): ClusterMetadata =
      ClusterMetadata
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyARN)(_.kmsKeyARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(clusterState)(_.clusterState(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(snowballType)(_.snowballType(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(addressId)(_.addressId(_))
        .ifSome(shippingOption)(_.shippingOption(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(forwardingAddressId)(_.forwardingAddressId(_))
        .ifSome(taxDocuments)(_.taxDocuments(_))
        .build

    def compatibleImage(
      amiId: Option[String] = None,
      name: Option[String] = None
    ): CompatibleImage =
      CompatibleImage
        .builder
        .ifSome(amiId)(_.amiId(_))
        .ifSome(name)(_.name(_))
        .build

    def conflictException(
      conflictResource: Option[String] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(conflictResource)(_.conflictResource(_))
        .ifSome(message)(_.message(_))
        .build

    def createAddressRequest(
      address: Option[Address] = None
    ): CreateAddressRequest =
      CreateAddressRequest
        .builder
        .ifSome(address)(_.address(_))
        .build

    def createClusterRequest(
      jobType: Option[String] = None,
      resources: Option[JobResource] = None,
      description: Option[String] = None,
      addressId: Option[String] = None,
      kmsKeyARN: Option[String] = None,
      roleARN: Option[String] = None,
      snowballType: Option[String] = None,
      shippingOption: Option[String] = None,
      notification: Option[Notification] = None,
      forwardingAddressId: Option[String] = None,
      taxDocuments: Option[TaxDocuments] = None
    ): CreateClusterRequest =
      CreateClusterRequest
        .builder
        .ifSome(jobType)(_.jobType(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(description)(_.description(_))
        .ifSome(addressId)(_.addressId(_))
        .ifSome(kmsKeyARN)(_.kmsKeyARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(snowballType)(_.snowballType(_))
        .ifSome(shippingOption)(_.shippingOption(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(forwardingAddressId)(_.forwardingAddressId(_))
        .ifSome(taxDocuments)(_.taxDocuments(_))
        .build

    def createJobRequest(
      jobType: Option[String] = None,
      resources: Option[JobResource] = None,
      description: Option[String] = None,
      addressId: Option[String] = None,
      kmsKeyARN: Option[String] = None,
      roleARN: Option[String] = None,
      snowballCapacityPreference: Option[String] = None,
      shippingOption: Option[String] = None,
      notification: Option[Notification] = None,
      clusterId: Option[String] = None,
      snowballType: Option[String] = None,
      forwardingAddressId: Option[String] = None,
      taxDocuments: Option[TaxDocuments] = None,
      deviceConfiguration: Option[DeviceConfiguration] = None,
      longTermPricingId: Option[String] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(jobType)(_.jobType(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(description)(_.description(_))
        .ifSome(addressId)(_.addressId(_))
        .ifSome(kmsKeyARN)(_.kmsKeyARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(snowballCapacityPreference)(_.snowballCapacityPreference(_))
        .ifSome(shippingOption)(_.shippingOption(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(snowballType)(_.snowballType(_))
        .ifSome(forwardingAddressId)(_.forwardingAddressId(_))
        .ifSome(taxDocuments)(_.taxDocuments(_))
        .ifSome(deviceConfiguration)(_.deviceConfiguration(_))
        .ifSome(longTermPricingId)(_.longTermPricingId(_))
        .build

    def createLongTermPricingRequest(
      longTermPricingType: Option[String] = None,
      isLongTermPricingAutoRenew: Option[Boolean] = None,
      snowballType: Option[String] = None
    ): CreateLongTermPricingRequest =
      CreateLongTermPricingRequest
        .builder
        .ifSome(longTermPricingType)(_.longTermPricingType(_))
        .ifSome(isLongTermPricingAutoRenew)(_.isLongTermPricingAutoRenew(_))
        .ifSome(snowballType)(_.snowballType(_))
        .build

    def createReturnShippingLabelRequest(
      jobId: Option[String] = None,
      shippingOption: Option[String] = None
    ): CreateReturnShippingLabelRequest =
      CreateReturnShippingLabelRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(shippingOption)(_.shippingOption(_))
        .build

    def dataTransfer(
      bytesTransferred: Option[Long] = None,
      objectsTransferred: Option[Long] = None,
      totalBytes: Option[Long] = None,
      totalObjects: Option[Long] = None
    ): DataTransfer =
      DataTransfer
        .builder
        .ifSome(bytesTransferred)(_.bytesTransferred(_))
        .ifSome(objectsTransferred)(_.objectsTransferred(_))
        .ifSome(totalBytes)(_.totalBytes(_))
        .ifSome(totalObjects)(_.totalObjects(_))
        .build

    def describeAddressRequest(
      addressId: Option[String] = None
    ): DescribeAddressRequest =
      DescribeAddressRequest
        .builder
        .ifSome(addressId)(_.addressId(_))
        .build

    def describeAddressesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAddressesRequest =
      DescribeAddressesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClusterRequest(
      clusterId: Option[String] = None
    ): DescribeClusterRequest =
      DescribeClusterRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def describeJobRequest(
      jobId: Option[String] = None
    ): DescribeJobRequest =
      DescribeJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeReturnShippingLabelRequest(
      jobId: Option[String] = None
    ): DescribeReturnShippingLabelRequest =
      DescribeReturnShippingLabelRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def deviceConfiguration(
      snowconeDeviceConfiguration: Option[SnowconeDeviceConfiguration] = None
    ): DeviceConfiguration =
      DeviceConfiguration
        .builder
        .ifSome(snowconeDeviceConfiguration)(_.snowconeDeviceConfiguration(_))
        .build

    def ec2AmiResource(
      amiId: Option[String] = None,
      snowballAmiId: Option[String] = None
    ): Ec2AmiResource =
      Ec2AmiResource
        .builder
        .ifSome(amiId)(_.amiId(_))
        .ifSome(snowballAmiId)(_.snowballAmiId(_))
        .build

    def ec2RequestFailedException(
      message: Option[String] = None
    ): Ec2RequestFailedException =
      Ec2RequestFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def eventTriggerDefinition(
      eventResourceARN: Option[String] = None
    ): EventTriggerDefinition =
      EventTriggerDefinition
        .builder
        .ifSome(eventResourceARN)(_.eventResourceARN(_))
        .build

    def getJobManifestRequest(
      jobId: Option[String] = None
    ): GetJobManifestRequest =
      GetJobManifestRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getJobUnlockCodeRequest(
      jobId: Option[String] = None
    ): GetJobUnlockCodeRequest =
      GetJobUnlockCodeRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getSnowballUsageRequest(

    ): GetSnowballUsageRequest =
      GetSnowballUsageRequest
        .builder

        .build

    def getSoftwareUpdatesRequest(
      jobId: Option[String] = None
    ): GetSoftwareUpdatesRequest =
      GetSoftwareUpdatesRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def iNDTaxDocuments(
      gSTIN: Option[String] = None
    ): INDTaxDocuments =
      INDTaxDocuments
        .builder
        .ifSome(gSTIN)(_.gSTIN(_))
        .build

    def invalidAddressException(
      message: Option[String] = None
    ): InvalidAddressException =
      InvalidAddressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputCombinationException(
      message: Option[String] = None
    ): InvalidInputCombinationException =
      InvalidInputCombinationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidJobStateException(
      message: Option[String] = None
    ): InvalidJobStateException =
      InvalidJobStateException
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

    def invalidResourceException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): InvalidResourceException =
      InvalidResourceException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def jobListEntry(
      jobId: Option[String] = None,
      jobState: Option[String] = None,
      isMaster: Option[Boolean] = None,
      jobType: Option[String] = None,
      snowballType: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      description: Option[String] = None
    ): JobListEntry =
      JobListEntry
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobState)(_.jobState(_))
        .ifSome(isMaster)(_.isMaster(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(snowballType)(_.snowballType(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(description)(_.description(_))
        .build

    def jobLogs(
      jobCompletionReportURI: Option[String] = None,
      jobSuccessLogURI: Option[String] = None,
      jobFailureLogURI: Option[String] = None
    ): JobLogs =
      JobLogs
        .builder
        .ifSome(jobCompletionReportURI)(_.jobCompletionReportURI(_))
        .ifSome(jobSuccessLogURI)(_.jobSuccessLogURI(_))
        .ifSome(jobFailureLogURI)(_.jobFailureLogURI(_))
        .build

    def jobMetadata(
      jobId: Option[String] = None,
      jobState: Option[String] = None,
      jobType: Option[String] = None,
      snowballType: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      resources: Option[JobResource] = None,
      description: Option[String] = None,
      kmsKeyARN: Option[String] = None,
      roleARN: Option[String] = None,
      addressId: Option[String] = None,
      shippingDetails: Option[ShippingDetails] = None,
      snowballCapacityPreference: Option[String] = None,
      notification: Option[Notification] = None,
      dataTransferProgress: Option[DataTransfer] = None,
      jobLogInfo: Option[JobLogs] = None,
      clusterId: Option[String] = None,
      forwardingAddressId: Option[String] = None,
      taxDocuments: Option[TaxDocuments] = None,
      deviceConfiguration: Option[DeviceConfiguration] = None,
      longTermPricingId: Option[String] = None
    ): JobMetadata =
      JobMetadata
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobState)(_.jobState(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(snowballType)(_.snowballType(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyARN)(_.kmsKeyARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(addressId)(_.addressId(_))
        .ifSome(shippingDetails)(_.shippingDetails(_))
        .ifSome(snowballCapacityPreference)(_.snowballCapacityPreference(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(dataTransferProgress)(_.dataTransferProgress(_))
        .ifSome(jobLogInfo)(_.jobLogInfo(_))
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(forwardingAddressId)(_.forwardingAddressId(_))
        .ifSome(taxDocuments)(_.taxDocuments(_))
        .ifSome(deviceConfiguration)(_.deviceConfiguration(_))
        .ifSome(longTermPricingId)(_.longTermPricingId(_))
        .build

    def jobResource(
      s3Resources: Option[List[S3Resource]] = None,
      lambdaResources: Option[List[LambdaResource]] = None,
      ec2AmiResources: Option[List[Ec2AmiResource]] = None
    ): JobResource =
      JobResource
        .builder
        .ifSome(s3Resources)(_.s3Resources(_))
        .ifSome(lambdaResources)(_.lambdaResources(_))
        .ifSome(ec2AmiResources)(_.ec2AmiResources(_))
        .build

    def kMSRequestFailedException(
      message: Option[String] = None
    ): KMSRequestFailedException =
      KMSRequestFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyRange(
      beginMarker: Option[String] = None,
      endMarker: Option[String] = None
    ): KeyRange =
      KeyRange
        .builder
        .ifSome(beginMarker)(_.beginMarker(_))
        .ifSome(endMarker)(_.endMarker(_))
        .build

    def lambdaResource(
      lambdaArn: Option[String] = None,
      eventTriggers: Option[List[EventTriggerDefinition]] = None
    ): LambdaResource =
      LambdaResource
        .builder
        .ifSome(lambdaArn)(_.lambdaArn(_))
        .ifSome(eventTriggers)(_.eventTriggers(_))
        .build

    def listClusterJobsRequest(
      clusterId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListClusterJobsRequest =
      ListClusterJobsRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClustersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListClustersRequest =
      ListClustersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCompatibleImagesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCompatibleImagesRequest =
      ListCompatibleImagesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLongTermPricingRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListLongTermPricingRequest =
      ListLongTermPricingRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def longTermPricingListEntry(
      longTermPricingId: Option[String] = None,
      longTermPricingEndDate: Option[Timestamp] = None,
      longTermPricingStartDate: Option[Timestamp] = None,
      longTermPricingType: Option[String] = None,
      currentActiveJob: Option[String] = None,
      replacementJob: Option[String] = None,
      isLongTermPricingAutoRenew: Option[Boolean] = None,
      longTermPricingStatus: Option[String] = None,
      snowballType: Option[String] = None,
      jobIds: Option[List[JobId]] = None
    ): LongTermPricingListEntry =
      LongTermPricingListEntry
        .builder
        .ifSome(longTermPricingId)(_.longTermPricingId(_))
        .ifSome(longTermPricingEndDate)(_.longTermPricingEndDate(_))
        .ifSome(longTermPricingStartDate)(_.longTermPricingStartDate(_))
        .ifSome(longTermPricingType)(_.longTermPricingType(_))
        .ifSome(currentActiveJob)(_.currentActiveJob(_))
        .ifSome(replacementJob)(_.replacementJob(_))
        .ifSome(isLongTermPricingAutoRenew)(_.isLongTermPricingAutoRenew(_))
        .ifSome(longTermPricingStatus)(_.longTermPricingStatus(_))
        .ifSome(snowballType)(_.snowballType(_))
        .ifSome(jobIds)(_.jobIds(_))
        .build

    def notification(
      snsTopicARN: Option[String] = None,
      jobStatesToNotify: Option[List[JobState]] = None,
      notifyAll: Option[Boolean] = None
    ): Notification =
      Notification
        .builder
        .ifSome(snsTopicARN)(_.snsTopicARN(_))
        .ifSome(jobStatesToNotify)(_.jobStatesToNotify(_))
        .ifSome(notifyAll)(_.notifyAll(_))
        .build

    def returnShippingLabelAlreadyExistsException(
      message: Option[String] = None
    ): ReturnShippingLabelAlreadyExistsException =
      ReturnShippingLabelAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3Resource(
      bucketArn: Option[String] = None,
      keyRange: Option[KeyRange] = None
    ): S3Resource =
      S3Resource
        .builder
        .ifSome(bucketArn)(_.bucketArn(_))
        .ifSome(keyRange)(_.keyRange(_))
        .build

    def shipment(
      status: Option[String] = None,
      trackingNumber: Option[String] = None
    ): Shipment =
      Shipment
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(trackingNumber)(_.trackingNumber(_))
        .build

    def shippingDetails(
      shippingOption: Option[String] = None,
      inboundShipment: Option[Shipment] = None,
      outboundShipment: Option[Shipment] = None
    ): ShippingDetails =
      ShippingDetails
        .builder
        .ifSome(shippingOption)(_.shippingOption(_))
        .ifSome(inboundShipment)(_.inboundShipment(_))
        .ifSome(outboundShipment)(_.outboundShipment(_))
        .build

    def snowconeDeviceConfiguration(
      wirelessConnection: Option[WirelessConnection] = None
    ): SnowconeDeviceConfiguration =
      SnowconeDeviceConfiguration
        .builder
        .ifSome(wirelessConnection)(_.wirelessConnection(_))
        .build

    def taxDocuments(
      iND: Option[INDTaxDocuments] = None
    ): TaxDocuments =
      TaxDocuments
        .builder
        .ifSome(iND)(_.iND(_))
        .build

    def unsupportedAddressException(
      message: Option[String] = None
    ): UnsupportedAddressException =
      UnsupportedAddressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateClusterRequest(
      clusterId: Option[String] = None,
      roleARN: Option[String] = None,
      description: Option[String] = None,
      resources: Option[JobResource] = None,
      addressId: Option[String] = None,
      shippingOption: Option[String] = None,
      notification: Option[Notification] = None,
      forwardingAddressId: Option[String] = None
    ): UpdateClusterRequest =
      UpdateClusterRequest
        .builder
        .ifSome(clusterId)(_.clusterId(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(description)(_.description(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(addressId)(_.addressId(_))
        .ifSome(shippingOption)(_.shippingOption(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(forwardingAddressId)(_.forwardingAddressId(_))
        .build

    def updateJobRequest(
      jobId: Option[String] = None,
      roleARN: Option[String] = None,
      notification: Option[Notification] = None,
      resources: Option[JobResource] = None,
      addressId: Option[String] = None,
      shippingOption: Option[String] = None,
      description: Option[String] = None,
      snowballCapacityPreference: Option[String] = None,
      forwardingAddressId: Option[String] = None
    ): UpdateJobRequest =
      UpdateJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(addressId)(_.addressId(_))
        .ifSome(shippingOption)(_.shippingOption(_))
        .ifSome(description)(_.description(_))
        .ifSome(snowballCapacityPreference)(_.snowballCapacityPreference(_))
        .ifSome(forwardingAddressId)(_.forwardingAddressId(_))
        .build

    def updateJobShipmentStateRequest(
      jobId: Option[String] = None,
      shipmentState: Option[String] = None
    ): UpdateJobShipmentStateRequest =
      UpdateJobShipmentStateRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(shipmentState)(_.shipmentState(_))
        .build

    def updateLongTermPricingRequest(
      longTermPricingId: Option[String] = None,
      replacementJob: Option[String] = None,
      isLongTermPricingAutoRenew: Option[Boolean] = None
    ): UpdateLongTermPricingRequest =
      UpdateLongTermPricingRequest
        .builder
        .ifSome(longTermPricingId)(_.longTermPricingId(_))
        .ifSome(replacementJob)(_.replacementJob(_))
        .ifSome(isLongTermPricingAutoRenew)(_.isLongTermPricingAutoRenew(_))
        .build

    def wirelessConnection(
      isWifiEnabled: Option[Boolean] = None
    ): WirelessConnection =
      WirelessConnection
        .builder
        .ifSome(isWifiEnabled)(_.isWifiEnabled(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
