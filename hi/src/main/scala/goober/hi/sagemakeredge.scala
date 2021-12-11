package goober.hi

import goober.free.sagemakeredge.SagemakerEdgeIO
import software.amazon.awssdk.services.sagemakeredge.model._


object sagemakeredge {
  import goober.free.{sagemakeredge ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def edgeMetric(
      dimension: Option[String] = None,
      metricName: Option[String] = None,
      value: Option[Value] = None,
      timestamp: Option[Timestamp] = None
    ): EdgeMetric =
      EdgeMetric
        .builder
        .ifSome(dimension)(_.dimension(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def getDeviceRegistrationRequest(
      deviceName: Option[String] = None,
      deviceFleetName: Option[String] = None
    ): GetDeviceRegistrationRequest =
      GetDeviceRegistrationRequest
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def model(
      modelName: Option[String] = None,
      modelVersion: Option[String] = None,
      latestSampleTime: Option[Timestamp] = None,
      latestInference: Option[Timestamp] = None,
      modelMetrics: Option[List[EdgeMetric]] = None
    ): Model =
      Model
        .builder
        .ifSome(modelName)(_.modelName(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(latestSampleTime)(_.latestSampleTime(_))
        .ifSome(latestInference)(_.latestInference(_))
        .ifSome(modelMetrics)(_.modelMetrics(_))
        .build

    def sendHeartbeatRequest(
      agentMetrics: Option[List[EdgeMetric]] = None,
      models: Option[List[Model]] = None,
      agentVersion: Option[String] = None,
      deviceName: Option[String] = None,
      deviceFleetName: Option[String] = None
    ): SendHeartbeatRequest =
      SendHeartbeatRequest
        .builder
        .ifSome(agentMetrics)(_.agentMetrics(_))
        .ifSome(models)(_.models(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceFleetName)(_.deviceFleetName(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
