package goober.hi

import goober.free.cloudhsm.CloudHsmIO
import software.amazon.awssdk.services.cloudhsm.model._


object cloudhsm {
  import goober.free.{cloudhsm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addTagsToResourceRequest(
      resourceArn: Option[String] = None,
      tagList: Option[List[Tag]] = None
    ): AddTagsToResourceRequest =
      AddTagsToResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagList)(_.tagList(_))
        .build

    def addTagsToResourceResponse(
      status: Option[String] = None
    ): AddTagsToResourceResponse =
      AddTagsToResourceResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def cloudHsmInternalException(

    ): CloudHsmInternalException =
      CloudHsmInternalException
        .builder

        .build

    def cloudHsmServiceException(
      message: Option[String] = None,
      retryable: Option[Boolean] = None
    ): CloudHsmServiceException =
      CloudHsmServiceException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryable)(_.retryable(_))
        .build

    def createHapgRequest(
      label: Option[String] = None
    ): CreateHapgRequest =
      CreateHapgRequest
        .builder
        .ifSome(label)(_.label(_))
        .build

    def createHapgResponse(
      hapgArn: Option[String] = None
    ): CreateHapgResponse =
      CreateHapgResponse
        .builder
        .ifSome(hapgArn)(_.hapgArn(_))
        .build

    def createHsmRequest(
      subnetId: Option[String] = None,
      sshKey: Option[String] = None,
      eniIp: Option[String] = None,
      iamRoleArn: Option[String] = None,
      externalId: Option[String] = None,
      subscriptionType: Option[String] = None,
      clientToken: Option[String] = None,
      syslogIp: Option[String] = None
    ): CreateHsmRequest =
      CreateHsmRequest
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(sshKey)(_.sshKey(_))
        .ifSome(eniIp)(_.eniIp(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(subscriptionType)(_.subscriptionType(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(syslogIp)(_.syslogIp(_))
        .build

    def createHsmResponse(
      hsmArn: Option[String] = None
    ): CreateHsmResponse =
      CreateHsmResponse
        .builder
        .ifSome(hsmArn)(_.hsmArn(_))
        .build

    def createLunaClientRequest(
      label: Option[String] = None,
      certificate: Option[String] = None
    ): CreateLunaClientRequest =
      CreateLunaClientRequest
        .builder
        .ifSome(label)(_.label(_))
        .ifSome(certificate)(_.certificate(_))
        .build

    def createLunaClientResponse(
      clientArn: Option[String] = None
    ): CreateLunaClientResponse =
      CreateLunaClientResponse
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .build

    def deleteHapgRequest(
      hapgArn: Option[String] = None
    ): DeleteHapgRequest =
      DeleteHapgRequest
        .builder
        .ifSome(hapgArn)(_.hapgArn(_))
        .build

    def deleteHapgResponse(
      status: Option[String] = None
    ): DeleteHapgResponse =
      DeleteHapgResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def deleteHsmRequest(
      hsmArn: Option[String] = None
    ): DeleteHsmRequest =
      DeleteHsmRequest
        .builder
        .ifSome(hsmArn)(_.hsmArn(_))
        .build

    def deleteHsmResponse(
      status: Option[String] = None
    ): DeleteHsmResponse =
      DeleteHsmResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def deleteLunaClientRequest(
      clientArn: Option[String] = None
    ): DeleteLunaClientRequest =
      DeleteLunaClientRequest
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .build

    def deleteLunaClientResponse(
      status: Option[String] = None
    ): DeleteLunaClientResponse =
      DeleteLunaClientResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def describeHapgRequest(
      hapgArn: Option[String] = None
    ): DescribeHapgRequest =
      DescribeHapgRequest
        .builder
        .ifSome(hapgArn)(_.hapgArn(_))
        .build

    def describeHapgResponse(
      hapgArn: Option[String] = None,
      hapgSerial: Option[String] = None,
      hsmsLastActionFailed: Option[List[HsmArn]] = None,
      hsmsPendingDeletion: Option[List[HsmArn]] = None,
      hsmsPendingRegistration: Option[List[HsmArn]] = None,
      label: Option[String] = None,
      lastModifiedTimestamp: Option[String] = None,
      partitionSerialList: Option[List[PartitionSerial]] = None,
      state: Option[String] = None
    ): DescribeHapgResponse =
      DescribeHapgResponse
        .builder
        .ifSome(hapgArn)(_.hapgArn(_))
        .ifSome(hapgSerial)(_.hapgSerial(_))
        .ifSome(hsmsLastActionFailed)(_.hsmsLastActionFailed(_))
        .ifSome(hsmsPendingDeletion)(_.hsmsPendingDeletion(_))
        .ifSome(hsmsPendingRegistration)(_.hsmsPendingRegistration(_))
        .ifSome(label)(_.label(_))
        .ifSome(lastModifiedTimestamp)(_.lastModifiedTimestamp(_))
        .ifSome(partitionSerialList)(_.partitionSerialList(_))
        .ifSome(state)(_.state(_))
        .build

    def describeHsmRequest(
      hsmArn: Option[String] = None,
      hsmSerialNumber: Option[String] = None
    ): DescribeHsmRequest =
      DescribeHsmRequest
        .builder
        .ifSome(hsmArn)(_.hsmArn(_))
        .ifSome(hsmSerialNumber)(_.hsmSerialNumber(_))
        .build

    def describeHsmResponse(
      hsmArn: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      availabilityZone: Option[String] = None,
      eniId: Option[String] = None,
      eniIp: Option[String] = None,
      subscriptionType: Option[String] = None,
      subscriptionStartDate: Option[String] = None,
      subscriptionEndDate: Option[String] = None,
      vpcId: Option[String] = None,
      subnetId: Option[String] = None,
      iamRoleArn: Option[String] = None,
      serialNumber: Option[String] = None,
      vendorName: Option[String] = None,
      hsmType: Option[String] = None,
      softwareVersion: Option[String] = None,
      sshPublicKey: Option[String] = None,
      sshKeyLastUpdated: Option[String] = None,
      serverCertUri: Option[String] = None,
      serverCertLastUpdated: Option[String] = None,
      partitions: Option[List[PartitionArn]] = None
    ): DescribeHsmResponse =
      DescribeHsmResponse
        .builder
        .ifSome(hsmArn)(_.hsmArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(eniId)(_.eniId(_))
        .ifSome(eniIp)(_.eniIp(_))
        .ifSome(subscriptionType)(_.subscriptionType(_))
        .ifSome(subscriptionStartDate)(_.subscriptionStartDate(_))
        .ifSome(subscriptionEndDate)(_.subscriptionEndDate(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(vendorName)(_.vendorName(_))
        .ifSome(hsmType)(_.hsmType(_))
        .ifSome(softwareVersion)(_.softwareVersion(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .ifSome(sshKeyLastUpdated)(_.sshKeyLastUpdated(_))
        .ifSome(serverCertUri)(_.serverCertUri(_))
        .ifSome(serverCertLastUpdated)(_.serverCertLastUpdated(_))
        .ifSome(partitions)(_.partitions(_))
        .build

    def describeLunaClientRequest(
      clientArn: Option[String] = None,
      certificateFingerprint: Option[String] = None
    ): DescribeLunaClientRequest =
      DescribeLunaClientRequest
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .ifSome(certificateFingerprint)(_.certificateFingerprint(_))
        .build

    def describeLunaClientResponse(
      clientArn: Option[String] = None,
      certificate: Option[String] = None,
      certificateFingerprint: Option[String] = None,
      lastModifiedTimestamp: Option[String] = None,
      label: Option[String] = None
    ): DescribeLunaClientResponse =
      DescribeLunaClientResponse
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(certificateFingerprint)(_.certificateFingerprint(_))
        .ifSome(lastModifiedTimestamp)(_.lastModifiedTimestamp(_))
        .ifSome(label)(_.label(_))
        .build

    def getConfigRequest(
      clientArn: Option[String] = None,
      clientVersion: Option[String] = None,
      hapgList: Option[List[HapgArn]] = None
    ): GetConfigRequest =
      GetConfigRequest
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .ifSome(clientVersion)(_.clientVersion(_))
        .ifSome(hapgList)(_.hapgList(_))
        .build

    def getConfigResponse(
      configType: Option[String] = None,
      configFile: Option[String] = None,
      configCred: Option[String] = None
    ): GetConfigResponse =
      GetConfigResponse
        .builder
        .ifSome(configType)(_.configType(_))
        .ifSome(configFile)(_.configFile(_))
        .ifSome(configCred)(_.configCred(_))
        .build

    def invalidRequestException(

    ): InvalidRequestException =
      InvalidRequestException
        .builder

        .build

    def listAvailableZonesRequest(

    ): ListAvailableZonesRequest =
      ListAvailableZonesRequest
        .builder

        .build

    def listAvailableZonesResponse(
      aZList: Option[List[AZ]] = None
    ): ListAvailableZonesResponse =
      ListAvailableZonesResponse
        .builder
        .ifSome(aZList)(_.aZList(_))
        .build

    def listHapgsRequest(
      nextToken: Option[String] = None
    ): ListHapgsRequest =
      ListHapgsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHapgsResponse(
      hapgList: Option[List[HapgArn]] = None,
      nextToken: Option[String] = None
    ): ListHapgsResponse =
      ListHapgsResponse
        .builder
        .ifSome(hapgList)(_.hapgList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHsmsRequest(
      nextToken: Option[String] = None
    ): ListHsmsRequest =
      ListHsmsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHsmsResponse(
      hsmList: Option[List[HsmArn]] = None,
      nextToken: Option[String] = None
    ): ListHsmsResponse =
      ListHsmsResponse
        .builder
        .ifSome(hsmList)(_.hsmList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLunaClientsRequest(
      nextToken: Option[String] = None
    ): ListLunaClientsRequest =
      ListLunaClientsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLunaClientsResponse(
      clientList: Option[List[ClientArn]] = None,
      nextToken: Option[String] = None
    ): ListLunaClientsResponse =
      ListLunaClientsResponse
        .builder
        .ifSome(clientList)(_.clientList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tagList: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def modifyHapgRequest(
      hapgArn: Option[String] = None,
      label: Option[String] = None,
      partitionSerialList: Option[List[PartitionSerial]] = None
    ): ModifyHapgRequest =
      ModifyHapgRequest
        .builder
        .ifSome(hapgArn)(_.hapgArn(_))
        .ifSome(label)(_.label(_))
        .ifSome(partitionSerialList)(_.partitionSerialList(_))
        .build

    def modifyHapgResponse(
      hapgArn: Option[String] = None
    ): ModifyHapgResponse =
      ModifyHapgResponse
        .builder
        .ifSome(hapgArn)(_.hapgArn(_))
        .build

    def modifyHsmRequest(
      hsmArn: Option[String] = None,
      subnetId: Option[String] = None,
      eniIp: Option[String] = None,
      iamRoleArn: Option[String] = None,
      externalId: Option[String] = None,
      syslogIp: Option[String] = None
    ): ModifyHsmRequest =
      ModifyHsmRequest
        .builder
        .ifSome(hsmArn)(_.hsmArn(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(eniIp)(_.eniIp(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(syslogIp)(_.syslogIp(_))
        .build

    def modifyHsmResponse(
      hsmArn: Option[String] = None
    ): ModifyHsmResponse =
      ModifyHsmResponse
        .builder
        .ifSome(hsmArn)(_.hsmArn(_))
        .build

    def modifyLunaClientRequest(
      clientArn: Option[String] = None,
      certificate: Option[String] = None
    ): ModifyLunaClientRequest =
      ModifyLunaClientRequest
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .ifSome(certificate)(_.certificate(_))
        .build

    def modifyLunaClientResponse(
      clientArn: Option[String] = None
    ): ModifyLunaClientResponse =
      ModifyLunaClientResponse
        .builder
        .ifSome(clientArn)(_.clientArn(_))
        .build

    def removeTagsFromResourceRequest(
      resourceArn: Option[String] = None,
      tagKeyList: Option[List[TagKey]] = None
    ): RemoveTagsFromResourceRequest =
      RemoveTagsFromResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeyList)(_.tagKeyList(_))
        .build

    def removeTagsFromResourceResponse(
      status: Option[String] = None
    ): RemoveTagsFromResourceResponse =
      RemoveTagsFromResourceResponse
        .builder
        .ifSome(status)(_.status(_))
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

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
