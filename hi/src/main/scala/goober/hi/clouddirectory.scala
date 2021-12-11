package goober.hi

import goober.free.clouddirectory.CloudDirectoryIO
import software.amazon.awssdk.services.clouddirectory.model._


object clouddirectory {
  import goober.free.{clouddirectory ⇒ free}

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

    def addFacetToObjectRequest(
      directoryArn: Option[String] = None,
      schemaFacet: Option[SchemaFacet] = None,
      objectAttributeList: Option[List[AttributeKeyAndValue]] = None,
      objectReference: Option[ObjectReference] = None
    ): AddFacetToObjectRequest =
      AddFacetToObjectRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(objectAttributeList)(_.objectAttributeList(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def addFacetToObjectResponse(

    ): AddFacetToObjectResponse =
      AddFacetToObjectResponse
        .builder

        .build

    def applySchemaRequest(
      publishedSchemaArn: Option[String] = None,
      directoryArn: Option[String] = None
    ): ApplySchemaRequest =
      ApplySchemaRequest
        .builder
        .ifSome(publishedSchemaArn)(_.publishedSchemaArn(_))
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def applySchemaResponse(
      appliedSchemaArn: Option[String] = None,
      directoryArn: Option[String] = None
    ): ApplySchemaResponse =
      ApplySchemaResponse
        .builder
        .ifSome(appliedSchemaArn)(_.appliedSchemaArn(_))
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def attachObjectRequest(
      directoryArn: Option[String] = None,
      parentReference: Option[ObjectReference] = None,
      childReference: Option[ObjectReference] = None,
      linkName: Option[String] = None
    ): AttachObjectRequest =
      AttachObjectRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(childReference)(_.childReference(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def attachObjectResponse(
      attachedObjectIdentifier: Option[String] = None
    ): AttachObjectResponse =
      AttachObjectResponse
        .builder
        .ifSome(attachedObjectIdentifier)(_.attachedObjectIdentifier(_))
        .build

    def attachPolicyRequest(
      directoryArn: Option[String] = None,
      policyReference: Option[ObjectReference] = None,
      objectReference: Option[ObjectReference] = None
    ): AttachPolicyRequest =
      AttachPolicyRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(policyReference)(_.policyReference(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def attachPolicyResponse(

    ): AttachPolicyResponse =
      AttachPolicyResponse
        .builder

        .build

    def attachToIndexRequest(
      directoryArn: Option[String] = None,
      indexReference: Option[ObjectReference] = None,
      targetReference: Option[ObjectReference] = None
    ): AttachToIndexRequest =
      AttachToIndexRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(indexReference)(_.indexReference(_))
        .ifSome(targetReference)(_.targetReference(_))
        .build

    def attachToIndexResponse(
      attachedObjectIdentifier: Option[String] = None
    ): AttachToIndexResponse =
      AttachToIndexResponse
        .builder
        .ifSome(attachedObjectIdentifier)(_.attachedObjectIdentifier(_))
        .build

    def attachTypedLinkRequest(
      directoryArn: Option[String] = None,
      sourceObjectReference: Option[ObjectReference] = None,
      targetObjectReference: Option[ObjectReference] = None,
      typedLinkFacet: Option[TypedLinkSchemaAndFacetName] = None,
      attributes: Option[List[AttributeNameAndValue]] = None
    ): AttachTypedLinkRequest =
      AttachTypedLinkRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(sourceObjectReference)(_.sourceObjectReference(_))
        .ifSome(targetObjectReference)(_.targetObjectReference(_))
        .ifSome(typedLinkFacet)(_.typedLinkFacet(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def attachTypedLinkResponse(
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None
    ): AttachTypedLinkResponse =
      AttachTypedLinkResponse
        .builder
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .build

    def attributeKey(
      schemaArn: Option[String] = None,
      facetName: Option[String] = None,
      name: Option[String] = None
    ): AttributeKey =
      AttributeKey
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(facetName)(_.facetName(_))
        .ifSome(name)(_.name(_))
        .build

    def attributeKeyAndValue(
      key: Option[AttributeKey] = None,
      value: Option[TypedAttributeValue] = None
    ): AttributeKeyAndValue =
      AttributeKeyAndValue
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def attributeNameAndValue(
      attributeName: Option[String] = None,
      value: Option[TypedAttributeValue] = None
    ): AttributeNameAndValue =
      AttributeNameAndValue
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(value)(_.value(_))
        .build

    def batchAddFacetToObject(
      schemaFacet: Option[SchemaFacet] = None,
      objectAttributeList: Option[List[AttributeKeyAndValue]] = None,
      objectReference: Option[ObjectReference] = None
    ): BatchAddFacetToObject =
      BatchAddFacetToObject
        .builder
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(objectAttributeList)(_.objectAttributeList(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def batchAddFacetToObjectResponse(

    ): BatchAddFacetToObjectResponse =
      BatchAddFacetToObjectResponse
        .builder

        .build

    def batchAttachObject(
      parentReference: Option[ObjectReference] = None,
      childReference: Option[ObjectReference] = None,
      linkName: Option[String] = None
    ): BatchAttachObject =
      BatchAttachObject
        .builder
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(childReference)(_.childReference(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def batchAttachObjectResponse(
      attachedObjectIdentifier: Option[String] = None
    ): BatchAttachObjectResponse =
      BatchAttachObjectResponse
        .builder
        .ifSome(attachedObjectIdentifier)(_.attachedObjectIdentifier(_))
        .build

    def batchAttachPolicy(
      policyReference: Option[ObjectReference] = None,
      objectReference: Option[ObjectReference] = None
    ): BatchAttachPolicy =
      BatchAttachPolicy
        .builder
        .ifSome(policyReference)(_.policyReference(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def batchAttachPolicyResponse(

    ): BatchAttachPolicyResponse =
      BatchAttachPolicyResponse
        .builder

        .build

    def batchAttachToIndex(
      indexReference: Option[ObjectReference] = None,
      targetReference: Option[ObjectReference] = None
    ): BatchAttachToIndex =
      BatchAttachToIndex
        .builder
        .ifSome(indexReference)(_.indexReference(_))
        .ifSome(targetReference)(_.targetReference(_))
        .build

    def batchAttachToIndexResponse(
      attachedObjectIdentifier: Option[String] = None
    ): BatchAttachToIndexResponse =
      BatchAttachToIndexResponse
        .builder
        .ifSome(attachedObjectIdentifier)(_.attachedObjectIdentifier(_))
        .build

    def batchAttachTypedLink(
      sourceObjectReference: Option[ObjectReference] = None,
      targetObjectReference: Option[ObjectReference] = None,
      typedLinkFacet: Option[TypedLinkSchemaAndFacetName] = None,
      attributes: Option[List[AttributeNameAndValue]] = None
    ): BatchAttachTypedLink =
      BatchAttachTypedLink
        .builder
        .ifSome(sourceObjectReference)(_.sourceObjectReference(_))
        .ifSome(targetObjectReference)(_.targetObjectReference(_))
        .ifSome(typedLinkFacet)(_.typedLinkFacet(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def batchAttachTypedLinkResponse(
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None
    ): BatchAttachTypedLinkResponse =
      BatchAttachTypedLinkResponse
        .builder
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .build

    def batchCreateIndex(
      orderedIndexedAttributeList: Option[List[AttributeKey]] = None,
      isUnique: Option[Boolean] = None,
      parentReference: Option[ObjectReference] = None,
      linkName: Option[String] = None,
      batchReferenceName: Option[String] = None
    ): BatchCreateIndex =
      BatchCreateIndex
        .builder
        .ifSome(orderedIndexedAttributeList)(_.orderedIndexedAttributeList(_))
        .ifSome(isUnique)(_.isUnique(_))
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(linkName)(_.linkName(_))
        .ifSome(batchReferenceName)(_.batchReferenceName(_))
        .build

    def batchCreateIndexResponse(
      objectIdentifier: Option[String] = None
    ): BatchCreateIndexResponse =
      BatchCreateIndexResponse
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def batchCreateObject(
      schemaFacet: Option[List[SchemaFacet]] = None,
      objectAttributeList: Option[List[AttributeKeyAndValue]] = None,
      parentReference: Option[ObjectReference] = None,
      linkName: Option[String] = None,
      batchReferenceName: Option[String] = None
    ): BatchCreateObject =
      BatchCreateObject
        .builder
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(objectAttributeList)(_.objectAttributeList(_))
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(linkName)(_.linkName(_))
        .ifSome(batchReferenceName)(_.batchReferenceName(_))
        .build

    def batchCreateObjectResponse(
      objectIdentifier: Option[String] = None
    ): BatchCreateObjectResponse =
      BatchCreateObjectResponse
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def batchDeleteObject(
      objectReference: Option[ObjectReference] = None
    ): BatchDeleteObject =
      BatchDeleteObject
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def batchDeleteObjectResponse(

    ): BatchDeleteObjectResponse =
      BatchDeleteObjectResponse
        .builder

        .build

    def batchDetachFromIndex(
      indexReference: Option[ObjectReference] = None,
      targetReference: Option[ObjectReference] = None
    ): BatchDetachFromIndex =
      BatchDetachFromIndex
        .builder
        .ifSome(indexReference)(_.indexReference(_))
        .ifSome(targetReference)(_.targetReference(_))
        .build

    def batchDetachFromIndexResponse(
      detachedObjectIdentifier: Option[String] = None
    ): BatchDetachFromIndexResponse =
      BatchDetachFromIndexResponse
        .builder
        .ifSome(detachedObjectIdentifier)(_.detachedObjectIdentifier(_))
        .build

    def batchDetachObject(
      parentReference: Option[ObjectReference] = None,
      linkName: Option[String] = None,
      batchReferenceName: Option[String] = None
    ): BatchDetachObject =
      BatchDetachObject
        .builder
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(linkName)(_.linkName(_))
        .ifSome(batchReferenceName)(_.batchReferenceName(_))
        .build

    def batchDetachObjectResponse(
      detachedObjectIdentifier: Option[String] = None
    ): BatchDetachObjectResponse =
      BatchDetachObjectResponse
        .builder
        .ifSome(detachedObjectIdentifier)(_.detachedObjectIdentifier(_))
        .build

    def batchDetachPolicy(
      policyReference: Option[ObjectReference] = None,
      objectReference: Option[ObjectReference] = None
    ): BatchDetachPolicy =
      BatchDetachPolicy
        .builder
        .ifSome(policyReference)(_.policyReference(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def batchDetachPolicyResponse(

    ): BatchDetachPolicyResponse =
      BatchDetachPolicyResponse
        .builder

        .build

    def batchDetachTypedLink(
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None
    ): BatchDetachTypedLink =
      BatchDetachTypedLink
        .builder
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .build

    def batchDetachTypedLinkResponse(

    ): BatchDetachTypedLinkResponse =
      BatchDetachTypedLinkResponse
        .builder

        .build

    def batchGetLinkAttributes(
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None,
      attributeNames: Option[List[AttributeName]] = None
    ): BatchGetLinkAttributes =
      BatchGetLinkAttributes
        .builder
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def batchGetLinkAttributesResponse(
      attributes: Option[List[AttributeKeyAndValue]] = None
    ): BatchGetLinkAttributesResponse =
      BatchGetLinkAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def batchGetObjectAttributes(
      objectReference: Option[ObjectReference] = None,
      schemaFacet: Option[SchemaFacet] = None,
      attributeNames: Option[List[AttributeName]] = None
    ): BatchGetObjectAttributes =
      BatchGetObjectAttributes
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def batchGetObjectAttributesResponse(
      attributes: Option[List[AttributeKeyAndValue]] = None
    ): BatchGetObjectAttributesResponse =
      BatchGetObjectAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def batchGetObjectInformation(
      objectReference: Option[ObjectReference] = None
    ): BatchGetObjectInformation =
      BatchGetObjectInformation
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def batchGetObjectInformationResponse(
      schemaFacets: Option[List[SchemaFacet]] = None,
      objectIdentifier: Option[String] = None
    ): BatchGetObjectInformationResponse =
      BatchGetObjectInformationResponse
        .builder
        .ifSome(schemaFacets)(_.schemaFacets(_))
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def batchListAttachedIndices(
      targetReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListAttachedIndices =
      BatchListAttachedIndices
        .builder
        .ifSome(targetReference)(_.targetReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListAttachedIndicesResponse(
      indexAttachments: Option[List[IndexAttachment]] = None,
      nextToken: Option[String] = None
    ): BatchListAttachedIndicesResponse =
      BatchListAttachedIndicesResponse
        .builder
        .ifSome(indexAttachments)(_.indexAttachments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListIncomingTypedLinks(
      objectReference: Option[ObjectReference] = None,
      filterAttributeRanges: Option[List[TypedLinkAttributeRange]] = None,
      filterTypedLink: Option[TypedLinkSchemaAndFacetName] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListIncomingTypedLinks =
      BatchListIncomingTypedLinks
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(filterAttributeRanges)(_.filterAttributeRanges(_))
        .ifSome(filterTypedLink)(_.filterTypedLink(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListIncomingTypedLinksResponse(
      linkSpecifiers: Option[List[TypedLinkSpecifier]] = None,
      nextToken: Option[String] = None
    ): BatchListIncomingTypedLinksResponse =
      BatchListIncomingTypedLinksResponse
        .builder
        .ifSome(linkSpecifiers)(_.linkSpecifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListIndex(
      rangesOnIndexedValues: Option[List[ObjectAttributeRange]] = None,
      indexReference: Option[ObjectReference] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): BatchListIndex =
      BatchListIndex
        .builder
        .ifSome(rangesOnIndexedValues)(_.rangesOnIndexedValues(_))
        .ifSome(indexReference)(_.indexReference(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListIndexResponse(
      indexAttachments: Option[List[IndexAttachment]] = None,
      nextToken: Option[String] = None
    ): BatchListIndexResponse =
      BatchListIndexResponse
        .builder
        .ifSome(indexAttachments)(_.indexAttachments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListObjectAttributes(
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      facetFilter: Option[SchemaFacet] = None
    ): BatchListObjectAttributes =
      BatchListObjectAttributes
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(facetFilter)(_.facetFilter(_))
        .build

    def batchListObjectAttributesResponse(
      attributes: Option[List[AttributeKeyAndValue]] = None,
      nextToken: Option[String] = None
    ): BatchListObjectAttributesResponse =
      BatchListObjectAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListObjectChildren(
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListObjectChildren =
      BatchListObjectChildren
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListObjectChildrenResponse(
      children: Option[LinkNameToObjectIdentifierMap] = None,
      nextToken: Option[String] = None
    ): BatchListObjectChildrenResponse =
      BatchListObjectChildrenResponse
        .builder
        .ifSome(children)(_.children(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListObjectParentPaths(
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListObjectParentPaths =
      BatchListObjectParentPaths
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListObjectParentPathsResponse(
      pathToObjectIdentifiersList: Option[List[PathToObjectIdentifiers]] = None,
      nextToken: Option[String] = None
    ): BatchListObjectParentPathsResponse =
      BatchListObjectParentPathsResponse
        .builder
        .ifSome(pathToObjectIdentifiersList)(_.pathToObjectIdentifiersList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListObjectParents(
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListObjectParents =
      BatchListObjectParents
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListObjectParentsResponse(
      parentLinks: Option[List[ObjectIdentifierAndLinkNameTuple]] = None,
      nextToken: Option[String] = None
    ): BatchListObjectParentsResponse =
      BatchListObjectParentsResponse
        .builder
        .ifSome(parentLinks)(_.parentLinks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListObjectPolicies(
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListObjectPolicies =
      BatchListObjectPolicies
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListObjectPoliciesResponse(
      attachedPolicyIds: Option[List[ObjectIdentifier]] = None,
      nextToken: Option[String] = None
    ): BatchListObjectPoliciesResponse =
      BatchListObjectPoliciesResponse
        .builder
        .ifSome(attachedPolicyIds)(_.attachedPolicyIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListOutgoingTypedLinks(
      objectReference: Option[ObjectReference] = None,
      filterAttributeRanges: Option[List[TypedLinkAttributeRange]] = None,
      filterTypedLink: Option[TypedLinkSchemaAndFacetName] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListOutgoingTypedLinks =
      BatchListOutgoingTypedLinks
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(filterAttributeRanges)(_.filterAttributeRanges(_))
        .ifSome(filterTypedLink)(_.filterTypedLink(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListOutgoingTypedLinksResponse(
      typedLinkSpecifiers: Option[List[TypedLinkSpecifier]] = None,
      nextToken: Option[String] = None
    ): BatchListOutgoingTypedLinksResponse =
      BatchListOutgoingTypedLinksResponse
        .builder
        .ifSome(typedLinkSpecifiers)(_.typedLinkSpecifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchListPolicyAttachments(
      policyReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchListPolicyAttachments =
      BatchListPolicyAttachments
        .builder
        .ifSome(policyReference)(_.policyReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchListPolicyAttachmentsResponse(
      objectIdentifiers: Option[List[ObjectIdentifier]] = None,
      nextToken: Option[String] = None
    ): BatchListPolicyAttachmentsResponse =
      BatchListPolicyAttachmentsResponse
        .builder
        .ifSome(objectIdentifiers)(_.objectIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchLookupPolicy(
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): BatchLookupPolicy =
      BatchLookupPolicy
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def batchLookupPolicyResponse(
      policyToPathList: Option[List[PolicyToPath]] = None,
      nextToken: Option[String] = None
    ): BatchLookupPolicyResponse =
      BatchLookupPolicyResponse
        .builder
        .ifSome(policyToPathList)(_.policyToPathList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchReadException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): BatchReadException =
      BatchReadException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def batchReadOperation(
      listObjectAttributes: Option[BatchListObjectAttributes] = None,
      listObjectChildren: Option[BatchListObjectChildren] = None,
      listAttachedIndices: Option[BatchListAttachedIndices] = None,
      listObjectParentPaths: Option[BatchListObjectParentPaths] = None,
      getObjectInformation: Option[BatchGetObjectInformation] = None,
      getObjectAttributes: Option[BatchGetObjectAttributes] = None,
      listObjectParents: Option[BatchListObjectParents] = None,
      listObjectPolicies: Option[BatchListObjectPolicies] = None,
      listPolicyAttachments: Option[BatchListPolicyAttachments] = None,
      lookupPolicy: Option[BatchLookupPolicy] = None,
      listIndex: Option[BatchListIndex] = None,
      listOutgoingTypedLinks: Option[BatchListOutgoingTypedLinks] = None,
      listIncomingTypedLinks: Option[BatchListIncomingTypedLinks] = None,
      getLinkAttributes: Option[BatchGetLinkAttributes] = None
    ): BatchReadOperation =
      BatchReadOperation
        .builder
        .ifSome(listObjectAttributes)(_.listObjectAttributes(_))
        .ifSome(listObjectChildren)(_.listObjectChildren(_))
        .ifSome(listAttachedIndices)(_.listAttachedIndices(_))
        .ifSome(listObjectParentPaths)(_.listObjectParentPaths(_))
        .ifSome(getObjectInformation)(_.getObjectInformation(_))
        .ifSome(getObjectAttributes)(_.getObjectAttributes(_))
        .ifSome(listObjectParents)(_.listObjectParents(_))
        .ifSome(listObjectPolicies)(_.listObjectPolicies(_))
        .ifSome(listPolicyAttachments)(_.listPolicyAttachments(_))
        .ifSome(lookupPolicy)(_.lookupPolicy(_))
        .ifSome(listIndex)(_.listIndex(_))
        .ifSome(listOutgoingTypedLinks)(_.listOutgoingTypedLinks(_))
        .ifSome(listIncomingTypedLinks)(_.listIncomingTypedLinks(_))
        .ifSome(getLinkAttributes)(_.getLinkAttributes(_))
        .build

    def batchReadOperationResponse(
      successfulResponse: Option[BatchReadSuccessfulResponse] = None,
      exceptionResponse: Option[BatchReadException] = None
    ): BatchReadOperationResponse =
      BatchReadOperationResponse
        .builder
        .ifSome(successfulResponse)(_.successfulResponse(_))
        .ifSome(exceptionResponse)(_.exceptionResponse(_))
        .build

    def batchReadRequest(
      directoryArn: Option[String] = None,
      operations: Option[List[BatchReadOperation]] = None,
      consistencyLevel: Option[String] = None
    ): BatchReadRequest =
      BatchReadRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(operations)(_.operations(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def batchReadResponse(
      responses: Option[List[BatchReadOperationResponse]] = None
    ): BatchReadResponse =
      BatchReadResponse
        .builder
        .ifSome(responses)(_.responses(_))
        .build

    def batchReadSuccessfulResponse(
      listObjectAttributes: Option[BatchListObjectAttributesResponse] = None,
      listObjectChildren: Option[BatchListObjectChildrenResponse] = None,
      getObjectInformation: Option[BatchGetObjectInformationResponse] = None,
      getObjectAttributes: Option[BatchGetObjectAttributesResponse] = None,
      listAttachedIndices: Option[BatchListAttachedIndicesResponse] = None,
      listObjectParentPaths: Option[BatchListObjectParentPathsResponse] = None,
      listObjectPolicies: Option[BatchListObjectPoliciesResponse] = None,
      listPolicyAttachments: Option[BatchListPolicyAttachmentsResponse] = None,
      lookupPolicy: Option[BatchLookupPolicyResponse] = None,
      listIndex: Option[BatchListIndexResponse] = None,
      listOutgoingTypedLinks: Option[BatchListOutgoingTypedLinksResponse] = None,
      listIncomingTypedLinks: Option[BatchListIncomingTypedLinksResponse] = None,
      getLinkAttributes: Option[BatchGetLinkAttributesResponse] = None,
      listObjectParents: Option[BatchListObjectParentsResponse] = None
    ): BatchReadSuccessfulResponse =
      BatchReadSuccessfulResponse
        .builder
        .ifSome(listObjectAttributes)(_.listObjectAttributes(_))
        .ifSome(listObjectChildren)(_.listObjectChildren(_))
        .ifSome(getObjectInformation)(_.getObjectInformation(_))
        .ifSome(getObjectAttributes)(_.getObjectAttributes(_))
        .ifSome(listAttachedIndices)(_.listAttachedIndices(_))
        .ifSome(listObjectParentPaths)(_.listObjectParentPaths(_))
        .ifSome(listObjectPolicies)(_.listObjectPolicies(_))
        .ifSome(listPolicyAttachments)(_.listPolicyAttachments(_))
        .ifSome(lookupPolicy)(_.lookupPolicy(_))
        .ifSome(listIndex)(_.listIndex(_))
        .ifSome(listOutgoingTypedLinks)(_.listOutgoingTypedLinks(_))
        .ifSome(listIncomingTypedLinks)(_.listIncomingTypedLinks(_))
        .ifSome(getLinkAttributes)(_.getLinkAttributes(_))
        .ifSome(listObjectParents)(_.listObjectParents(_))
        .build

    def batchRemoveFacetFromObject(
      schemaFacet: Option[SchemaFacet] = None,
      objectReference: Option[ObjectReference] = None
    ): BatchRemoveFacetFromObject =
      BatchRemoveFacetFromObject
        .builder
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def batchRemoveFacetFromObjectResponse(

    ): BatchRemoveFacetFromObjectResponse =
      BatchRemoveFacetFromObjectResponse
        .builder

        .build

    def batchUpdateLinkAttributes(
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None,
      attributeUpdates: Option[List[LinkAttributeUpdate]] = None
    ): BatchUpdateLinkAttributes =
      BatchUpdateLinkAttributes
        .builder
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .build

    def batchUpdateLinkAttributesResponse(

    ): BatchUpdateLinkAttributesResponse =
      BatchUpdateLinkAttributesResponse
        .builder

        .build

    def batchUpdateObjectAttributes(
      objectReference: Option[ObjectReference] = None,
      attributeUpdates: Option[List[ObjectAttributeUpdate]] = None
    ): BatchUpdateObjectAttributes =
      BatchUpdateObjectAttributes
        .builder
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .build

    def batchUpdateObjectAttributesResponse(
      objectIdentifier: Option[String] = None
    ): BatchUpdateObjectAttributesResponse =
      BatchUpdateObjectAttributesResponse
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def batchWriteException(
      index: Option[Int] = None,
      `type`: Option[String] = None,
      message: Option[String] = None
    ): BatchWriteException =
      BatchWriteException
        .builder
        .ifSome(index)(_.index(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def batchWriteOperation(
      createObject: Option[BatchCreateObject] = None,
      attachObject: Option[BatchAttachObject] = None,
      detachObject: Option[BatchDetachObject] = None,
      updateObjectAttributes: Option[BatchUpdateObjectAttributes] = None,
      deleteObject: Option[BatchDeleteObject] = None,
      addFacetToObject: Option[BatchAddFacetToObject] = None,
      removeFacetFromObject: Option[BatchRemoveFacetFromObject] = None,
      attachPolicy: Option[BatchAttachPolicy] = None,
      detachPolicy: Option[BatchDetachPolicy] = None,
      createIndex: Option[BatchCreateIndex] = None,
      attachToIndex: Option[BatchAttachToIndex] = None,
      detachFromIndex: Option[BatchDetachFromIndex] = None,
      attachTypedLink: Option[BatchAttachTypedLink] = None,
      detachTypedLink: Option[BatchDetachTypedLink] = None,
      updateLinkAttributes: Option[BatchUpdateLinkAttributes] = None
    ): BatchWriteOperation =
      BatchWriteOperation
        .builder
        .ifSome(createObject)(_.createObject(_))
        .ifSome(attachObject)(_.attachObject(_))
        .ifSome(detachObject)(_.detachObject(_))
        .ifSome(updateObjectAttributes)(_.updateObjectAttributes(_))
        .ifSome(deleteObject)(_.deleteObject(_))
        .ifSome(addFacetToObject)(_.addFacetToObject(_))
        .ifSome(removeFacetFromObject)(_.removeFacetFromObject(_))
        .ifSome(attachPolicy)(_.attachPolicy(_))
        .ifSome(detachPolicy)(_.detachPolicy(_))
        .ifSome(createIndex)(_.createIndex(_))
        .ifSome(attachToIndex)(_.attachToIndex(_))
        .ifSome(detachFromIndex)(_.detachFromIndex(_))
        .ifSome(attachTypedLink)(_.attachTypedLink(_))
        .ifSome(detachTypedLink)(_.detachTypedLink(_))
        .ifSome(updateLinkAttributes)(_.updateLinkAttributes(_))
        .build

    def batchWriteOperationResponse(
      createObject: Option[BatchCreateObjectResponse] = None,
      attachObject: Option[BatchAttachObjectResponse] = None,
      detachObject: Option[BatchDetachObjectResponse] = None,
      updateObjectAttributes: Option[BatchUpdateObjectAttributesResponse] = None,
      deleteObject: Option[BatchDeleteObjectResponse] = None,
      addFacetToObject: Option[BatchAddFacetToObjectResponse] = None,
      removeFacetFromObject: Option[BatchRemoveFacetFromObjectResponse] = None,
      attachPolicy: Option[BatchAttachPolicyResponse] = None,
      detachPolicy: Option[BatchDetachPolicyResponse] = None,
      createIndex: Option[BatchCreateIndexResponse] = None,
      attachToIndex: Option[BatchAttachToIndexResponse] = None,
      detachFromIndex: Option[BatchDetachFromIndexResponse] = None,
      attachTypedLink: Option[BatchAttachTypedLinkResponse] = None,
      detachTypedLink: Option[BatchDetachTypedLinkResponse] = None,
      updateLinkAttributes: Option[BatchUpdateLinkAttributesResponse] = None
    ): BatchWriteOperationResponse =
      BatchWriteOperationResponse
        .builder
        .ifSome(createObject)(_.createObject(_))
        .ifSome(attachObject)(_.attachObject(_))
        .ifSome(detachObject)(_.detachObject(_))
        .ifSome(updateObjectAttributes)(_.updateObjectAttributes(_))
        .ifSome(deleteObject)(_.deleteObject(_))
        .ifSome(addFacetToObject)(_.addFacetToObject(_))
        .ifSome(removeFacetFromObject)(_.removeFacetFromObject(_))
        .ifSome(attachPolicy)(_.attachPolicy(_))
        .ifSome(detachPolicy)(_.detachPolicy(_))
        .ifSome(createIndex)(_.createIndex(_))
        .ifSome(attachToIndex)(_.attachToIndex(_))
        .ifSome(detachFromIndex)(_.detachFromIndex(_))
        .ifSome(attachTypedLink)(_.attachTypedLink(_))
        .ifSome(detachTypedLink)(_.detachTypedLink(_))
        .ifSome(updateLinkAttributes)(_.updateLinkAttributes(_))
        .build

    def batchWriteRequest(
      directoryArn: Option[String] = None,
      operations: Option[List[BatchWriteOperation]] = None
    ): BatchWriteRequest =
      BatchWriteRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(operations)(_.operations(_))
        .build

    def batchWriteResponse(
      responses: Option[List[BatchWriteOperationResponse]] = None
    ): BatchWriteResponse =
      BatchWriteResponse
        .builder
        .ifSome(responses)(_.responses(_))
        .build

    def cannotListParentOfRootException(
      message: Option[String] = None
    ): CannotListParentOfRootException =
      CannotListParentOfRootException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createDirectoryRequest(
      name: Option[String] = None,
      schemaArn: Option[String] = None
    ): CreateDirectoryRequest =
      CreateDirectoryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def createDirectoryResponse(
      directoryArn: Option[String] = None,
      name: Option[String] = None,
      objectIdentifier: Option[String] = None,
      appliedSchemaArn: Option[String] = None
    ): CreateDirectoryResponse =
      CreateDirectoryResponse
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .ifSome(appliedSchemaArn)(_.appliedSchemaArn(_))
        .build

    def createFacetRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None,
      attributes: Option[List[FacetAttribute]] = None,
      objectType: Option[String] = None,
      facetStyle: Option[String] = None
    ): CreateFacetRequest =
      CreateFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(objectType)(_.objectType(_))
        .ifSome(facetStyle)(_.facetStyle(_))
        .build

    def createFacetResponse(

    ): CreateFacetResponse =
      CreateFacetResponse
        .builder

        .build

    def createIndexRequest(
      directoryArn: Option[String] = None,
      orderedIndexedAttributeList: Option[List[AttributeKey]] = None,
      isUnique: Option[Boolean] = None,
      parentReference: Option[ObjectReference] = None,
      linkName: Option[String] = None
    ): CreateIndexRequest =
      CreateIndexRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(orderedIndexedAttributeList)(_.orderedIndexedAttributeList(_))
        .ifSome(isUnique)(_.isUnique(_))
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def createIndexResponse(
      objectIdentifier: Option[String] = None
    ): CreateIndexResponse =
      CreateIndexResponse
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def createObjectRequest(
      directoryArn: Option[String] = None,
      schemaFacets: Option[List[SchemaFacet]] = None,
      objectAttributeList: Option[List[AttributeKeyAndValue]] = None,
      parentReference: Option[ObjectReference] = None,
      linkName: Option[String] = None
    ): CreateObjectRequest =
      CreateObjectRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(schemaFacets)(_.schemaFacets(_))
        .ifSome(objectAttributeList)(_.objectAttributeList(_))
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def createObjectResponse(
      objectIdentifier: Option[String] = None
    ): CreateObjectResponse =
      CreateObjectResponse
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def createSchemaRequest(
      name: Option[String] = None
    ): CreateSchemaRequest =
      CreateSchemaRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createSchemaResponse(
      schemaArn: Option[String] = None
    ): CreateSchemaResponse =
      CreateSchemaResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def createTypedLinkFacetRequest(
      schemaArn: Option[String] = None,
      facet: Option[TypedLinkFacet] = None
    ): CreateTypedLinkFacetRequest =
      CreateTypedLinkFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(facet)(_.facet(_))
        .build

    def createTypedLinkFacetResponse(

    ): CreateTypedLinkFacetResponse =
      CreateTypedLinkFacetResponse
        .builder

        .build

    def deleteDirectoryRequest(
      directoryArn: Option[String] = None
    ): DeleteDirectoryRequest =
      DeleteDirectoryRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def deleteDirectoryResponse(
      directoryArn: Option[String] = None
    ): DeleteDirectoryResponse =
      DeleteDirectoryResponse
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def deleteFacetRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None
    ): DeleteFacetRequest =
      DeleteFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteFacetResponse(

    ): DeleteFacetResponse =
      DeleteFacetResponse
        .builder

        .build

    def deleteObjectRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None
    ): DeleteObjectRequest =
      DeleteObjectRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def deleteObjectResponse(

    ): DeleteObjectResponse =
      DeleteObjectResponse
        .builder

        .build

    def deleteSchemaRequest(
      schemaArn: Option[String] = None
    ): DeleteSchemaRequest =
      DeleteSchemaRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def deleteSchemaResponse(
      schemaArn: Option[String] = None
    ): DeleteSchemaResponse =
      DeleteSchemaResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def deleteTypedLinkFacetRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None
    ): DeleteTypedLinkFacetRequest =
      DeleteTypedLinkFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteTypedLinkFacetResponse(

    ): DeleteTypedLinkFacetResponse =
      DeleteTypedLinkFacetResponse
        .builder

        .build

    def detachFromIndexRequest(
      directoryArn: Option[String] = None,
      indexReference: Option[ObjectReference] = None,
      targetReference: Option[ObjectReference] = None
    ): DetachFromIndexRequest =
      DetachFromIndexRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(indexReference)(_.indexReference(_))
        .ifSome(targetReference)(_.targetReference(_))
        .build

    def detachFromIndexResponse(
      detachedObjectIdentifier: Option[String] = None
    ): DetachFromIndexResponse =
      DetachFromIndexResponse
        .builder
        .ifSome(detachedObjectIdentifier)(_.detachedObjectIdentifier(_))
        .build

    def detachObjectRequest(
      directoryArn: Option[String] = None,
      parentReference: Option[ObjectReference] = None,
      linkName: Option[String] = None
    ): DetachObjectRequest =
      DetachObjectRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(parentReference)(_.parentReference(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def detachObjectResponse(
      detachedObjectIdentifier: Option[String] = None
    ): DetachObjectResponse =
      DetachObjectResponse
        .builder
        .ifSome(detachedObjectIdentifier)(_.detachedObjectIdentifier(_))
        .build

    def detachPolicyRequest(
      directoryArn: Option[String] = None,
      policyReference: Option[ObjectReference] = None,
      objectReference: Option[ObjectReference] = None
    ): DetachPolicyRequest =
      DetachPolicyRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(policyReference)(_.policyReference(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def detachPolicyResponse(

    ): DetachPolicyResponse =
      DetachPolicyResponse
        .builder

        .build

    def detachTypedLinkRequest(
      directoryArn: Option[String] = None,
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None
    ): DetachTypedLinkRequest =
      DetachTypedLinkRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .build

    def directory(
      name: Option[String] = None,
      directoryArn: Option[String] = None,
      state: Option[String] = None,
      creationDateTime: Option[Date] = None
    ): Directory =
      Directory
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def directoryAlreadyExistsException(
      message: Option[String] = None
    ): DirectoryAlreadyExistsException =
      DirectoryAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def directoryDeletedException(
      message: Option[String] = None
    ): DirectoryDeletedException =
      DirectoryDeletedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def directoryNotDisabledException(
      message: Option[String] = None
    ): DirectoryNotDisabledException =
      DirectoryNotDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def directoryNotEnabledException(
      message: Option[String] = None
    ): DirectoryNotEnabledException =
      DirectoryNotEnabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def disableDirectoryRequest(
      directoryArn: Option[String] = None
    ): DisableDirectoryRequest =
      DisableDirectoryRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def disableDirectoryResponse(
      directoryArn: Option[String] = None
    ): DisableDirectoryResponse =
      DisableDirectoryResponse
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def enableDirectoryRequest(
      directoryArn: Option[String] = None
    ): EnableDirectoryRequest =
      EnableDirectoryRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def enableDirectoryResponse(
      directoryArn: Option[String] = None
    ): EnableDirectoryResponse =
      EnableDirectoryResponse
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def facet(
      name: Option[String] = None,
      objectType: Option[String] = None,
      facetStyle: Option[String] = None
    ): Facet =
      Facet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(objectType)(_.objectType(_))
        .ifSome(facetStyle)(_.facetStyle(_))
        .build

    def facetAlreadyExistsException(
      message: Option[String] = None
    ): FacetAlreadyExistsException =
      FacetAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def facetAttribute(
      name: Option[String] = None,
      attributeDefinition: Option[FacetAttributeDefinition] = None,
      attributeReference: Option[FacetAttributeReference] = None,
      requiredBehavior: Option[String] = None
    ): FacetAttribute =
      FacetAttribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributeDefinition)(_.attributeDefinition(_))
        .ifSome(attributeReference)(_.attributeReference(_))
        .ifSome(requiredBehavior)(_.requiredBehavior(_))
        .build

    def facetAttributeDefinition(
      `type`: Option[String] = None,
      defaultValue: Option[TypedAttributeValue] = None,
      isImmutable: Option[Boolean] = None,
      rules: Option[RuleMap] = None
    ): FacetAttributeDefinition =
      FacetAttributeDefinition
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(isImmutable)(_.isImmutable(_))
        .ifSome(rules)(_.rules(_))
        .build

    def facetAttributeReference(
      targetFacetName: Option[String] = None,
      targetAttributeName: Option[String] = None
    ): FacetAttributeReference =
      FacetAttributeReference
        .builder
        .ifSome(targetFacetName)(_.targetFacetName(_))
        .ifSome(targetAttributeName)(_.targetAttributeName(_))
        .build

    def facetAttributeUpdate(
      attribute: Option[FacetAttribute] = None,
      action: Option[String] = None
    ): FacetAttributeUpdate =
      FacetAttributeUpdate
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(action)(_.action(_))
        .build

    def facetInUseException(
      message: Option[String] = None
    ): FacetInUseException =
      FacetInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def facetNotFoundException(
      message: Option[String] = None
    ): FacetNotFoundException =
      FacetNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def facetValidationException(
      message: Option[String] = None
    ): FacetValidationException =
      FacetValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getAppliedSchemaVersionRequest(
      schemaArn: Option[String] = None
    ): GetAppliedSchemaVersionRequest =
      GetAppliedSchemaVersionRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def getAppliedSchemaVersionResponse(
      appliedSchemaArn: Option[String] = None
    ): GetAppliedSchemaVersionResponse =
      GetAppliedSchemaVersionResponse
        .builder
        .ifSome(appliedSchemaArn)(_.appliedSchemaArn(_))
        .build

    def getDirectoryRequest(
      directoryArn: Option[String] = None
    ): GetDirectoryRequest =
      GetDirectoryRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def getDirectoryResponse(
      directory: Option[Directory] = None
    ): GetDirectoryResponse =
      GetDirectoryResponse
        .builder
        .ifSome(directory)(_.directory(_))
        .build

    def getFacetRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None
    ): GetFacetRequest =
      GetFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .build

    def getFacetResponse(
      facet: Option[Facet] = None
    ): GetFacetResponse =
      GetFacetResponse
        .builder
        .ifSome(facet)(_.facet(_))
        .build

    def getLinkAttributesRequest(
      directoryArn: Option[String] = None,
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None,
      attributeNames: Option[List[AttributeName]] = None,
      consistencyLevel: Option[String] = None
    ): GetLinkAttributesRequest =
      GetLinkAttributesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def getLinkAttributesResponse(
      attributes: Option[List[AttributeKeyAndValue]] = None
    ): GetLinkAttributesResponse =
      GetLinkAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getObjectAttributesRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      consistencyLevel: Option[String] = None,
      schemaFacet: Option[SchemaFacet] = None,
      attributeNames: Option[List[AttributeName]] = None
    ): GetObjectAttributesRequest =
      GetObjectAttributesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def getObjectAttributesResponse(
      attributes: Option[List[AttributeKeyAndValue]] = None
    ): GetObjectAttributesResponse =
      GetObjectAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getObjectInformationRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      consistencyLevel: Option[String] = None
    ): GetObjectInformationRequest =
      GetObjectInformationRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def getObjectInformationResponse(
      schemaFacets: Option[List[SchemaFacet]] = None,
      objectIdentifier: Option[String] = None
    ): GetObjectInformationResponse =
      GetObjectInformationResponse
        .builder
        .ifSome(schemaFacets)(_.schemaFacets(_))
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def getSchemaAsJsonRequest(
      schemaArn: Option[String] = None
    ): GetSchemaAsJsonRequest =
      GetSchemaAsJsonRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def getSchemaAsJsonResponse(
      name: Option[String] = None,
      document: Option[String] = None
    ): GetSchemaAsJsonResponse =
      GetSchemaAsJsonResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(document)(_.document(_))
        .build

    def getTypedLinkFacetInformationRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None
    ): GetTypedLinkFacetInformationRequest =
      GetTypedLinkFacetInformationRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .build

    def getTypedLinkFacetInformationResponse(
      identityAttributeOrder: Option[List[AttributeName]] = None
    ): GetTypedLinkFacetInformationResponse =
      GetTypedLinkFacetInformationResponse
        .builder
        .ifSome(identityAttributeOrder)(_.identityAttributeOrder(_))
        .build

    def incompatibleSchemaException(
      message: Option[String] = None
    ): IncompatibleSchemaException =
      IncompatibleSchemaException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def indexAttachment(
      indexedAttributes: Option[List[AttributeKeyAndValue]] = None,
      objectIdentifier: Option[String] = None
    ): IndexAttachment =
      IndexAttachment
        .builder
        .ifSome(indexedAttributes)(_.indexedAttributes(_))
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def indexedAttributeMissingException(
      message: Option[String] = None
    ): IndexedAttributeMissingException =
      IndexedAttributeMissingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArnException(
      message: Option[String] = None
    ): InvalidArnException =
      InvalidArnException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAttachmentException(
      message: Option[String] = None
    ): InvalidAttachmentException =
      InvalidAttachmentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFacetUpdateException(
      message: Option[String] = None
    ): InvalidFacetUpdateException =
      InvalidFacetUpdateException
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

    def invalidRuleException(
      message: Option[String] = None
    ): InvalidRuleException =
      InvalidRuleException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSchemaDocException(
      message: Option[String] = None
    ): InvalidSchemaDocException =
      InvalidSchemaDocException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTaggingRequestException(
      message: Option[String] = None
    ): InvalidTaggingRequestException =
      InvalidTaggingRequestException
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

    def linkAttributeAction(
      attributeActionType: Option[String] = None,
      attributeUpdateValue: Option[TypedAttributeValue] = None
    ): LinkAttributeAction =
      LinkAttributeAction
        .builder
        .ifSome(attributeActionType)(_.attributeActionType(_))
        .ifSome(attributeUpdateValue)(_.attributeUpdateValue(_))
        .build

    def linkAttributeUpdate(
      attributeKey: Option[AttributeKey] = None,
      attributeAction: Option[LinkAttributeAction] = None
    ): LinkAttributeUpdate =
      LinkAttributeUpdate
        .builder
        .ifSome(attributeKey)(_.attributeKey(_))
        .ifSome(attributeAction)(_.attributeAction(_))
        .build

    def linkNameAlreadyInUseException(
      message: Option[String] = None
    ): LinkNameAlreadyInUseException =
      LinkNameAlreadyInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAppliedSchemaArnsRequest(
      directoryArn: Option[String] = None,
      schemaArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAppliedSchemaArnsRequest =
      ListAppliedSchemaArnsRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAppliedSchemaArnsResponse(
      schemaArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListAppliedSchemaArnsResponse =
      ListAppliedSchemaArnsResponse
        .builder
        .ifSome(schemaArns)(_.schemaArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAttachedIndicesRequest(
      directoryArn: Option[String] = None,
      targetReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None
    ): ListAttachedIndicesRequest =
      ListAttachedIndicesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(targetReference)(_.targetReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listAttachedIndicesResponse(
      indexAttachments: Option[List[IndexAttachment]] = None,
      nextToken: Option[String] = None
    ): ListAttachedIndicesResponse =
      ListAttachedIndicesResponse
        .builder
        .ifSome(indexAttachments)(_.indexAttachments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevelopmentSchemaArnsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDevelopmentSchemaArnsRequest =
      ListDevelopmentSchemaArnsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDevelopmentSchemaArnsResponse(
      schemaArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListDevelopmentSchemaArnsResponse =
      ListDevelopmentSchemaArnsResponse
        .builder
        .ifSome(schemaArns)(_.schemaArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDirectoriesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      state: Option[String] = None
    ): ListDirectoriesRequest =
      ListDirectoriesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(state)(_.state(_))
        .build

    def listDirectoriesResponse(
      directories: Option[List[Directory]] = None,
      nextToken: Option[String] = None
    ): ListDirectoriesResponse =
      ListDirectoriesResponse
        .builder
        .ifSome(directories)(_.directories(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFacetAttributesRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFacetAttributesRequest =
      ListFacetAttributesRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFacetAttributesResponse(
      attributes: Option[List[FacetAttribute]] = None,
      nextToken: Option[String] = None
    ): ListFacetAttributesResponse =
      ListFacetAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFacetNamesRequest(
      schemaArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFacetNamesRequest =
      ListFacetNamesRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFacetNamesResponse(
      facetNames: Option[List[FacetName]] = None,
      nextToken: Option[String] = None
    ): ListFacetNamesResponse =
      ListFacetNamesResponse
        .builder
        .ifSome(facetNames)(_.facetNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIncomingTypedLinksRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      filterAttributeRanges: Option[List[TypedLinkAttributeRange]] = None,
      filterTypedLink: Option[TypedLinkSchemaAndFacetName] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None
    ): ListIncomingTypedLinksRequest =
      ListIncomingTypedLinksRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(filterAttributeRanges)(_.filterAttributeRanges(_))
        .ifSome(filterTypedLink)(_.filterTypedLink(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listIncomingTypedLinksResponse(
      linkSpecifiers: Option[List[TypedLinkSpecifier]] = None,
      nextToken: Option[String] = None
    ): ListIncomingTypedLinksResponse =
      ListIncomingTypedLinksResponse
        .builder
        .ifSome(linkSpecifiers)(_.linkSpecifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIndexRequest(
      directoryArn: Option[String] = None,
      rangesOnIndexedValues: Option[List[ObjectAttributeRange]] = None,
      indexReference: Option[ObjectReference] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      consistencyLevel: Option[String] = None
    ): ListIndexRequest =
      ListIndexRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(rangesOnIndexedValues)(_.rangesOnIndexedValues(_))
        .ifSome(indexReference)(_.indexReference(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listIndexResponse(
      indexAttachments: Option[List[IndexAttachment]] = None,
      nextToken: Option[String] = None
    ): ListIndexResponse =
      ListIndexResponse
        .builder
        .ifSome(indexAttachments)(_.indexAttachments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listManagedSchemaArnsRequest(
      schemaArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListManagedSchemaArnsRequest =
      ListManagedSchemaArnsRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listManagedSchemaArnsResponse(
      schemaArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListManagedSchemaArnsResponse =
      ListManagedSchemaArnsResponse
        .builder
        .ifSome(schemaArns)(_.schemaArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listObjectAttributesRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None,
      facetFilter: Option[SchemaFacet] = None
    ): ListObjectAttributesRequest =
      ListObjectAttributesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .ifSome(facetFilter)(_.facetFilter(_))
        .build

    def listObjectAttributesResponse(
      attributes: Option[List[AttributeKeyAndValue]] = None,
      nextToken: Option[String] = None
    ): ListObjectAttributesResponse =
      ListObjectAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listObjectChildrenRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None
    ): ListObjectChildrenRequest =
      ListObjectChildrenRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listObjectChildrenResponse(
      children: Option[LinkNameToObjectIdentifierMap] = None,
      nextToken: Option[String] = None
    ): ListObjectChildrenResponse =
      ListObjectChildrenResponse
        .builder
        .ifSome(children)(_.children(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listObjectParentPathsRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListObjectParentPathsRequest =
      ListObjectParentPathsRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listObjectParentPathsResponse(
      pathToObjectIdentifiersList: Option[List[PathToObjectIdentifiers]] = None,
      nextToken: Option[String] = None
    ): ListObjectParentPathsResponse =
      ListObjectParentPathsResponse
        .builder
        .ifSome(pathToObjectIdentifiersList)(_.pathToObjectIdentifiersList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listObjectParentsRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None,
      includeAllLinksToEachParent: Option[Boolean] = None
    ): ListObjectParentsRequest =
      ListObjectParentsRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .ifSome(includeAllLinksToEachParent)(_.includeAllLinksToEachParent(_))
        .build

    def listObjectParentsResponse(
      parents: Option[ObjectIdentifierToLinkNameMap] = None,
      nextToken: Option[String] = None,
      parentLinks: Option[List[ObjectIdentifierAndLinkNameTuple]] = None
    ): ListObjectParentsResponse =
      ListObjectParentsResponse
        .builder
        .ifSome(parents)(_.parents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(parentLinks)(_.parentLinks(_))
        .build

    def listObjectPoliciesRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None
    ): ListObjectPoliciesRequest =
      ListObjectPoliciesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listObjectPoliciesResponse(
      attachedPolicyIds: Option[List[ObjectIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListObjectPoliciesResponse =
      ListObjectPoliciesResponse
        .builder
        .ifSome(attachedPolicyIds)(_.attachedPolicyIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOutgoingTypedLinksRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      filterAttributeRanges: Option[List[TypedLinkAttributeRange]] = None,
      filterTypedLink: Option[TypedLinkSchemaAndFacetName] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None
    ): ListOutgoingTypedLinksRequest =
      ListOutgoingTypedLinksRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(filterAttributeRanges)(_.filterAttributeRanges(_))
        .ifSome(filterTypedLink)(_.filterTypedLink(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listOutgoingTypedLinksResponse(
      typedLinkSpecifiers: Option[List[TypedLinkSpecifier]] = None,
      nextToken: Option[String] = None
    ): ListOutgoingTypedLinksResponse =
      ListOutgoingTypedLinksResponse
        .builder
        .ifSome(typedLinkSpecifiers)(_.typedLinkSpecifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPolicyAttachmentsRequest(
      directoryArn: Option[String] = None,
      policyReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      consistencyLevel: Option[String] = None
    ): ListPolicyAttachmentsRequest =
      ListPolicyAttachmentsRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(policyReference)(_.policyReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(consistencyLevel)(_.consistencyLevel(_))
        .build

    def listPolicyAttachmentsResponse(
      objectIdentifiers: Option[List[ObjectIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListPolicyAttachmentsResponse =
      ListPolicyAttachmentsResponse
        .builder
        .ifSome(objectIdentifiers)(_.objectIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPublishedSchemaArnsRequest(
      schemaArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPublishedSchemaArnsRequest =
      ListPublishedSchemaArnsRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPublishedSchemaArnsResponse(
      schemaArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListPublishedSchemaArnsResponse =
      ListPublishedSchemaArnsResponse
        .builder
        .ifSome(schemaArns)(_.schemaArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypedLinkFacetAttributesRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTypedLinkFacetAttributesRequest =
      ListTypedLinkFacetAttributesRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTypedLinkFacetAttributesResponse(
      attributes: Option[List[TypedLinkAttributeDefinition]] = None,
      nextToken: Option[String] = None
    ): ListTypedLinkFacetAttributesResponse =
      ListTypedLinkFacetAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypedLinkFacetNamesRequest(
      schemaArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTypedLinkFacetNamesRequest =
      ListTypedLinkFacetNamesRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTypedLinkFacetNamesResponse(
      facetNames: Option[List[TypedLinkName]] = None,
      nextToken: Option[String] = None
    ): ListTypedLinkFacetNamesResponse =
      ListTypedLinkFacetNamesResponse
        .builder
        .ifSome(facetNames)(_.facetNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lookupPolicyRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): LookupPolicyRequest =
      LookupPolicyRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def lookupPolicyResponse(
      policyToPathList: Option[List[PolicyToPath]] = None,
      nextToken: Option[String] = None
    ): LookupPolicyResponse =
      LookupPolicyResponse
        .builder
        .ifSome(policyToPathList)(_.policyToPathList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notIndexException(
      message: Option[String] = None
    ): NotIndexException =
      NotIndexException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notNodeException(
      message: Option[String] = None
    ): NotNodeException =
      NotNodeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notPolicyException(
      message: Option[String] = None
    ): NotPolicyException =
      NotPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def objectAlreadyDetachedException(
      message: Option[String] = None
    ): ObjectAlreadyDetachedException =
      ObjectAlreadyDetachedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def objectAttributeAction(
      objectAttributeActionType: Option[String] = None,
      objectAttributeUpdateValue: Option[TypedAttributeValue] = None
    ): ObjectAttributeAction =
      ObjectAttributeAction
        .builder
        .ifSome(objectAttributeActionType)(_.objectAttributeActionType(_))
        .ifSome(objectAttributeUpdateValue)(_.objectAttributeUpdateValue(_))
        .build

    def objectAttributeRange(
      attributeKey: Option[AttributeKey] = None,
      range: Option[TypedAttributeValueRange] = None
    ): ObjectAttributeRange =
      ObjectAttributeRange
        .builder
        .ifSome(attributeKey)(_.attributeKey(_))
        .ifSome(range)(_.range(_))
        .build

    def objectAttributeUpdate(
      objectAttributeKey: Option[AttributeKey] = None,
      objectAttributeAction: Option[ObjectAttributeAction] = None
    ): ObjectAttributeUpdate =
      ObjectAttributeUpdate
        .builder
        .ifSome(objectAttributeKey)(_.objectAttributeKey(_))
        .ifSome(objectAttributeAction)(_.objectAttributeAction(_))
        .build

    def objectIdentifierAndLinkNameTuple(
      objectIdentifier: Option[String] = None,
      linkName: Option[String] = None
    ): ObjectIdentifierAndLinkNameTuple =
      ObjectIdentifierAndLinkNameTuple
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .ifSome(linkName)(_.linkName(_))
        .build

    def objectNotDetachedException(
      message: Option[String] = None
    ): ObjectNotDetachedException =
      ObjectNotDetachedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def objectReference(
      selector: Option[String] = None
    ): ObjectReference =
      ObjectReference
        .builder
        .ifSome(selector)(_.selector(_))
        .build

    def pathToObjectIdentifiers(
      path: Option[String] = None,
      objectIdentifiers: Option[List[ObjectIdentifier]] = None
    ): PathToObjectIdentifiers =
      PathToObjectIdentifiers
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(objectIdentifiers)(_.objectIdentifiers(_))
        .build

    def policyAttachment(
      policyId: Option[String] = None,
      objectIdentifier: Option[String] = None,
      policyType: Option[String] = None
    ): PolicyAttachment =
      PolicyAttachment
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .ifSome(policyType)(_.policyType(_))
        .build

    def policyToPath(
      path: Option[String] = None,
      policies: Option[List[PolicyAttachment]] = None
    ): PolicyToPath =
      PolicyToPath
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(policies)(_.policies(_))
        .build

    def publishSchemaRequest(
      developmentSchemaArn: Option[String] = None,
      version: Option[String] = None,
      minorVersion: Option[String] = None,
      name: Option[String] = None
    ): PublishSchemaRequest =
      PublishSchemaRequest
        .builder
        .ifSome(developmentSchemaArn)(_.developmentSchemaArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(name)(_.name(_))
        .build

    def publishSchemaResponse(
      publishedSchemaArn: Option[String] = None
    ): PublishSchemaResponse =
      PublishSchemaResponse
        .builder
        .ifSome(publishedSchemaArn)(_.publishedSchemaArn(_))
        .build

    def putSchemaFromJsonRequest(
      schemaArn: Option[String] = None,
      document: Option[String] = None
    ): PutSchemaFromJsonRequest =
      PutSchemaFromJsonRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(document)(_.document(_))
        .build

    def putSchemaFromJsonResponse(
      arn: Option[String] = None
    ): PutSchemaFromJsonResponse =
      PutSchemaFromJsonResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def removeFacetFromObjectRequest(
      directoryArn: Option[String] = None,
      schemaFacet: Option[SchemaFacet] = None,
      objectReference: Option[ObjectReference] = None
    ): RemoveFacetFromObjectRequest =
      RemoveFacetFromObjectRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(schemaFacet)(_.schemaFacet(_))
        .ifSome(objectReference)(_.objectReference(_))
        .build

    def removeFacetFromObjectResponse(

    ): RemoveFacetFromObjectResponse =
      RemoveFacetFromObjectResponse
        .builder

        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def retryableConflictException(
      message: Option[String] = None
    ): RetryableConflictException =
      RetryableConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rule(
      `type`: Option[String] = None,
      parameters: Option[RuleParameterMap] = None
    ): Rule =
      Rule
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def schemaAlreadyExistsException(
      message: Option[String] = None
    ): SchemaAlreadyExistsException =
      SchemaAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def schemaAlreadyPublishedException(
      message: Option[String] = None
    ): SchemaAlreadyPublishedException =
      SchemaAlreadyPublishedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def schemaFacet(
      schemaArn: Option[String] = None,
      facetName: Option[String] = None
    ): SchemaFacet =
      SchemaFacet
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(facetName)(_.facetName(_))
        .build

    def stillContainsLinksException(
      message: Option[String] = None
    ): StillContainsLinksException =
      StillContainsLinksException
        .builder
        .ifSome(message)(_.message(_))
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
      tags: Option[List[Tag]] = None
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

    def typedAttributeValue(
      stringValue: Option[String] = None,
      binaryValue: Option[BinaryAttributeValue] = None,
      booleanValue: Option[Boolean] = None,
      numberValue: Option[String] = None,
      datetimeValue: Option[DatetimeAttributeValue] = None
    ): TypedAttributeValue =
      TypedAttributeValue
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(binaryValue)(_.binaryValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .ifSome(numberValue)(_.numberValue(_))
        .ifSome(datetimeValue)(_.datetimeValue(_))
        .build

    def typedAttributeValueRange(
      startMode: Option[String] = None,
      startValue: Option[TypedAttributeValue] = None,
      endMode: Option[String] = None,
      endValue: Option[TypedAttributeValue] = None
    ): TypedAttributeValueRange =
      TypedAttributeValueRange
        .builder
        .ifSome(startMode)(_.startMode(_))
        .ifSome(startValue)(_.startValue(_))
        .ifSome(endMode)(_.endMode(_))
        .ifSome(endValue)(_.endValue(_))
        .build

    def typedLinkAttributeDefinition(
      name: Option[String] = None,
      `type`: Option[String] = None,
      defaultValue: Option[TypedAttributeValue] = None,
      isImmutable: Option[Boolean] = None,
      rules: Option[RuleMap] = None,
      requiredBehavior: Option[String] = None
    ): TypedLinkAttributeDefinition =
      TypedLinkAttributeDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(isImmutable)(_.isImmutable(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(requiredBehavior)(_.requiredBehavior(_))
        .build

    def typedLinkAttributeRange(
      attributeName: Option[String] = None,
      range: Option[TypedAttributeValueRange] = None
    ): TypedLinkAttributeRange =
      TypedLinkAttributeRange
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(range)(_.range(_))
        .build

    def typedLinkFacet(
      name: Option[String] = None,
      attributes: Option[List[TypedLinkAttributeDefinition]] = None,
      identityAttributeOrder: Option[List[AttributeName]] = None
    ): TypedLinkFacet =
      TypedLinkFacet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(identityAttributeOrder)(_.identityAttributeOrder(_))
        .build

    def typedLinkFacetAttributeUpdate(
      attribute: Option[TypedLinkAttributeDefinition] = None,
      action: Option[String] = None
    ): TypedLinkFacetAttributeUpdate =
      TypedLinkFacetAttributeUpdate
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(action)(_.action(_))
        .build

    def typedLinkSchemaAndFacetName(
      schemaArn: Option[String] = None,
      typedLinkName: Option[String] = None
    ): TypedLinkSchemaAndFacetName =
      TypedLinkSchemaAndFacetName
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(typedLinkName)(_.typedLinkName(_))
        .build

    def typedLinkSpecifier(
      typedLinkFacet: Option[TypedLinkSchemaAndFacetName] = None,
      sourceObjectReference: Option[ObjectReference] = None,
      targetObjectReference: Option[ObjectReference] = None,
      identityAttributeValues: Option[List[AttributeNameAndValue]] = None
    ): TypedLinkSpecifier =
      TypedLinkSpecifier
        .builder
        .ifSome(typedLinkFacet)(_.typedLinkFacet(_))
        .ifSome(sourceObjectReference)(_.sourceObjectReference(_))
        .ifSome(targetObjectReference)(_.targetObjectReference(_))
        .ifSome(identityAttributeValues)(_.identityAttributeValues(_))
        .build

    def unsupportedIndexTypeException(
      message: Option[String] = None
    ): UnsupportedIndexTypeException =
      UnsupportedIndexTypeException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateFacetRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None,
      attributeUpdates: Option[List[FacetAttributeUpdate]] = None,
      objectType: Option[String] = None
    ): UpdateFacetRequest =
      UpdateFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .ifSome(objectType)(_.objectType(_))
        .build

    def updateFacetResponse(

    ): UpdateFacetResponse =
      UpdateFacetResponse
        .builder

        .build

    def updateLinkAttributesRequest(
      directoryArn: Option[String] = None,
      typedLinkSpecifier: Option[TypedLinkSpecifier] = None,
      attributeUpdates: Option[List[LinkAttributeUpdate]] = None
    ): UpdateLinkAttributesRequest =
      UpdateLinkAttributesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(typedLinkSpecifier)(_.typedLinkSpecifier(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .build

    def updateLinkAttributesResponse(

    ): UpdateLinkAttributesResponse =
      UpdateLinkAttributesResponse
        .builder

        .build

    def updateObjectAttributesRequest(
      directoryArn: Option[String] = None,
      objectReference: Option[ObjectReference] = None,
      attributeUpdates: Option[List[ObjectAttributeUpdate]] = None
    ): UpdateObjectAttributesRequest =
      UpdateObjectAttributesRequest
        .builder
        .ifSome(directoryArn)(_.directoryArn(_))
        .ifSome(objectReference)(_.objectReference(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .build

    def updateObjectAttributesResponse(
      objectIdentifier: Option[String] = None
    ): UpdateObjectAttributesResponse =
      UpdateObjectAttributesResponse
        .builder
        .ifSome(objectIdentifier)(_.objectIdentifier(_))
        .build

    def updateSchemaRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None
    ): UpdateSchemaRequest =
      UpdateSchemaRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .build

    def updateSchemaResponse(
      schemaArn: Option[String] = None
    ): UpdateSchemaResponse =
      UpdateSchemaResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .build

    def updateTypedLinkFacetRequest(
      schemaArn: Option[String] = None,
      name: Option[String] = None,
      attributeUpdates: Option[List[TypedLinkFacetAttributeUpdate]] = None,
      identityAttributeOrder: Option[List[AttributeName]] = None
    ): UpdateTypedLinkFacetRequest =
      UpdateTypedLinkFacetRequest
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .ifSome(identityAttributeOrder)(_.identityAttributeOrder(_))
        .build

    def updateTypedLinkFacetResponse(

    ): UpdateTypedLinkFacetResponse =
      UpdateTypedLinkFacetResponse
        .builder

        .build

    def upgradeAppliedSchemaRequest(
      publishedSchemaArn: Option[String] = None,
      directoryArn: Option[String] = None
    ): UpgradeAppliedSchemaRequest =
      UpgradeAppliedSchemaRequest
        .builder
        .ifSome(publishedSchemaArn)(_.publishedSchemaArn(_))
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def upgradeAppliedSchemaResponse(
      upgradedSchemaArn: Option[String] = None,
      directoryArn: Option[String] = None
    ): UpgradeAppliedSchemaResponse =
      UpgradeAppliedSchemaResponse
        .builder
        .ifSome(upgradedSchemaArn)(_.upgradedSchemaArn(_))
        .ifSome(directoryArn)(_.directoryArn(_))
        .build

    def upgradePublishedSchemaRequest(
      developmentSchemaArn: Option[String] = None,
      publishedSchemaArn: Option[String] = None,
      minorVersion: Option[String] = None
    ): UpgradePublishedSchemaRequest =
      UpgradePublishedSchemaRequest
        .builder
        .ifSome(developmentSchemaArn)(_.developmentSchemaArn(_))
        .ifSome(publishedSchemaArn)(_.publishedSchemaArn(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .build

    def upgradePublishedSchemaResponse(
      upgradedSchemaArn: Option[String] = None
    ): UpgradePublishedSchemaResponse =
      UpgradePublishedSchemaResponse
        .builder
        .ifSome(upgradedSchemaArn)(_.upgradedSchemaArn(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
