package goober.hi

import goober.free.cloudsearch.CloudSearchIO
import software.amazon.awssdk.services.cloudsearch.model._


object cloudsearch {
  import goober.free.{cloudsearch ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessPoliciesStatus(
      options: Option[String] = None,
      status: Option[OptionStatus] = None
    ): AccessPoliciesStatus =
      AccessPoliciesStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def analysisOptions(
      synonyms: Option[String] = None,
      stopwords: Option[String] = None,
      stemmingDictionary: Option[String] = None,
      japaneseTokenizationDictionary: Option[String] = None,
      algorithmicStemming: Option[String] = None
    ): AnalysisOptions =
      AnalysisOptions
        .builder
        .ifSome(synonyms)(_.synonyms(_))
        .ifSome(stopwords)(_.stopwords(_))
        .ifSome(stemmingDictionary)(_.stemmingDictionary(_))
        .ifSome(japaneseTokenizationDictionary)(_.japaneseTokenizationDictionary(_))
        .ifSome(algorithmicStemming)(_.algorithmicStemming(_))
        .build

    def analysisScheme(
      analysisSchemeName: Option[String] = None,
      analysisSchemeLanguage: Option[String] = None,
      analysisOptions: Option[AnalysisOptions] = None
    ): AnalysisScheme =
      AnalysisScheme
        .builder
        .ifSome(analysisSchemeName)(_.analysisSchemeName(_))
        .ifSome(analysisSchemeLanguage)(_.analysisSchemeLanguage(_))
        .ifSome(analysisOptions)(_.analysisOptions(_))
        .build

    def analysisSchemeStatus(
      options: Option[AnalysisScheme] = None,
      status: Option[OptionStatus] = None
    ): AnalysisSchemeStatus =
      AnalysisSchemeStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def availabilityOptionsStatus(
      options: Option[Boolean] = None,
      status: Option[OptionStatus] = None
    ): AvailabilityOptionsStatus =
      AvailabilityOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def baseException(
      code: Option[String] = None,
      message: Option[String] = None
    ): BaseException =
      BaseException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def buildSuggestersRequest(
      domainName: Option[String] = None
    ): BuildSuggestersRequest =
      BuildSuggestersRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def buildSuggestersResponse(
      fieldNames: Option[List[FieldName]] = None
    ): BuildSuggestersResponse =
      BuildSuggestersResponse
        .builder
        .ifSome(fieldNames)(_.fieldNames(_))
        .build

    def createDomainRequest(
      domainName: Option[String] = None
    ): CreateDomainRequest =
      CreateDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def createDomainResponse(
      domainStatus: Option[DomainStatus] = None
    ): CreateDomainResponse =
      CreateDomainResponse
        .builder
        .ifSome(domainStatus)(_.domainStatus(_))
        .build

    def dateArrayOptions(
      defaultValue: Option[String] = None,
      sourceFields: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None
    ): DateArrayOptions =
      DateArrayOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .build

    def dateOptions(
      defaultValue: Option[String] = None,
      sourceField: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None,
      sortEnabled: Option[Boolean] = None
    ): DateOptions =
      DateOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(sortEnabled)(_.sortEnabled(_))
        .build

    def defineAnalysisSchemeRequest(
      domainName: Option[String] = None,
      analysisScheme: Option[AnalysisScheme] = None
    ): DefineAnalysisSchemeRequest =
      DefineAnalysisSchemeRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(analysisScheme)(_.analysisScheme(_))
        .build

    def defineAnalysisSchemeResponse(
      analysisScheme: Option[AnalysisSchemeStatus] = None
    ): DefineAnalysisSchemeResponse =
      DefineAnalysisSchemeResponse
        .builder
        .ifSome(analysisScheme)(_.analysisScheme(_))
        .build

    def defineExpressionRequest(
      domainName: Option[String] = None,
      expression: Option[Expression] = None
    ): DefineExpressionRequest =
      DefineExpressionRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(expression)(_.expression(_))
        .build

    def defineExpressionResponse(
      expression: Option[ExpressionStatus] = None
    ): DefineExpressionResponse =
      DefineExpressionResponse
        .builder
        .ifSome(expression)(_.expression(_))
        .build

    def defineIndexFieldRequest(
      domainName: Option[String] = None,
      indexField: Option[IndexField] = None
    ): DefineIndexFieldRequest =
      DefineIndexFieldRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(indexField)(_.indexField(_))
        .build

    def defineIndexFieldResponse(
      indexField: Option[IndexFieldStatus] = None
    ): DefineIndexFieldResponse =
      DefineIndexFieldResponse
        .builder
        .ifSome(indexField)(_.indexField(_))
        .build

    def defineSuggesterRequest(
      domainName: Option[String] = None,
      suggester: Option[Suggester] = None
    ): DefineSuggesterRequest =
      DefineSuggesterRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(suggester)(_.suggester(_))
        .build

    def defineSuggesterResponse(
      suggester: Option[SuggesterStatus] = None
    ): DefineSuggesterResponse =
      DefineSuggesterResponse
        .builder
        .ifSome(suggester)(_.suggester(_))
        .build

    def deleteAnalysisSchemeRequest(
      domainName: Option[String] = None,
      analysisSchemeName: Option[String] = None
    ): DeleteAnalysisSchemeRequest =
      DeleteAnalysisSchemeRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(analysisSchemeName)(_.analysisSchemeName(_))
        .build

    def deleteAnalysisSchemeResponse(
      analysisScheme: Option[AnalysisSchemeStatus] = None
    ): DeleteAnalysisSchemeResponse =
      DeleteAnalysisSchemeResponse
        .builder
        .ifSome(analysisScheme)(_.analysisScheme(_))
        .build

    def deleteDomainRequest(
      domainName: Option[String] = None
    ): DeleteDomainRequest =
      DeleteDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteDomainResponse(
      domainStatus: Option[DomainStatus] = None
    ): DeleteDomainResponse =
      DeleteDomainResponse
        .builder
        .ifSome(domainStatus)(_.domainStatus(_))
        .build

    def deleteExpressionRequest(
      domainName: Option[String] = None,
      expressionName: Option[String] = None
    ): DeleteExpressionRequest =
      DeleteExpressionRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(expressionName)(_.expressionName(_))
        .build

    def deleteExpressionResponse(
      expression: Option[ExpressionStatus] = None
    ): DeleteExpressionResponse =
      DeleteExpressionResponse
        .builder
        .ifSome(expression)(_.expression(_))
        .build

    def deleteIndexFieldRequest(
      domainName: Option[String] = None,
      indexFieldName: Option[String] = None
    ): DeleteIndexFieldRequest =
      DeleteIndexFieldRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .build

    def deleteIndexFieldResponse(
      indexField: Option[IndexFieldStatus] = None
    ): DeleteIndexFieldResponse =
      DeleteIndexFieldResponse
        .builder
        .ifSome(indexField)(_.indexField(_))
        .build

    def deleteSuggesterRequest(
      domainName: Option[String] = None,
      suggesterName: Option[String] = None
    ): DeleteSuggesterRequest =
      DeleteSuggesterRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(suggesterName)(_.suggesterName(_))
        .build

    def deleteSuggesterResponse(
      suggester: Option[SuggesterStatus] = None
    ): DeleteSuggesterResponse =
      DeleteSuggesterResponse
        .builder
        .ifSome(suggester)(_.suggester(_))
        .build

    def describeAnalysisSchemesRequest(
      domainName: Option[String] = None,
      analysisSchemeNames: Option[List[StandardName]] = None,
      deployed: Option[Boolean] = None
    ): DescribeAnalysisSchemesRequest =
      DescribeAnalysisSchemesRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(analysisSchemeNames)(_.analysisSchemeNames(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeAnalysisSchemesResponse(
      analysisSchemes: Option[List[AnalysisSchemeStatus]] = None
    ): DescribeAnalysisSchemesResponse =
      DescribeAnalysisSchemesResponse
        .builder
        .ifSome(analysisSchemes)(_.analysisSchemes(_))
        .build

    def describeAvailabilityOptionsRequest(
      domainName: Option[String] = None,
      deployed: Option[Boolean] = None
    ): DescribeAvailabilityOptionsRequest =
      DescribeAvailabilityOptionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeAvailabilityOptionsResponse(
      availabilityOptions: Option[AvailabilityOptionsStatus] = None
    ): DescribeAvailabilityOptionsResponse =
      DescribeAvailabilityOptionsResponse
        .builder
        .ifSome(availabilityOptions)(_.availabilityOptions(_))
        .build

    def describeDomainEndpointOptionsRequest(
      domainName: Option[String] = None,
      deployed: Option[Boolean] = None
    ): DescribeDomainEndpointOptionsRequest =
      DescribeDomainEndpointOptionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeDomainEndpointOptionsResponse(
      domainEndpointOptions: Option[DomainEndpointOptionsStatus] = None
    ): DescribeDomainEndpointOptionsResponse =
      DescribeDomainEndpointOptionsResponse
        .builder
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .build

    def describeDomainsRequest(
      domainNames: Option[List[DomainName]] = None
    ): DescribeDomainsRequest =
      DescribeDomainsRequest
        .builder
        .ifSome(domainNames)(_.domainNames(_))
        .build

    def describeDomainsResponse(
      domainStatusList: Option[List[DomainStatus]] = None
    ): DescribeDomainsResponse =
      DescribeDomainsResponse
        .builder
        .ifSome(domainStatusList)(_.domainStatusList(_))
        .build

    def describeExpressionsRequest(
      domainName: Option[String] = None,
      expressionNames: Option[List[StandardName]] = None,
      deployed: Option[Boolean] = None
    ): DescribeExpressionsRequest =
      DescribeExpressionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(expressionNames)(_.expressionNames(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeExpressionsResponse(
      expressions: Option[List[ExpressionStatus]] = None
    ): DescribeExpressionsResponse =
      DescribeExpressionsResponse
        .builder
        .ifSome(expressions)(_.expressions(_))
        .build

    def describeIndexFieldsRequest(
      domainName: Option[String] = None,
      fieldNames: Option[List[DynamicFieldName]] = None,
      deployed: Option[Boolean] = None
    ): DescribeIndexFieldsRequest =
      DescribeIndexFieldsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(fieldNames)(_.fieldNames(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeIndexFieldsResponse(
      indexFields: Option[List[IndexFieldStatus]] = None
    ): DescribeIndexFieldsResponse =
      DescribeIndexFieldsResponse
        .builder
        .ifSome(indexFields)(_.indexFields(_))
        .build

    def describeScalingParametersRequest(
      domainName: Option[String] = None
    ): DescribeScalingParametersRequest =
      DescribeScalingParametersRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def describeScalingParametersResponse(
      scalingParameters: Option[ScalingParametersStatus] = None
    ): DescribeScalingParametersResponse =
      DescribeScalingParametersResponse
        .builder
        .ifSome(scalingParameters)(_.scalingParameters(_))
        .build

    def describeServiceAccessPoliciesRequest(
      domainName: Option[String] = None,
      deployed: Option[Boolean] = None
    ): DescribeServiceAccessPoliciesRequest =
      DescribeServiceAccessPoliciesRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeServiceAccessPoliciesResponse(
      accessPolicies: Option[AccessPoliciesStatus] = None
    ): DescribeServiceAccessPoliciesResponse =
      DescribeServiceAccessPoliciesResponse
        .builder
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .build

    def describeSuggestersRequest(
      domainName: Option[String] = None,
      suggesterNames: Option[List[StandardName]] = None,
      deployed: Option[Boolean] = None
    ): DescribeSuggestersRequest =
      DescribeSuggestersRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(suggesterNames)(_.suggesterNames(_))
        .ifSome(deployed)(_.deployed(_))
        .build

    def describeSuggestersResponse(
      suggesters: Option[List[SuggesterStatus]] = None
    ): DescribeSuggestersResponse =
      DescribeSuggestersResponse
        .builder
        .ifSome(suggesters)(_.suggesters(_))
        .build

    def disabledOperationException(

    ): DisabledOperationException =
      DisabledOperationException
        .builder

        .build

    def documentSuggesterOptions(
      sourceField: Option[String] = None,
      fuzzyMatching: Option[String] = None,
      sortExpression: Option[String] = None
    ): DocumentSuggesterOptions =
      DocumentSuggesterOptions
        .builder
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(fuzzyMatching)(_.fuzzyMatching(_))
        .ifSome(sortExpression)(_.sortExpression(_))
        .build

    def domainEndpointOptions(
      enforceHTTPS: Option[Boolean] = None,
      tLSSecurityPolicy: Option[String] = None
    ): DomainEndpointOptions =
      DomainEndpointOptions
        .builder
        .ifSome(enforceHTTPS)(_.enforceHTTPS(_))
        .ifSome(tLSSecurityPolicy)(_.tLSSecurityPolicy(_))
        .build

    def domainEndpointOptionsStatus(
      options: Option[DomainEndpointOptions] = None,
      status: Option[OptionStatus] = None
    ): DomainEndpointOptionsStatus =
      DomainEndpointOptionsStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def domainStatus(
      domainId: Option[String] = None,
      domainName: Option[String] = None,
      aRN: Option[String] = None,
      created: Option[Boolean] = None,
      deleted: Option[Boolean] = None,
      docService: Option[ServiceEndpoint] = None,
      searchService: Option[ServiceEndpoint] = None,
      requiresIndexDocuments: Option[Boolean] = None,
      processing: Option[Boolean] = None,
      searchInstanceType: Option[String] = None,
      searchPartitionCount: Option[Int] = None,
      searchInstanceCount: Option[Int] = None,
      limits: Option[Limits] = None
    ): DomainStatus =
      DomainStatus
        .builder
        .ifSome(domainId)(_.domainId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(created)(_.created(_))
        .ifSome(deleted)(_.deleted(_))
        .ifSome(docService)(_.docService(_))
        .ifSome(searchService)(_.searchService(_))
        .ifSome(requiresIndexDocuments)(_.requiresIndexDocuments(_))
        .ifSome(processing)(_.processing(_))
        .ifSome(searchInstanceType)(_.searchInstanceType(_))
        .ifSome(searchPartitionCount)(_.searchPartitionCount(_))
        .ifSome(searchInstanceCount)(_.searchInstanceCount(_))
        .ifSome(limits)(_.limits(_))
        .build

    def doubleArrayOptions(
      defaultValue: Option[Double] = None,
      sourceFields: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None
    ): DoubleArrayOptions =
      DoubleArrayOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .build

    def doubleOptions(
      defaultValue: Option[Double] = None,
      sourceField: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None,
      sortEnabled: Option[Boolean] = None
    ): DoubleOptions =
      DoubleOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(sortEnabled)(_.sortEnabled(_))
        .build

    def expression(
      expressionName: Option[String] = None,
      expressionValue: Option[String] = None
    ): Expression =
      Expression
        .builder
        .ifSome(expressionName)(_.expressionName(_))
        .ifSome(expressionValue)(_.expressionValue(_))
        .build

    def expressionStatus(
      options: Option[Expression] = None,
      status: Option[OptionStatus] = None
    ): ExpressionStatus =
      ExpressionStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def indexDocumentsRequest(
      domainName: Option[String] = None
    ): IndexDocumentsRequest =
      IndexDocumentsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def indexDocumentsResponse(
      fieldNames: Option[List[FieldName]] = None
    ): IndexDocumentsResponse =
      IndexDocumentsResponse
        .builder
        .ifSome(fieldNames)(_.fieldNames(_))
        .build

    def indexField(
      indexFieldName: Option[String] = None,
      indexFieldType: Option[String] = None,
      intOptions: Option[IntOptions] = None,
      doubleOptions: Option[DoubleOptions] = None,
      literalOptions: Option[LiteralOptions] = None,
      textOptions: Option[TextOptions] = None,
      dateOptions: Option[DateOptions] = None,
      latLonOptions: Option[LatLonOptions] = None,
      intArrayOptions: Option[IntArrayOptions] = None,
      doubleArrayOptions: Option[DoubleArrayOptions] = None,
      literalArrayOptions: Option[LiteralArrayOptions] = None,
      textArrayOptions: Option[TextArrayOptions] = None,
      dateArrayOptions: Option[DateArrayOptions] = None
    ): IndexField =
      IndexField
        .builder
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .ifSome(indexFieldType)(_.indexFieldType(_))
        .ifSome(intOptions)(_.intOptions(_))
        .ifSome(doubleOptions)(_.doubleOptions(_))
        .ifSome(literalOptions)(_.literalOptions(_))
        .ifSome(textOptions)(_.textOptions(_))
        .ifSome(dateOptions)(_.dateOptions(_))
        .ifSome(latLonOptions)(_.latLonOptions(_))
        .ifSome(intArrayOptions)(_.intArrayOptions(_))
        .ifSome(doubleArrayOptions)(_.doubleArrayOptions(_))
        .ifSome(literalArrayOptions)(_.literalArrayOptions(_))
        .ifSome(textArrayOptions)(_.textArrayOptions(_))
        .ifSome(dateArrayOptions)(_.dateArrayOptions(_))
        .build

    def indexFieldStatus(
      options: Option[IndexField] = None,
      status: Option[OptionStatus] = None
    ): IndexFieldStatus =
      IndexFieldStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def intArrayOptions(
      defaultValue: Option[Long] = None,
      sourceFields: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None
    ): IntArrayOptions =
      IntArrayOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .build

    def intOptions(
      defaultValue: Option[Long] = None,
      sourceField: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None,
      sortEnabled: Option[Boolean] = None
    ): IntOptions =
      IntOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(sortEnabled)(_.sortEnabled(_))
        .build

    def internalException(

    ): InternalException =
      InternalException
        .builder

        .build

    def invalidTypeException(

    ): InvalidTypeException =
      InvalidTypeException
        .builder

        .build

    def latLonOptions(
      defaultValue: Option[String] = None,
      sourceField: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None,
      sortEnabled: Option[Boolean] = None
    ): LatLonOptions =
      LatLonOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(sortEnabled)(_.sortEnabled(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def limits(
      maximumReplicationCount: Option[Int] = None,
      maximumPartitionCount: Option[Int] = None
    ): Limits =
      Limits
        .builder
        .ifSome(maximumReplicationCount)(_.maximumReplicationCount(_))
        .ifSome(maximumPartitionCount)(_.maximumPartitionCount(_))
        .build

    def listDomainNamesResponse(
      domainNames: Option[DomainNameMap] = None
    ): ListDomainNamesResponse =
      ListDomainNamesResponse
        .builder
        .ifSome(domainNames)(_.domainNames(_))
        .build

    def literalArrayOptions(
      defaultValue: Option[String] = None,
      sourceFields: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None
    ): LiteralArrayOptions =
      LiteralArrayOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .build

    def literalOptions(
      defaultValue: Option[String] = None,
      sourceField: Option[String] = None,
      facetEnabled: Option[Boolean] = None,
      searchEnabled: Option[Boolean] = None,
      returnEnabled: Option[Boolean] = None,
      sortEnabled: Option[Boolean] = None
    ): LiteralOptions =
      LiteralOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(facetEnabled)(_.facetEnabled(_))
        .ifSome(searchEnabled)(_.searchEnabled(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(sortEnabled)(_.sortEnabled(_))
        .build

    def optionStatus(
      creationDate: Option[UpdateTimestamp] = None,
      updateDate: Option[UpdateTimestamp] = None,
      updateVersion: Option[Int] = None,
      state: Option[String] = None,
      pendingDeletion: Option[Boolean] = None
    ): OptionStatus =
      OptionStatus
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(updateVersion)(_.updateVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(pendingDeletion)(_.pendingDeletion(_))
        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def scalingParameters(
      desiredInstanceType: Option[String] = None,
      desiredReplicationCount: Option[Int] = None,
      desiredPartitionCount: Option[Int] = None
    ): ScalingParameters =
      ScalingParameters
        .builder
        .ifSome(desiredInstanceType)(_.desiredInstanceType(_))
        .ifSome(desiredReplicationCount)(_.desiredReplicationCount(_))
        .ifSome(desiredPartitionCount)(_.desiredPartitionCount(_))
        .build

    def scalingParametersStatus(
      options: Option[ScalingParameters] = None,
      status: Option[OptionStatus] = None
    ): ScalingParametersStatus =
      ScalingParametersStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def serviceEndpoint(
      endpoint: Option[String] = None
    ): ServiceEndpoint =
      ServiceEndpoint
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def suggester(
      suggesterName: Option[String] = None,
      documentSuggesterOptions: Option[DocumentSuggesterOptions] = None
    ): Suggester =
      Suggester
        .builder
        .ifSome(suggesterName)(_.suggesterName(_))
        .ifSome(documentSuggesterOptions)(_.documentSuggesterOptions(_))
        .build

    def suggesterStatus(
      options: Option[Suggester] = None,
      status: Option[OptionStatus] = None
    ): SuggesterStatus =
      SuggesterStatus
        .builder
        .ifSome(options)(_.options(_))
        .ifSome(status)(_.status(_))
        .build

    def textArrayOptions(
      defaultValue: Option[String] = None,
      sourceFields: Option[String] = None,
      returnEnabled: Option[Boolean] = None,
      highlightEnabled: Option[Boolean] = None,
      analysisScheme: Option[String] = None
    ): TextArrayOptions =
      TextArrayOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(highlightEnabled)(_.highlightEnabled(_))
        .ifSome(analysisScheme)(_.analysisScheme(_))
        .build

    def textOptions(
      defaultValue: Option[String] = None,
      sourceField: Option[String] = None,
      returnEnabled: Option[Boolean] = None,
      sortEnabled: Option[Boolean] = None,
      highlightEnabled: Option[Boolean] = None,
      analysisScheme: Option[String] = None
    ): TextOptions =
      TextOptions
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(sourceField)(_.sourceField(_))
        .ifSome(returnEnabled)(_.returnEnabled(_))
        .ifSome(sortEnabled)(_.sortEnabled(_))
        .ifSome(highlightEnabled)(_.highlightEnabled(_))
        .ifSome(analysisScheme)(_.analysisScheme(_))
        .build

    def updateAvailabilityOptionsRequest(
      domainName: Option[String] = None,
      multiAZ: Option[Boolean] = None
    ): UpdateAvailabilityOptionsRequest =
      UpdateAvailabilityOptionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .build

    def updateAvailabilityOptionsResponse(
      availabilityOptions: Option[AvailabilityOptionsStatus] = None
    ): UpdateAvailabilityOptionsResponse =
      UpdateAvailabilityOptionsResponse
        .builder
        .ifSome(availabilityOptions)(_.availabilityOptions(_))
        .build

    def updateDomainEndpointOptionsRequest(
      domainName: Option[String] = None,
      domainEndpointOptions: Option[DomainEndpointOptions] = None
    ): UpdateDomainEndpointOptionsRequest =
      UpdateDomainEndpointOptionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .build

    def updateDomainEndpointOptionsResponse(
      domainEndpointOptions: Option[DomainEndpointOptionsStatus] = None
    ): UpdateDomainEndpointOptionsResponse =
      UpdateDomainEndpointOptionsResponse
        .builder
        .ifSome(domainEndpointOptions)(_.domainEndpointOptions(_))
        .build

    def updateScalingParametersRequest(
      domainName: Option[String] = None,
      scalingParameters: Option[ScalingParameters] = None
    ): UpdateScalingParametersRequest =
      UpdateScalingParametersRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(scalingParameters)(_.scalingParameters(_))
        .build

    def updateScalingParametersResponse(
      scalingParameters: Option[ScalingParametersStatus] = None
    ): UpdateScalingParametersResponse =
      UpdateScalingParametersResponse
        .builder
        .ifSome(scalingParameters)(_.scalingParameters(_))
        .build

    def updateServiceAccessPoliciesRequest(
      domainName: Option[String] = None,
      accessPolicies: Option[String] = None
    ): UpdateServiceAccessPoliciesRequest =
      UpdateServiceAccessPoliciesRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .build

    def updateServiceAccessPoliciesResponse(
      accessPolicies: Option[AccessPoliciesStatus] = None
    ): UpdateServiceAccessPoliciesResponse =
      UpdateServiceAccessPoliciesResponse
        .builder
        .ifSome(accessPolicies)(_.accessPolicies(_))
        .build

    def validationException(

    ): ValidationException =
      ValidationException
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
