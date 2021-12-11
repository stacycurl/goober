package goober.hi

import goober.free.sagemakerfeaturestoreruntime.SageMakerFeatureStoreRuntimeIO
import software.amazon.awssdk.services.sagemakerfeaturestoreruntime.model._


object sagemakerfeaturestoreruntime {
  import goober.free.{sagemakerfeaturestoreruntime ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessForbidden(
      message: Option[String] = None
    ): AccessForbidden =
      AccessForbidden
        .builder
        .ifSome(message)(_.message(_))
        .build

    def batchGetRecordError(
      featureGroupName: Option[String] = None,
      recordIdentifierValueAsString: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchGetRecordError =
      BatchGetRecordError
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierValueAsString)(_.recordIdentifierValueAsString(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchGetRecordIdentifier(
      featureGroupName: Option[String] = None,
      recordIdentifiersValueAsString: Option[List[ValueAsString]] = None,
      featureNames: Option[List[FeatureName]] = None
    ): BatchGetRecordIdentifier =
      BatchGetRecordIdentifier
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifiersValueAsString)(_.recordIdentifiersValueAsString(_))
        .ifSome(featureNames)(_.featureNames(_))
        .build

    def batchGetRecordRequest(
      identifiers: Option[List[BatchGetRecordIdentifier]] = None
    ): BatchGetRecordRequest =
      BatchGetRecordRequest
        .builder
        .ifSome(identifiers)(_.identifiers(_))
        .build

    def batchGetRecordResponse(
      records: Option[List[BatchGetRecordResultDetail]] = None,
      errors: Option[List[BatchGetRecordError]] = None,
      unprocessedIdentifiers: Option[List[BatchGetRecordIdentifier]] = None
    ): BatchGetRecordResponse =
      BatchGetRecordResponse
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(unprocessedIdentifiers)(_.unprocessedIdentifiers(_))
        .build

    def batchGetRecordResultDetail(
      featureGroupName: Option[String] = None,
      recordIdentifierValueAsString: Option[String] = None,
      record: Option[List[FeatureValue]] = None
    ): BatchGetRecordResultDetail =
      BatchGetRecordResultDetail
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierValueAsString)(_.recordIdentifierValueAsString(_))
        .ifSome(record)(_.record(_))
        .build

    def deleteRecordRequest(
      featureGroupName: Option[String] = None,
      recordIdentifierValueAsString: Option[String] = None,
      eventTime: Option[String] = None
    ): DeleteRecordRequest =
      DeleteRecordRequest
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierValueAsString)(_.recordIdentifierValueAsString(_))
        .ifSome(eventTime)(_.eventTime(_))
        .build

    def featureValue(
      featureName: Option[String] = None,
      valueAsString: Option[String] = None
    ): FeatureValue =
      FeatureValue
        .builder
        .ifSome(featureName)(_.featureName(_))
        .ifSome(valueAsString)(_.valueAsString(_))
        .build

    def getRecordRequest(
      featureGroupName: Option[String] = None,
      recordIdentifierValueAsString: Option[String] = None,
      featureNames: Option[List[FeatureName]] = None
    ): GetRecordRequest =
      GetRecordRequest
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(recordIdentifierValueAsString)(_.recordIdentifierValueAsString(_))
        .ifSome(featureNames)(_.featureNames(_))
        .build

    def getRecordResponse(
      record: Option[List[FeatureValue]] = None
    ): GetRecordResponse =
      GetRecordResponse
        .builder
        .ifSome(record)(_.record(_))
        .build

    def internalFailure(
      message: Option[String] = None
    ): InternalFailure =
      InternalFailure
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putRecordRequest(
      featureGroupName: Option[String] = None,
      record: Option[List[FeatureValue]] = None
    ): PutRecordRequest =
      PutRecordRequest
        .builder
        .ifSome(featureGroupName)(_.featureGroupName(_))
        .ifSome(record)(_.record(_))
        .build

    def resourceNotFound(
      message: Option[String] = None
    ): ResourceNotFound =
      ResourceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailable(
      message: Option[String] = None
    ): ServiceUnavailable =
      ServiceUnavailable
        .builder
        .ifSome(message)(_.message(_))
        .build

    def validationError(
      message: Option[String] = None
    ): ValidationError =
      ValidationError
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
