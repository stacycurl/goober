package goober.hi

import goober.free.servicediscovery.ServiceDiscoveryIO
import software.amazon.awssdk.services.servicediscovery.model._


object servicediscovery {
  import goober.free.{servicediscovery ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def createHttpNamespaceRequest(
      name: Option[String] = None,
      creatorRequestId: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateHttpNamespaceRequest =
      CreateHttpNamespaceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHttpNamespaceResponse(
      operationId: Option[String] = None
    ): CreateHttpNamespaceResponse =
      CreateHttpNamespaceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def createPrivateDnsNamespaceRequest(
      name: Option[String] = None,
      creatorRequestId: Option[String] = None,
      description: Option[String] = None,
      vpc: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePrivateDnsNamespaceRequest =
      CreatePrivateDnsNamespaceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpc)(_.vpc(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPrivateDnsNamespaceResponse(
      operationId: Option[String] = None
    ): CreatePrivateDnsNamespaceResponse =
      CreatePrivateDnsNamespaceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def createPublicDnsNamespaceRequest(
      name: Option[String] = None,
      creatorRequestId: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePublicDnsNamespaceRequest =
      CreatePublicDnsNamespaceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPublicDnsNamespaceResponse(
      operationId: Option[String] = None
    ): CreatePublicDnsNamespaceResponse =
      CreatePublicDnsNamespaceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def createServiceRequest(
      name: Option[String] = None,
      namespaceId: Option[String] = None,
      creatorRequestId: Option[String] = None,
      description: Option[String] = None,
      dnsConfig: Option[DnsConfig] = None,
      healthCheckConfig: Option[HealthCheckConfig] = None,
      healthCheckCustomConfig: Option[HealthCheckCustomConfig] = None,
      tags: Option[List[Tag]] = None,
      `type`: Option[String] = None
    ): CreateServiceRequest =
      CreateServiceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(description)(_.description(_))
        .ifSome(dnsConfig)(_.dnsConfig(_))
        .ifSome(healthCheckConfig)(_.healthCheckConfig(_))
        .ifSome(healthCheckCustomConfig)(_.healthCheckCustomConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createServiceResponse(
      service: Option[Service] = None
    ): CreateServiceResponse =
      CreateServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .build

    def customHealthNotFound(
      message: Option[String] = None
    ): CustomHealthNotFound =
      CustomHealthNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteNamespaceRequest(
      id: Option[String] = None
    ): DeleteNamespaceRequest =
      DeleteNamespaceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteNamespaceResponse(
      operationId: Option[String] = None
    ): DeleteNamespaceResponse =
      DeleteNamespaceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def deleteServiceRequest(
      id: Option[String] = None
    ): DeleteServiceRequest =
      DeleteServiceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteServiceResponse(

    ): DeleteServiceResponse =
      DeleteServiceResponse
        .builder

        .build

    def deregisterInstanceRequest(
      serviceId: Option[String] = None,
      instanceId: Option[String] = None
    ): DeregisterInstanceRequest =
      DeregisterInstanceRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def deregisterInstanceResponse(
      operationId: Option[String] = None
    ): DeregisterInstanceResponse =
      DeregisterInstanceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def discoverInstancesRequest(
      namespaceName: Option[String] = None,
      serviceName: Option[String] = None,
      maxResults: Option[Int] = None,
      queryParameters: Option[Attributes] = None,
      optionalParameters: Option[Attributes] = None,
      healthStatus: Option[String] = None
    ): DiscoverInstancesRequest =
      DiscoverInstancesRequest
        .builder
        .ifSome(namespaceName)(_.namespaceName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(queryParameters)(_.queryParameters(_))
        .ifSome(optionalParameters)(_.optionalParameters(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .build

    def discoverInstancesResponse(
      instances: Option[List[HttpInstanceSummary]] = None
    ): DiscoverInstancesResponse =
      DiscoverInstancesResponse
        .builder
        .ifSome(instances)(_.instances(_))
        .build

    def dnsConfig(
      namespaceId: Option[String] = None,
      routingPolicy: Option[String] = None,
      dnsRecords: Option[List[DnsRecord]] = None
    ): DnsConfig =
      DnsConfig
        .builder
        .ifSome(namespaceId)(_.namespaceId(_))
        .ifSome(routingPolicy)(_.routingPolicy(_))
        .ifSome(dnsRecords)(_.dnsRecords(_))
        .build

    def dnsConfigChange(
      dnsRecords: Option[List[DnsRecord]] = None
    ): DnsConfigChange =
      DnsConfigChange
        .builder
        .ifSome(dnsRecords)(_.dnsRecords(_))
        .build

    def dnsProperties(
      hostedZoneId: Option[String] = None
    ): DnsProperties =
      DnsProperties
        .builder
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def dnsRecord(
      `type`: Option[String] = None,
      tTL: Option[RecordTTL] = None
    ): DnsRecord =
      DnsRecord
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(tTL)(_.tTL(_))
        .build

    def duplicateRequest(
      message: Option[String] = None,
      duplicateOperationId: Option[String] = None
    ): DuplicateRequest =
      DuplicateRequest
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(duplicateOperationId)(_.duplicateOperationId(_))
        .build

    def getInstanceRequest(
      serviceId: Option[String] = None,
      instanceId: Option[String] = None
    ): GetInstanceRequest =
      GetInstanceRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def getInstanceResponse(
      instance: Option[Instance] = None
    ): GetInstanceResponse =
      GetInstanceResponse
        .builder
        .ifSome(instance)(_.instance(_))
        .build

    def getInstancesHealthStatusRequest(
      serviceId: Option[String] = None,
      instances: Option[List[ResourceId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetInstancesHealthStatusRequest =
      GetInstancesHealthStatusRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getInstancesHealthStatusResponse(
      status: Option[InstanceHealthStatusMap] = None,
      nextToken: Option[String] = None
    ): GetInstancesHealthStatusResponse =
      GetInstancesHealthStatusResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getNamespaceRequest(
      id: Option[String] = None
    ): GetNamespaceRequest =
      GetNamespaceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getNamespaceResponse(
      namespace: Option[Namespace] = None
    ): GetNamespaceResponse =
      GetNamespaceResponse
        .builder
        .ifSome(namespace)(_.namespace(_))
        .build

    def getOperationRequest(
      operationId: Option[String] = None
    ): GetOperationRequest =
      GetOperationRequest
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def getOperationResponse(
      operation: Option[Operation] = None
    ): GetOperationResponse =
      GetOperationResponse
        .builder
        .ifSome(operation)(_.operation(_))
        .build

    def getServiceRequest(
      id: Option[String] = None
    ): GetServiceRequest =
      GetServiceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getServiceResponse(
      service: Option[Service] = None
    ): GetServiceResponse =
      GetServiceResponse
        .builder
        .ifSome(service)(_.service(_))
        .build

    def healthCheckConfig(
      `type`: Option[String] = None,
      resourcePath: Option[String] = None,
      failureThreshold: Option[Int] = None
    ): HealthCheckConfig =
      HealthCheckConfig
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(resourcePath)(_.resourcePath(_))
        .ifSome(failureThreshold)(_.failureThreshold(_))
        .build

    def healthCheckCustomConfig(
      failureThreshold: Option[Int] = None
    ): HealthCheckCustomConfig =
      HealthCheckCustomConfig
        .builder
        .ifSome(failureThreshold)(_.failureThreshold(_))
        .build

    def httpInstanceSummary(
      instanceId: Option[String] = None,
      namespaceName: Option[String] = None,
      serviceName: Option[String] = None,
      healthStatus: Option[String] = None,
      attributes: Option[Attributes] = None
    ): HttpInstanceSummary =
      HttpInstanceSummary
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(namespaceName)(_.namespaceName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def httpProperties(
      httpName: Option[String] = None
    ): HttpProperties =
      HttpProperties
        .builder
        .ifSome(httpName)(_.httpName(_))
        .build

    def instance(
      id: Option[String] = None,
      creatorRequestId: Option[String] = None,
      attributes: Option[Attributes] = None
    ): Instance =
      Instance
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def instanceNotFound(
      message: Option[String] = None
    ): InstanceNotFound =
      InstanceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def instanceSummary(
      id: Option[String] = None,
      attributes: Option[Attributes] = None
    ): InstanceSummary =
      InstanceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def invalidInput(
      message: Option[String] = None
    ): InvalidInput =
      InvalidInput
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listInstancesRequest(
      serviceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInstancesRequest =
      ListInstancesRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listInstancesResponse(
      instances: Option[List[InstanceSummary]] = None,
      nextToken: Option[String] = None
    ): ListInstancesResponse =
      ListInstancesResponse
        .builder
        .ifSome(instances)(_.instances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNamespacesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[NamespaceFilter]] = None
    ): ListNamespacesRequest =
      ListNamespacesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listNamespacesResponse(
      namespaces: Option[List[NamespaceSummary]] = None,
      nextToken: Option[String] = None
    ): ListNamespacesResponse =
      ListNamespacesResponse
        .builder
        .ifSome(namespaces)(_.namespaces(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOperationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[OperationFilter]] = None
    ): ListOperationsRequest =
      ListOperationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listOperationsResponse(
      operations: Option[List[OperationSummary]] = None,
      nextToken: Option[String] = None
    ): ListOperationsResponse =
      ListOperationsResponse
        .builder
        .ifSome(operations)(_.operations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[ServiceFilter]] = None
    ): ListServicesRequest =
      ListServicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listServicesResponse(
      services: Option[List[ServiceSummary]] = None,
      nextToken: Option[String] = None
    ): ListServicesResponse =
      ListServicesResponse
        .builder
        .ifSome(services)(_.services(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def namespace(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      serviceCount: Option[Int] = None,
      properties: Option[NamespaceProperties] = None,
      createDate: Option[Timestamp] = None,
      creatorRequestId: Option[String] = None
    ): Namespace =
      Namespace
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(serviceCount)(_.serviceCount(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .build

    def namespaceAlreadyExists(
      message: Option[String] = None,
      creatorRequestId: Option[String] = None,
      namespaceId: Option[String] = None
    ): NamespaceAlreadyExists =
      NamespaceAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .build

    def namespaceFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      condition: Option[String] = None
    ): NamespaceFilter =
      NamespaceFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(condition)(_.condition(_))
        .build

    def namespaceNotFound(
      message: Option[String] = None
    ): NamespaceNotFound =
      NamespaceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def namespaceProperties(
      dnsProperties: Option[DnsProperties] = None,
      httpProperties: Option[HttpProperties] = None
    ): NamespaceProperties =
      NamespaceProperties
        .builder
        .ifSome(dnsProperties)(_.dnsProperties(_))
        .ifSome(httpProperties)(_.httpProperties(_))
        .build

    def namespaceSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      serviceCount: Option[Int] = None,
      properties: Option[NamespaceProperties] = None,
      createDate: Option[Timestamp] = None
    ): NamespaceSummary =
      NamespaceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(serviceCount)(_.serviceCount(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def operation(
      id: Option[String] = None,
      `type`: Option[String] = None,
      status: Option[String] = None,
      errorMessage: Option[String] = None,
      errorCode: Option[String] = None,
      createDate: Option[Timestamp] = None,
      updateDate: Option[Timestamp] = None,
      targets: Option[OperationTargetsMap] = None
    ): Operation =
      Operation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(targets)(_.targets(_))
        .build

    def operationFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      condition: Option[String] = None
    ): OperationFilter =
      OperationFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(condition)(_.condition(_))
        .build

    def operationNotFound(
      message: Option[String] = None
    ): OperationNotFound =
      OperationNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def operationSummary(
      id: Option[String] = None,
      status: Option[String] = None
    ): OperationSummary =
      OperationSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .build

    def registerInstanceRequest(
      serviceId: Option[String] = None,
      instanceId: Option[String] = None,
      creatorRequestId: Option[String] = None,
      attributes: Option[Attributes] = None
    ): RegisterInstanceRequest =
      RegisterInstanceRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def registerInstanceResponse(
      operationId: Option[String] = None
    ): RegisterInstanceResponse =
      RegisterInstanceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def requestLimitExceeded(
      message: Option[String] = None
    ): RequestLimitExceeded =
      RequestLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUse(
      message: Option[String] = None
    ): ResourceInUse =
      ResourceInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceeded(
      message: Option[String] = None
    ): ResourceLimitExceeded =
      ResourceLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def service(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      namespaceId: Option[String] = None,
      description: Option[String] = None,
      instanceCount: Option[Int] = None,
      dnsConfig: Option[DnsConfig] = None,
      `type`: Option[String] = None,
      healthCheckConfig: Option[HealthCheckConfig] = None,
      healthCheckCustomConfig: Option[HealthCheckCustomConfig] = None,
      createDate: Option[Timestamp] = None,
      creatorRequestId: Option[String] = None
    ): Service =
      Service
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(dnsConfig)(_.dnsConfig(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(healthCheckConfig)(_.healthCheckConfig(_))
        .ifSome(healthCheckCustomConfig)(_.healthCheckCustomConfig(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .build

    def serviceAlreadyExists(
      message: Option[String] = None,
      creatorRequestId: Option[String] = None,
      serviceId: Option[String] = None
    ): ServiceAlreadyExists =
      ServiceAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(serviceId)(_.serviceId(_))
        .build

    def serviceChange(
      description: Option[String] = None,
      dnsConfig: Option[DnsConfigChange] = None,
      healthCheckConfig: Option[HealthCheckConfig] = None
    ): ServiceChange =
      ServiceChange
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(dnsConfig)(_.dnsConfig(_))
        .ifSome(healthCheckConfig)(_.healthCheckConfig(_))
        .build

    def serviceFilter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None,
      condition: Option[String] = None
    ): ServiceFilter =
      ServiceFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .ifSome(condition)(_.condition(_))
        .build

    def serviceNotFound(
      message: Option[String] = None
    ): ServiceNotFound =
      ServiceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      instanceCount: Option[Int] = None,
      dnsConfig: Option[DnsConfig] = None,
      healthCheckConfig: Option[HealthCheckConfig] = None,
      healthCheckCustomConfig: Option[HealthCheckCustomConfig] = None,
      createDate: Option[Timestamp] = None
    ): ServiceSummary =
      ServiceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceCount)(_.instanceCount(_))
        .ifSome(dnsConfig)(_.dnsConfig(_))
        .ifSome(healthCheckConfig)(_.healthCheckConfig(_))
        .ifSome(healthCheckCustomConfig)(_.healthCheckCustomConfig(_))
        .ifSome(createDate)(_.createDate(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tooManyTagsException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateInstanceCustomHealthStatusRequest(
      serviceId: Option[String] = None,
      instanceId: Option[String] = None,
      status: Option[String] = None
    ): UpdateInstanceCustomHealthStatusRequest =
      UpdateInstanceCustomHealthStatusRequest
        .builder
        .ifSome(serviceId)(_.serviceId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateServiceRequest(
      id: Option[String] = None,
      service: Option[ServiceChange] = None
    ): UpdateServiceRequest =
      UpdateServiceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(service)(_.service(_))
        .build

    def updateServiceResponse(
      operationId: Option[String] = None
    ): UpdateServiceResponse =
      UpdateServiceResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
