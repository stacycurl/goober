package goober.hi

import goober.free.forecastquery.ForecastqueryIO
import software.amazon.awssdk.services.forecastquery.model._


object forecastquery {
  import goober.free.{forecastquery ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def dataPoint(
      timestamp: Option[String] = None,
      value: Option[Double] = None
    ): DataPoint =
      DataPoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(value)(_.value(_))
        .build

    def forecast(
      predictions: Option[Predictions] = None
    ): Forecast =
      Forecast
        .builder
        .ifSome(predictions)(_.predictions(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
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

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def queryForecastRequest(
      forecastArn: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      filters: Option[Filters] = None,
      nextToken: Option[String] = None
    ): QueryForecastRequest =
      QueryForecastRequest
        .builder
        .ifSome(forecastArn)(_.forecastArn(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def queryForecastResponse(
      forecast: Option[Forecast] = None
    ): QueryForecastResponse =
      QueryForecastResponse
        .builder
        .ifSome(forecast)(_.forecast(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
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

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
