package goober.hi

import goober.free.finspacedata.FinspaceDataIO
import software.amazon.awssdk.services.finspacedata.model._


object finspacedata {
  import goober.free.{finspacedata ⇒ free}

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

    def changesetInfo(
      id: Option[String] = None,
      changesetArn: Option[String] = None,
      datasetId: Option[String] = None,
      changeType: Option[String] = None,
      sourceType: Option[String] = None,
      sourceParams: Option[stringMap] = None,
      formatType: Option[String] = None,
      formatParams: Option[stringMap] = None,
      createTimestamp: Option[Timestamp] = None,
      status: Option[String] = None,
      errorInfo: Option[ErrorInfo] = None,
      changesetLabels: Option[stringMap] = None,
      updatesChangesetId: Option[String] = None,
      updatedByChangesetId: Option[String] = None
    ): ChangesetInfo =
      ChangesetInfo
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(changesetArn)(_.changesetArn(_))
        .ifSome(datasetId)(_.datasetId(_))
        .ifSome(changeType)(_.changeType(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceParams)(_.sourceParams(_))
        .ifSome(formatType)(_.formatType(_))
        .ifSome(formatParams)(_.formatParams(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorInfo)(_.errorInfo(_))
        .ifSome(changesetLabels)(_.changesetLabels(_))
        .ifSome(updatesChangesetId)(_.updatesChangesetId(_))
        .ifSome(updatedByChangesetId)(_.updatedByChangesetId(_))
        .build

    def createChangesetRequest(
      datasetId: Option[String] = None,
      changeType: Option[String] = None,
      sourceType: Option[String] = None,
      sourceParams: Option[stringMap] = None,
      formatType: Option[String] = None,
      formatParams: Option[stringMap] = None,
      tags: Option[stringMap] = None
    ): CreateChangesetRequest =
      CreateChangesetRequest
        .builder
        .ifSome(datasetId)(_.datasetId(_))
        .ifSome(changeType)(_.changeType(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceParams)(_.sourceParams(_))
        .ifSome(formatType)(_.formatType(_))
        .ifSome(formatParams)(_.formatParams(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChangesetResponse(
      changeset: Option[ChangesetInfo] = None
    ): CreateChangesetResponse =
      CreateChangesetResponse
        .builder
        .ifSome(changeset)(_.changeset(_))
        .build

    def credentials(
      accessKeyId: Option[String] = None,
      secretAccessKey: Option[String] = None,
      sessionToken: Option[String] = None
    ): Credentials =
      Credentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(sessionToken)(_.sessionToken(_))
        .build

    def errorInfo(
      errorMessage: Option[String] = None,
      errorCategory: Option[String] = None
    ): ErrorInfo =
      ErrorInfo
        .builder
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorCategory)(_.errorCategory(_))
        .build

    def getProgrammaticAccessCredentialsRequest(
      durationInMinutes: Option[SessionDuration] = None,
      environmentId: Option[String] = None
    ): GetProgrammaticAccessCredentialsRequest =
      GetProgrammaticAccessCredentialsRequest
        .builder
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def getProgrammaticAccessCredentialsResponse(
      credentials: Option[Credentials] = None,
      durationInMinutes: Option[SessionDuration] = None
    ): GetProgrammaticAccessCredentialsResponse =
      GetProgrammaticAccessCredentialsResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .build

    def getWorkingLocationRequest(
      locationType: Option[String] = None
    ): GetWorkingLocationRequest =
      GetWorkingLocationRequest
        .builder
        .ifSome(locationType)(_.locationType(_))
        .build

    def getWorkingLocationResponse(
      s3Uri: Option[String] = None,
      s3Path: Option[String] = None,
      s3Bucket: Option[String] = None
    ): GetWorkingLocationResponse =
      GetWorkingLocationResponse
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(s3Path)(_.s3Path(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
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

    def throttlingException(

    ): ThrottlingException =
      ThrottlingException
        .builder

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
