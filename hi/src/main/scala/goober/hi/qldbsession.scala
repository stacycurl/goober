package goober.hi

import goober.free.qldbsession.QldbSessionIO
import software.amazon.awssdk.services.qldbsession.model._


object qldbsession {
  import goober.free.{qldbsession ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abortTransactionRequest(

    ): AbortTransactionRequest =
      AbortTransactionRequest
        .builder

        .build

    def badRequestException(
      message: Option[String] = None,
      code: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def capacityExceededException(
      message: Option[String] = None
    ): CapacityExceededException =
      CapacityExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def commitTransactionRequest(
      transactionId: Option[String] = None,
      commitDigest: Option[CommitDigest] = None
    ): CommitTransactionRequest =
      CommitTransactionRequest
        .builder
        .ifSome(transactionId)(_.transactionId(_))
        .ifSome(commitDigest)(_.commitDigest(_))
        .build

    def endSessionRequest(

    ): EndSessionRequest =
      EndSessionRequest
        .builder

        .build

    def executeStatementRequest(
      transactionId: Option[String] = None,
      statement: Option[String] = None,
      parameters: Option[List[ValueHolder]] = None
    ): ExecuteStatementRequest =
      ExecuteStatementRequest
        .builder
        .ifSome(transactionId)(_.transactionId(_))
        .ifSome(statement)(_.statement(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def fetchPageRequest(
      transactionId: Option[String] = None,
      nextPageToken: Option[String] = None
    ): FetchPageRequest =
      FetchPageRequest
        .builder
        .ifSome(transactionId)(_.transactionId(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def iOUsage(
      readIOs: Option[ReadIOs] = None,
      writeIOs: Option[WriteIOs] = None
    ): IOUsage =
      IOUsage
        .builder
        .ifSome(readIOs)(_.readIOs(_))
        .ifSome(writeIOs)(_.writeIOs(_))
        .build

    def invalidSessionException(
      message: Option[String] = None,
      code: Option[String] = None
    ): InvalidSessionException =
      InvalidSessionException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def occConflictException(
      message: Option[String] = None
    ): OccConflictException =
      OccConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def page(
      values: Option[List[ValueHolder]] = None,
      nextPageToken: Option[String] = None
    ): Page =
      Page
        .builder
        .ifSome(values)(_.values(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def rateExceededException(
      message: Option[String] = None
    ): RateExceededException =
      RateExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sendCommandRequest(
      sessionToken: Option[String] = None,
      startSession: Option[StartSessionRequest] = None,
      startTransaction: Option[StartTransactionRequest] = None,
      endSession: Option[EndSessionRequest] = None,
      commitTransaction: Option[CommitTransactionRequest] = None,
      abortTransaction: Option[AbortTransactionRequest] = None,
      executeStatement: Option[ExecuteStatementRequest] = None,
      fetchPage: Option[FetchPageRequest] = None
    ): SendCommandRequest =
      SendCommandRequest
        .builder
        .ifSome(sessionToken)(_.sessionToken(_))
        .ifSome(startSession)(_.startSession(_))
        .ifSome(startTransaction)(_.startTransaction(_))
        .ifSome(endSession)(_.endSession(_))
        .ifSome(commitTransaction)(_.commitTransaction(_))
        .ifSome(abortTransaction)(_.abortTransaction(_))
        .ifSome(executeStatement)(_.executeStatement(_))
        .ifSome(fetchPage)(_.fetchPage(_))
        .build

    def startSessionRequest(
      ledgerName: Option[String] = None
    ): StartSessionRequest =
      StartSessionRequest
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .build

    def startTransactionRequest(

    ): StartTransactionRequest =
      StartTransactionRequest
        .builder

        .build

    def timingInformation(
      processingTimeMilliseconds: Option[ProcessingTimeMilliseconds] = None
    ): TimingInformation =
      TimingInformation
        .builder
        .ifSome(processingTimeMilliseconds)(_.processingTimeMilliseconds(_))
        .build

    def valueHolder(
      ionBinary: Option[IonBinary] = None,
      ionText: Option[String] = None
    ): ValueHolder =
      ValueHolder
        .builder
        .ifSome(ionBinary)(_.ionBinary(_))
        .ifSome(ionText)(_.ionText(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
