package goober.hi

import goober.free.schemas.SchemasIO
import software.amazon.awssdk.services.schemas.model._


object schemas {
  import goober.free.{schemas ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def badRequestException(
      code: Option[String] = None,
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def codeBindingOutput(
      creationDate: Option[__timestampIso8601] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaVersion: Option[String] = None,
      status: Option[String] = None
    ): CodeBindingOutput =
      CodeBindingOutput
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(status)(_.status(_))
        .build

    def conflictException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def createDiscovererInput(
      description: Option[String] = None,
      sourceArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateDiscovererInput =
      CreateDiscovererInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDiscovererRequest(
      description: Option[String] = None,
      sourceArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateDiscovererRequest =
      CreateDiscovererRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDiscovererResponse(
      description: Option[String] = None,
      discovererArn: Option[String] = None,
      discovererId: Option[String] = None,
      sourceArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateDiscovererResponse =
      CreateDiscovererResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(discovererArn)(_.discovererArn(_))
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRegistryInput(
      description: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateRegistryInput =
      CreateRegistryInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRegistryRequest(
      description: Option[String] = None,
      registryName: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateRegistryRequest =
      CreateRegistryRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRegistryResponse(
      description: Option[String] = None,
      registryArn: Option[String] = None,
      registryName: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateRegistryResponse =
      CreateRegistryResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSchemaInput(
      content: Option[String] = None,
      description: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None
    ): CreateSchemaInput =
      CreateSchemaInput
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createSchemaRequest(
      content: Option[String] = None,
      description: Option[String] = None,
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None
    ): CreateSchemaRequest =
      CreateSchemaRequest
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createSchemaResponse(
      description: Option[String] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      versionCreatedDate: Option[__timestampIso8601] = None
    ): CreateSchemaResponse =
      CreateSchemaResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(versionCreatedDate)(_.versionCreatedDate(_))
        .build

    def deleteDiscovererRequest(
      discovererId: Option[String] = None
    ): DeleteDiscovererRequest =
      DeleteDiscovererRequest
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .build

    def deleteRegistryRequest(
      registryName: Option[String] = None
    ): DeleteRegistryRequest =
      DeleteRegistryRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .build

    def deleteResourcePolicyRequest(
      registryName: Option[String] = None
    ): DeleteResourcePolicyRequest =
      DeleteResourcePolicyRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .build

    def deleteSchemaRequest(
      registryName: Option[String] = None,
      schemaName: Option[String] = None
    ): DeleteSchemaRequest =
      DeleteSchemaRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .build

    def deleteSchemaVersionRequest(
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None
    ): DeleteSchemaVersionRequest =
      DeleteSchemaVersionRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .build

    def describeCodeBindingRequest(
      language: Option[String] = None,
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None
    ): DescribeCodeBindingRequest =
      DescribeCodeBindingRequest
        .builder
        .ifSome(language)(_.language(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .build

    def describeCodeBindingResponse(
      creationDate: Option[__timestampIso8601] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaVersion: Option[String] = None,
      status: Option[String] = None
    ): DescribeCodeBindingResponse =
      DescribeCodeBindingResponse
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(status)(_.status(_))
        .build

    def describeDiscovererRequest(
      discovererId: Option[String] = None
    ): DescribeDiscovererRequest =
      DescribeDiscovererRequest
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .build

    def describeDiscovererResponse(
      description: Option[String] = None,
      discovererArn: Option[String] = None,
      discovererId: Option[String] = None,
      sourceArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): DescribeDiscovererResponse =
      DescribeDiscovererResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(discovererArn)(_.discovererArn(_))
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeRegistryRequest(
      registryName: Option[String] = None
    ): DescribeRegistryRequest =
      DescribeRegistryRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .build

    def describeRegistryResponse(
      description: Option[String] = None,
      registryArn: Option[String] = None,
      registryName: Option[String] = None,
      tags: Option[Tags] = None
    ): DescribeRegistryResponse =
      DescribeRegistryResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeSchemaOutput(
      content: Option[String] = None,
      description: Option[String] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      versionCreatedDate: Option[__timestampIso8601] = None
    ): DescribeSchemaOutput =
      DescribeSchemaOutput
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(versionCreatedDate)(_.versionCreatedDate(_))
        .build

    def describeSchemaRequest(
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None
    ): DescribeSchemaRequest =
      DescribeSchemaRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .build

    def describeSchemaResponse(
      content: Option[String] = None,
      description: Option[String] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      versionCreatedDate: Option[__timestampIso8601] = None
    ): DescribeSchemaResponse =
      DescribeSchemaResponse
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(versionCreatedDate)(_.versionCreatedDate(_))
        .build

    def discovererOutput(
      description: Option[String] = None,
      discovererArn: Option[String] = None,
      discovererId: Option[String] = None,
      sourceArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): DiscovererOutput =
      DiscovererOutput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(discovererArn)(_.discovererArn(_))
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def discovererStateOutput(
      discovererId: Option[String] = None,
      state: Option[String] = None
    ): DiscovererStateOutput =
      DiscovererStateOutput
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(state)(_.state(_))
        .build

    def discovererSummary(
      discovererArn: Option[String] = None,
      discovererId: Option[String] = None,
      sourceArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): DiscovererSummary =
      DiscovererSummary
        .builder
        .ifSome(discovererArn)(_.discovererArn(_))
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def errorOutput(
      code: Option[String] = None,
      message: Option[String] = None
    ): ErrorOutput =
      ErrorOutput
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def exportSchemaOutput(
      content: Option[String] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      `type`: Option[String] = None
    ): ExportSchemaOutput =
      ExportSchemaOutput
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def exportSchemaRequest(
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      `type`: Option[String] = None
    ): ExportSchemaRequest =
      ExportSchemaRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def exportSchemaResponse(
      content: Option[String] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      `type`: Option[String] = None
    ): ExportSchemaResponse =
      ExportSchemaResponse
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def forbiddenException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def getCodeBindingSourceRequest(
      language: Option[String] = None,
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None
    ): GetCodeBindingSourceRequest =
      GetCodeBindingSourceRequest
        .builder
        .ifSome(language)(_.language(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .build

    def getCodeBindingSourceResponse(
      body: Option[Body] = None
    ): GetCodeBindingSourceResponse =
      GetCodeBindingSourceResponse
        .builder
        .ifSome(body)(_.body(_))
        .build

    def getDiscoveredSchemaInput(
      events: Option[List[GetDiscoveredSchemaVersionItemInput]] = None,
      `type`: Option[String] = None
    ): GetDiscoveredSchemaInput =
      GetDiscoveredSchemaInput
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def getDiscoveredSchemaOutput(
      content: Option[String] = None
    ): GetDiscoveredSchemaOutput =
      GetDiscoveredSchemaOutput
        .builder
        .ifSome(content)(_.content(_))
        .build

    def getDiscoveredSchemaRequest(
      events: Option[List[GetDiscoveredSchemaVersionItemInput]] = None,
      `type`: Option[String] = None
    ): GetDiscoveredSchemaRequest =
      GetDiscoveredSchemaRequest
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def getDiscoveredSchemaResponse(
      content: Option[String] = None
    ): GetDiscoveredSchemaResponse =
      GetDiscoveredSchemaResponse
        .builder
        .ifSome(content)(_.content(_))
        .build

    def getResourcePolicyOutput(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): GetResourcePolicyOutput =
      GetResourcePolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getResourcePolicyRequest(
      registryName: Option[String] = None
    ): GetResourcePolicyRequest =
      GetResourcePolicyRequest
        .builder
        .ifSome(registryName)(_.registryName(_))
        .build

    def getResourcePolicyResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): GetResourcePolicyResponse =
      GetResourcePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def goneException(
      code: Option[String] = None,
      message: Option[String] = None
    ): GoneException =
      GoneException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def internalServerErrorException(
      code: Option[String] = None,
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def listDiscoverersOutput(
      discoverers: Option[List[DiscovererSummary]] = None,
      nextToken: Option[String] = None
    ): ListDiscoverersOutput =
      ListDiscoverersOutput
        .builder
        .ifSome(discoverers)(_.discoverers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDiscoverersRequest(
      discovererIdPrefix: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      sourceArnPrefix: Option[String] = None
    ): ListDiscoverersRequest =
      ListDiscoverersRequest
        .builder
        .ifSome(discovererIdPrefix)(_.discovererIdPrefix(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sourceArnPrefix)(_.sourceArnPrefix(_))
        .build

    def listDiscoverersResponse(
      discoverers: Option[List[DiscovererSummary]] = None,
      nextToken: Option[String] = None
    ): ListDiscoverersResponse =
      ListDiscoverersResponse
        .builder
        .ifSome(discoverers)(_.discoverers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRegistriesOutput(
      nextToken: Option[String] = None,
      registries: Option[List[RegistrySummary]] = None
    ): ListRegistriesOutput =
      ListRegistriesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(registries)(_.registries(_))
        .build

    def listRegistriesRequest(
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      registryNamePrefix: Option[String] = None,
      scope: Option[String] = None
    ): ListRegistriesRequest =
      ListRegistriesRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(registryNamePrefix)(_.registryNamePrefix(_))
        .ifSome(scope)(_.scope(_))
        .build

    def listRegistriesResponse(
      nextToken: Option[String] = None,
      registries: Option[List[RegistrySummary]] = None
    ): ListRegistriesResponse =
      ListRegistriesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(registries)(_.registries(_))
        .build

    def listSchemaVersionsOutput(
      nextToken: Option[String] = None,
      schemaVersions: Option[List[SchemaVersionSummary]] = None
    ): ListSchemaVersionsOutput =
      ListSchemaVersionsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemaVersions)(_.schemaVersions(_))
        .build

    def listSchemaVersionsRequest(
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      registryName: Option[String] = None,
      schemaName: Option[String] = None
    ): ListSchemaVersionsRequest =
      ListSchemaVersionsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .build

    def listSchemaVersionsResponse(
      nextToken: Option[String] = None,
      schemaVersions: Option[List[SchemaVersionSummary]] = None
    ): ListSchemaVersionsResponse =
      ListSchemaVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemaVersions)(_.schemaVersions(_))
        .build

    def listSchemasOutput(
      nextToken: Option[String] = None,
      schemas: Option[List[SchemaSummary]] = None
    ): ListSchemasOutput =
      ListSchemasOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemas)(_.schemas(_))
        .build

    def listSchemasRequest(
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      registryName: Option[String] = None,
      schemaNamePrefix: Option[String] = None
    ): ListSchemasRequest =
      ListSchemasRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaNamePrefix)(_.schemaNamePrefix(_))
        .build

    def listSchemasResponse(
      nextToken: Option[String] = None,
      schemas: Option[List[SchemaSummary]] = None
    ): ListSchemasResponse =
      ListSchemasResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemas)(_.schemas(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[Tags] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[Tags] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def lockServiceLinkedRoleInput(
      roleArn: Option[String] = None,
      timeout: Option[Int] = None
    ): LockServiceLinkedRoleInput =
      LockServiceLinkedRoleInput
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def lockServiceLinkedRoleOutput(
      canBeDeleted: Option[Boolean] = None,
      reasonOfFailure: Option[String] = None,
      relatedResources: Option[List[DiscovererSummary]] = None
    ): LockServiceLinkedRoleOutput =
      LockServiceLinkedRoleOutput
        .builder
        .ifSome(canBeDeleted)(_.canBeDeleted(_))
        .ifSome(reasonOfFailure)(_.reasonOfFailure(_))
        .ifSome(relatedResources)(_.relatedResources(_))
        .build

    def lockServiceLinkedRoleRequest(
      roleArn: Option[String] = None,
      timeout: Option[Int] = None
    ): LockServiceLinkedRoleRequest =
      LockServiceLinkedRoleRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def lockServiceLinkedRoleResponse(
      canBeDeleted: Option[Boolean] = None,
      reasonOfFailure: Option[String] = None,
      relatedResources: Option[List[DiscovererSummary]] = None
    ): LockServiceLinkedRoleResponse =
      LockServiceLinkedRoleResponse
        .builder
        .ifSome(canBeDeleted)(_.canBeDeleted(_))
        .ifSome(reasonOfFailure)(_.reasonOfFailure(_))
        .ifSome(relatedResources)(_.relatedResources(_))
        .build

    def notFoundException(
      code: Option[String] = None,
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def preconditionFailedException(
      code: Option[String] = None,
      message: Option[String] = None
    ): PreconditionFailedException =
      PreconditionFailedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def putCodeBindingRequest(
      language: Option[String] = None,
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None
    ): PutCodeBindingRequest =
      PutCodeBindingRequest
        .builder
        .ifSome(language)(_.language(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .build

    def putCodeBindingResponse(
      creationDate: Option[__timestampIso8601] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaVersion: Option[String] = None,
      status: Option[String] = None
    ): PutCodeBindingResponse =
      PutCodeBindingResponse
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(status)(_.status(_))
        .build

    def putResourcePolicyInput(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): PutResourcePolicyInput =
      PutResourcePolicyInput
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def putResourcePolicyOutput(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): PutResourcePolicyOutput =
      PutResourcePolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def putResourcePolicyRequest(
      policy: Option[String] = None,
      registryName: Option[String] = None,
      revisionId: Option[String] = None
    ): PutResourcePolicyRequest =
      PutResourcePolicyRequest
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def putResourcePolicyResponse(
      policy: Option[String] = None,
      revisionId: Option[String] = None
    ): PutResourcePolicyResponse =
      PutResourcePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def registryOutput(
      description: Option[String] = None,
      registryArn: Option[String] = None,
      registryName: Option[String] = None,
      tags: Option[Tags] = None
    ): RegistryOutput =
      RegistryOutput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def registrySummary(
      registryArn: Option[String] = None,
      registryName: Option[String] = None,
      tags: Option[Tags] = None
    ): RegistrySummary =
      RegistrySummary
        .builder
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def schemaOutput(
      description: Option[String] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      versionCreatedDate: Option[__timestampIso8601] = None
    ): SchemaOutput =
      SchemaOutput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(versionCreatedDate)(_.versionCreatedDate(_))
        .build

    def schemaSummary(
      lastModified: Option[__timestampIso8601] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      tags: Option[Tags] = None,
      versionCount: Option[__long] = None
    ): SchemaSummary =
      SchemaSummary
        .builder
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(versionCount)(_.versionCount(_))
        .build

    def schemaVersionSummary(
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      `type`: Option[String] = None
    ): SchemaVersionSummary =
      SchemaVersionSummary
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def searchSchemaSummary(
      registryName: Option[String] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersions: Option[List[SearchSchemaVersionSummary]] = None
    ): SearchSchemaSummary =
      SearchSchemaSummary
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersions)(_.schemaVersions(_))
        .build

    def searchSchemaVersionSummary(
      createdDate: Option[__timestampIso8601] = None,
      schemaVersion: Option[String] = None,
      `type`: Option[String] = None
    ): SearchSchemaVersionSummary =
      SearchSchemaVersionSummary
        .builder
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def searchSchemasOutput(
      nextToken: Option[String] = None,
      schemas: Option[List[SearchSchemaSummary]] = None
    ): SearchSchemasOutput =
      SearchSchemasOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemas)(_.schemas(_))
        .build

    def searchSchemasRequest(
      keywords: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      registryName: Option[String] = None
    ): SearchSchemasRequest =
      SearchSchemasRequest
        .builder
        .ifSome(keywords)(_.keywords(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(registryName)(_.registryName(_))
        .build

    def searchSchemasResponse(
      nextToken: Option[String] = None,
      schemas: Option[List[SearchSchemaSummary]] = None
    ): SearchSchemasResponse =
      SearchSchemasResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemas)(_.schemas(_))
        .build

    def serviceUnavailableException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def startDiscovererRequest(
      discovererId: Option[String] = None
    ): StartDiscovererRequest =
      StartDiscovererRequest
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .build

    def startDiscovererResponse(
      discovererId: Option[String] = None,
      state: Option[String] = None
    ): StartDiscovererResponse =
      StartDiscovererResponse
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(state)(_.state(_))
        .build

    def stopDiscovererRequest(
      discovererId: Option[String] = None
    ): StopDiscovererRequest =
      StopDiscovererRequest
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .build

    def stopDiscovererResponse(
      discovererId: Option[String] = None,
      state: Option[String] = None
    ): StopDiscovererResponse =
      StopDiscovererResponse
        .builder
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(state)(_.state(_))
        .build

    def tagResourceInput(
      tags: Option[Tags] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyRequestsException(
      code: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      code: Option[String] = None,
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def unlockServiceLinkedRoleInput(
      roleArn: Option[String] = None
    ): UnlockServiceLinkedRoleInput =
      UnlockServiceLinkedRoleInput
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def unlockServiceLinkedRoleRequest(
      roleArn: Option[String] = None
    ): UnlockServiceLinkedRoleRequest =
      UnlockServiceLinkedRoleRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def unlockServiceLinkedRoleResponse(

    ): UnlockServiceLinkedRoleResponse =
      UnlockServiceLinkedRoleResponse
        .builder

        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateDiscovererInput(
      description: Option[String] = None
    ): UpdateDiscovererInput =
      UpdateDiscovererInput
        .builder
        .ifSome(description)(_.description(_))
        .build

    def updateDiscovererRequest(
      description: Option[String] = None,
      discovererId: Option[String] = None
    ): UpdateDiscovererRequest =
      UpdateDiscovererRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(discovererId)(_.discovererId(_))
        .build

    def updateDiscovererResponse(
      description: Option[String] = None,
      discovererArn: Option[String] = None,
      discovererId: Option[String] = None,
      sourceArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): UpdateDiscovererResponse =
      UpdateDiscovererResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(discovererArn)(_.discovererArn(_))
        .ifSome(discovererId)(_.discovererId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateRegistryInput(
      description: Option[String] = None
    ): UpdateRegistryInput =
      UpdateRegistryInput
        .builder
        .ifSome(description)(_.description(_))
        .build

    def updateRegistryRequest(
      description: Option[String] = None,
      registryName: Option[String] = None
    ): UpdateRegistryRequest =
      UpdateRegistryRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(registryName)(_.registryName(_))
        .build

    def updateRegistryResponse(
      description: Option[String] = None,
      registryArn: Option[String] = None,
      registryName: Option[String] = None,
      tags: Option[Tags] = None
    ): UpdateRegistryResponse =
      UpdateRegistryResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateSchemaInput(
      clientTokenId: Option[String] = None,
      content: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None
    ): UpdateSchemaInput =
      UpdateSchemaInput
        .builder
        .ifSome(clientTokenId)(_.clientTokenId(_))
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def updateSchemaRequest(
      clientTokenId: Option[String] = None,
      content: Option[String] = None,
      description: Option[String] = None,
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      `type`: Option[String] = None
    ): UpdateSchemaRequest =
      UpdateSchemaRequest
        .builder
        .ifSome(clientTokenId)(_.clientTokenId(_))
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def updateSchemaResponse(
      description: Option[String] = None,
      lastModified: Option[__timestampIso8601] = None,
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaVersion: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      versionCreatedDate: Option[__timestampIso8601] = None
    ): UpdateSchemaResponse =
      UpdateSchemaResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(versionCreatedDate)(_.versionCreatedDate(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
