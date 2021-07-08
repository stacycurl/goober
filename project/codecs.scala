import io.circe.{Codec, Decoder, Encoder, JsonNumber}

import scala.collection.immutable.List


object codecs {
  import syntax._

  object Service {
    private implicit val operationsCodec = Codec.from[Map[String, Operation]](
      Decoder.decodeMap[String, Operation],
      Encoder.encodeMap[String, Operation]
    ).lossless

    private implicit val shapesCodec = Codec.from[Map[String, Shape]](
      Decoder.decodeMap[String, Shape],
      Encoder.encodeMap[String, Shape]
    ).lossless

    implicit val serviceCodec: Codec[Service] = Codec.forProduct6(
      "version",
      "metadata",
      "operations",
      "shapes",
      "authorizers",
      "documentation"
    )(Service.apply)(getSome(Service.unapply)).lossless
  }



  case class Service(
    version: Option[String],
    metadata: MetaData,
    operations: Map[String, Operation],
    shapes: Map[String, ShapeDefinition],
    authorizers: Option[Authorizers],
    documentation: Option[String]
  ) {
    override def toString: String =
      q"""Service(
         |  version = $version,
         |  metadata = $metadata,
         |  operations = $operations,
         |  shapes = $shapes,
         |  authorizers = $authorizers,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object MetaData {
    implicit val metaDataCodec: Codec[MetaData] = Codec.forProduct15(
      "apiVersion",
      "endpointPrefix",
      "globalEndpoint",
      "jsonVersion",
      "checksumFormat",
      "protocol",
      "protocolSettings",
      "serviceAbbreviation",
      "serviceFullName",
      "serviceId",
      "signatureVersion",
      "signingName",
      "targetPrefix",
      "uid",
      "xmlNamespace"
    )(MetaData.apply)(getSome(MetaData.unapply)).lossless
  }

  case class MetaData(
    apiVersion: String,
    endpointPrefix: String,
    globalEndpoint: Option[String],
    jsonVersion: Option[String],
    checksumFormat: Option[String],
    protocol: String,
    protocolSettings: Option[ProtocolSettings],
    serviceAbbreviation: Option[String],
    serviceFullName: String,
    serviceId: String,
    signatureVersion: String,
    signingName: Option[String],
    targetPrefix: Option[String],
    uid: String,
    xmlNamespace: Option[String]
  ) {
    override def toString: String =
      q"""MetaData(
         |  apiVersion = $apiVersion,
         |  endpointPrefix = $endpointPrefix,
         |  globalEndpoint = $globalEndpoint,
         |  jsonVersion = $jsonVersion,
         |  checksumFormat = $checksumFormat,
         |  protocol = $protocol,
         |  protocolSettings = $protocolSettings,
         |  serviceAbbreviation = $serviceAbbreviation,
         |  serviceFullName = $serviceFullName,
         |  serviceId = $serviceId,
         |  signatureVersion = $signatureVersion,
         |  signingName = $signingName,
         |  targetPrefix = $targetPrefix,
         |  uid = $uid,
         |  xmlNamespace = $xmlNamespace
         |)""".stripMargin
  }

  object Authorizers {
    implicit val authorizersCodec: Codec[Authorizers] = Codec.forProduct1(
      "authorization_strategy"
    )(Authorizers.apply)(getSome(Authorizers.unapply)).lossless
  }

  case class Authorizers(
    authorizationStrategy: AuthorizationStrategy
  )

  object AuthorizationStrategy {
    implicit val authorizationStrategyCodec: Codec[AuthorizationStrategy] = Codec.forProduct3(
      "name",
      "type",
      "placement"
    )(AuthorizationStrategy.apply)(getSome(AuthorizationStrategy.unapply)).lossless
  }

  case class AuthorizationStrategy(
    name: String,
    `type`: String,
    placement: AuthorizationPlacement
  ) {
    override def toString: String =
      q"""AuthorizationStrategy(
         |  name = $name,
         |  `type` = ${`type`},
         |  placement = $placement
         |)""".stripMargin
  }

  object AuthorizationPlacement {
    implicit val authorizationPlacementCodec: Codec[AuthorizationPlacement] = Codec.forProduct2(
      "location",
      "name"
    )(AuthorizationPlacement.apply)(getSome(AuthorizationPlacement.unapply)).lossless
  }

  case class AuthorizationPlacement(
    location: String,
    name: String
  ) {
    override def toString: String =
      q"""AuthorizationPlacement(
         |  location = $location
         |  name = $name
         |)""".stripMargin
  }

  object Operation {
    implicit val operationCodec: Codec[Operation] = Codec.forProduct16(
      "name",
      "http",
      "alias",
      "input",
      "output",
      "errors",
      "authtype",
      "endpoint",
      "endpointdiscovery",
      "httpChecksumRequired",
      "idempotent",
      "endpointoperation",
      "deprecated",
      "deprecatedMessage",
      "documentationUrl",
      "documentation"
    )(Operation.apply)(getSome(Operation.unapply)).lossless
  }

  case class Operation(
    name: String,
    http: Http,
    alias: Option[String],
    input: Option[Shape],
    output: Option[Shape],
    errors: Option[List[Shape]],
    authtype: Option[String],
    endpoint: Option[Endpoint],
    endpointDiscovery: Option[EndpointDiscovery],
    endpointoOeration: Option[Boolean],
    httpChecksumRequired: Option[Boolean],
    idempotent: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentationUrl: Option[String],
    documentation: Option[String]
  ) {
    override def toString: String =
      q"""Operation(
         |  name = $name,
         |  http = $http,
         |  alias = $alias,
         |  input = $input,
         |  output = $output,
         |  errors = $errors,
         |  authtype = $authtype,
         |  endpoint = $endpoint,
         |  endpointDiscovery = $endpointDiscovery,
         |  endpointoOeration = $endpointoOeration,
         |  httpChecksumRequired = $httpChecksumRequired,
         |  idempotent = $idempotent,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentationUrl = $documentationUrl,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object Http {
    implicit val httpCodec: Codec[Http] =
      Codec.forProduct3("method", "requestUri", "responseCode")(Http.apply)(getSome(Http.unapply)).lossless
  }

  case class Http(
    method: String,
    requestUri: String,
    responseCode: Option[Int]
  ) {
    override def toString: String =
      q"""Http(method = $method, requestUri = $requestUri, responseCode = $responseCode)""".stripMargin
  }

  object Shape {
    implicit val shapeCodec: Codec[Shape] = Codec.forProduct19(
      "shape",
      "pattern",
      "enum",
      "location",
      "locationName",
      "queryName",
      "resultWrapper",
      "xmlNamespace",
      "box",
      "eventpayload",
      "flattened",
      "hostLabel",
      "idempotencyToken",
      "jsonvalue",
      "streaming",
      "xmlAttribute",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(Shape.apply)(getSome(Shape.unapply)).lossless
  }

  case class Shape(
    shape: String,
    pattern: Option[String],
    enum: Option[List[String]],
    location: Option[String],
    locationName: Option[String],
    queryName: Option[String],
    resultWrapper: Option[String],
    xmlNamespace: Option[XmlNamespace],
    box: Option[Boolean],
    eventpayload: Option[Boolean],
    flattened: Option[Boolean],
    hostLabel: Option[Boolean],
    idempotencyToken: Option[Boolean],
    jsonvalue: Option[Boolean],
    streaming: Option[Boolean],
    xmlAttribute: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) {
    override def toString: String =
      q"""Shape(
         |  shape = $shape,
         |  pattern = $pattern,
         |  enum = enum,
         |  location = $location,
         |  locationName = $locationName,
         |  queryName = $queryName,
         |  resultWrapper = $resultWrapper,
         |  xmlNamespace = $xmlNamespace,
         |  box = $box,
         |  eventpayload = $eventpayload,
         |  flattened = $flattened,
         |  hostLabel = $hostLabel,
         |  idempotencyToken = $idempotencyToken,
         |  jsonvalue = $jsonvalue,
         |  streaming = $streaming,
         |  xmlAttribute = $xmlAttribute,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object ShapeDefinition {
    implicit val shapeDefinitionCodec: Codec[ShapeDefinition] = Codec.from[ShapeDefinition](
      Decoder.instance[ShapeDefinition](cursor ⇒ {
        for {
          shapeType ← cursor.downField("type").as[String]
          result ← shapeType match {
            case "blob"      ⇒ Codec[BlobShapeDefinition].apply(cursor)
            case "boolean"   ⇒ Codec[BooleanShapeDefinition].apply(cursor)
            case "double"    ⇒ Codec[DoubleShapeDefinition].apply(cursor)
            case "float"     ⇒ Codec[FloatShapeDefinition].apply(cursor)
            case "integer"   ⇒ Codec[IntegerShapeDefinition].apply(cursor)
            case "list"      ⇒ Codec[ListShapeDefinition].apply(cursor)
            case "long"      ⇒ Codec[LongShapeDefinition].apply(cursor)
            case "map"       ⇒ Codec[MapShapeDefinition].apply(cursor)
            case "string"    ⇒ Codec[StringShapeDefinition].apply(cursor)
            case "structure" ⇒ Codec[StructureShapeDefinition].apply(cursor)
            case "timestamp" ⇒ Codec[TimestampShapeDefinition].apply(cursor)
            case _           ⇒ Codec[UnknownShapeDefinition].apply(cursor)
          }
        } yield result
      }),
      Encoder.instance[ShapeDefinition] {
        case it: BlobShapeDefinition      ⇒ Codec[BlobShapeDefinition].apply(it)
        case it: BooleanShapeDefinition   ⇒ Codec[BooleanShapeDefinition].apply(it)
        case it: DoubleShapeDefinition    ⇒ Codec[DoubleShapeDefinition].apply(it)
        case it: FloatShapeDefinition     ⇒ Codec[FloatShapeDefinition].apply(it)
        case it: IntegerShapeDefinition   ⇒ Codec[IntegerShapeDefinition].apply(it)
        case it: ListShapeDefinition      ⇒ Codec[ListShapeDefinition].apply(it)
        case it: LongShapeDefinition      ⇒ Codec[LongShapeDefinition].apply(it)
        case it: MapShapeDefinition       ⇒ Codec[MapShapeDefinition].apply(it)
        case it: StringShapeDefinition    ⇒ Codec[StringShapeDefinition].apply(it)
        case it: StructureShapeDefinition ⇒ Codec[StructureShapeDefinition].apply(it)
        case it: TimestampShapeDefinition ⇒ Codec[TimestampShapeDefinition].apply(it)
        case it: UnknownShapeDefinition   ⇒ Codec[UnknownShapeDefinition].apply(it)
      }
    ).lossless
  }

  sealed trait ShapeDefinition

  object DoubleShapeDefinition {
    implicit val doubleShapeDefinitionCodec: Codec[DoubleShapeDefinition] = Codec.forProduct7(
      "type",
      "max",
      "min",
      "box",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(DoubleShapeDefinition.apply)(getSome(DoubleShapeDefinition.unapply)).lossless
  }

  case class DoubleShapeDefinition(
    shapeType: String,
    max: Option[JsonNumber],
    min: Option[JsonNumber],
    box: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""DoubleShapeDefinition(
         |  shapeType = $shapeType,
         |  max = $max,
         |  min = $min,
         |  box = $box,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object FloatShapeDefinition {
    implicit val floatShapeDefinitionCodec: Codec[FloatShapeDefinition] = Codec.forProduct7(
      "type",
      "max",
      "min",
      "box",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(FloatShapeDefinition.apply)(getSome(FloatShapeDefinition.unapply)).lossless
  }

  case class FloatShapeDefinition(
    shapeType: String,
    max: Option[Double],
    min: Option[Double],
    box: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""FloatShapeDefinition(
         |  shapeType = $shapeType,
         |  max = $max,
         |  min = $min,
         |  box = $box,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object IntegerShapeDefinition {
    implicit val integerShapeDefinitionCodec: Codec[IntegerShapeDefinition] = Codec.forProduct7(
      "type",
      "max",
      "min",
      "box",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(IntegerShapeDefinition.apply)(getSome(IntegerShapeDefinition.unapply)).lossless
  }

  case class IntegerShapeDefinition(
    shapeType: String,
    max: Option[Int],
    min: Option[Int],
    box: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""IntegerShapeDefinition(
         |  shapeType = $shapeType,
         |  max = $max,
         |  min = $min,
         |  box = $box,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object BlobShapeDefinition {
    implicit val blobShapeDefinitionCodec: Codec[BlobShapeDefinition] = Codec.forProduct9(
      "type",
      "max",
      "min",
      "requiresLength",
      "sensitive",
      "streaming",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(BlobShapeDefinition.apply)(getSome(BlobShapeDefinition.unapply)).lossless
  }

  case class BlobShapeDefinition(
    shapeType: String,
    max: Option[Long],
    min: Option[Long],
    requiresLength: Option[Boolean],
    sensitive: Option[Boolean],
    streaming: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""BlobShapeDefinition(
         |  shapeType = $shapeType,
         |  max = $max,
         |  min = $min,
         |  requiresLength = $requiresLength,
         |  sensitive = $sensitive,
         |  streaming = $streaming,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object LongShapeDefinition {
    implicit val longShapeDefinitionCodec: Codec[LongShapeDefinition] = Codec.forProduct7(
      "type",
      "max",
      "min",
      "box",
      "deprecated",
      "deprecatedMessage",
      "documentation",
    )(LongShapeDefinition.apply)(getSome(LongShapeDefinition.unapply)).lossless
  }

  case class LongShapeDefinition(
    shapeType: String,
    max: Option[Long],
    min: Option[Long],
    box: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""LongShapeDefinition(
         |  shapeType = $shapeType,
         |  max = $max,
         |  min = $min,
         |  box = $box,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object ListShapeDefinition {
    implicit val listShapeDefinitionCodec: Codec[ListShapeDefinition] = Codec.forProduct10(
      "type",
      "member",
      "max",
      "min",
      "locationName",
      "flattened",
      "sensitive",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(ListShapeDefinition.apply)(getSome(ListShapeDefinition.unapply)).lossless
  }

  case class ListShapeDefinition(
    shapeType: String,
    member: Shape,
    max: Option[Int],
    min: Option[Int],
    locationName: Option[String],
    flattened: Option[Boolean],
    sensitive: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[Boolean],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""ListShapeDefinition(
         |  shapeType = $shapeType,
         |  member = $member,
         |  max = $max,
         |  min = $min,
         |  locationName = $locationName,
         |  flattened = $flattened,
         |  sensitive = $sensitive,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object MapShapeDefinition {
    implicit val integerShapeDefinitionCodec: Codec[MapShapeDefinition] = Codec.forProduct9(
      "type",
      "key",
      "value",
      "max",
      "min",
      "locationName",
      "flattened",
      "sensitive",
      "documentation"
    )(MapShapeDefinition.apply)(getSome(MapShapeDefinition.unapply)).lossless
  }

  case class MapShapeDefinition(
    shapeType: String,
    key: Shape,
    value: Shape,
    max: Option[Int],
    min: Option[Int],
    locationName: Option[String],
    flattened: Option[Boolean],
    sensitive: Option[Boolean],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""MapShapeDefinition(
         |  shapeType = $shapeType,
         |  key = $key,
         |  value = $value,
         |  max = $max,
         |  min = $min,
         |  locationName = $locationName,
         |  flattened = $flattened,
         |  sensitive = $sensitive,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object StringShapeDefinition {
    implicit val stringShapeDefinitionCodec: Codec[StringShapeDefinition] = Codec.forProduct9(
      "type",
      "max",
      "min",
      "pattern",
      "enum",
      "sensitive",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(StringShapeDefinition.apply)(getSome(StringShapeDefinition.unapply)).lossless
  }

  case class StringShapeDefinition(
    shapeType: String,
    max: Option[Int],
    min: Option[Int],
    pattern: Option[String],
    enum: Option[List[String]],
    sensitive: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""StringShapeDefinition(
         |  shapeType = $shapeType,
         |  max = $max,
         |  min = $min,
         |  pattern = $pattern,
         |  enum = $enum,
         |  sensitive = $sensitive,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object StructureShapeDefinition {
    implicit val structureShapeDefinitionCodec: Codec[StructureShapeDefinition] = Codec.forProduct21(
      "type",
      "required",
      "xmlOrder",
      "xmlNamespace",
      "members",
      "error",
      "payload",
      "locationName",
      "retryable",
      "box",
      "event",
      "eventstream",
      "exception",
      "fault",
      "sensitive",
      "synthetic",
      "union",
      "wrapper",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(StructureShapeDefinition.apply)(getSome(StructureShapeDefinition.unapply)).lossless
  }

  case class StructureShapeDefinition(
    shapeType: String,
    required: Option[List[String]],
    xmlOrder: Option[List[String]],
    xmlNamespace: Option[XmlNamespace],
    members: Map[String, Shape],
    error: Option[StructureError],
    payload: Option[String],
    locationName: Option[String],
    retryable: Option[Retryable],
    box: Option[Boolean],
    event: Option[Boolean],
    eventstream: Option[Boolean],
    exception: Option[Boolean],
    fault: Option[Boolean],
    sensitive: Option[Boolean],
    synthetic: Option[Boolean],
    union: Option[Boolean],
    wrapper: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""StructureShapeDefinition(
         |  shapeType = $shapeType,
         |  required = $required,
         |  xmlOrder = $xmlOrder,
         |  xmlNamespace = $xmlNamespace,
         |  members = $members,
         |  error = $error,
         |  payload = $payload
         |  locationName = $locationName
         |  retryable = $retryable,
         |  box = $box,
         |  event = $event,
         |  eventstream = $eventstream,
         |  exception = $exception,
         |  fault = $fault,
         |  sensitive = $sensitive,
         |  synthetic = $synthetic,
         |  union = $union,
         |  wrapper = $wrapper,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         )""".stripMargin
  }

  object StructureError {
    implicit val structureErrorCodec: Codec[StructureError] =
      Codec.forProduct1("httpStatusCode")(StructureError.apply)(getSome(StructureError.unapply))
  }

  case class StructureError(
    httpStatusCode: Int
  )

  object TimestampShapeDefinition {
    implicit val timestampShapeDefinitionCodec: Codec[TimestampShapeDefinition] = Codec.forProduct3(
      "type",
      "timestampFormat",
      "documentation"
    )(TimestampShapeDefinition.apply)(getSome(TimestampShapeDefinition.unapply)).lossless
  }

  case class TimestampShapeDefinition(
    shapeType: String,
    timestampFormat: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""TimestampShapeDefinition(
         |  shapeType = $shapeType,
         |  timestampFormat = $timestampFormat,
         |  documentation = $documentation
         |)"""
  }


  object UnknownShapeDefinition {
    implicit val unknownShapeDefinitionCodec: Codec[UnknownShapeDefinition] =
      Codec.forProduct1("type")(UnknownShapeDefinition.apply)(getSome(UnknownShapeDefinition.unapply))
  }

  case class UnknownShapeDefinition(shapeType: String) extends ShapeDefinition {
    override def toString: String =
      q"""UnknownShapeDefinition(shapeType = $shapeType)"""
  }

  object BooleanShapeDefinition {
    implicit val booleanShapeDefinitionCodec: Codec[BooleanShapeDefinition] = Codec.forProduct5(
      "type",
      "box",
      "deprecated",
      "deprecatedMessage",
      "documentation"
    )(BooleanShapeDefinition.apply)(getSome(BooleanShapeDefinition.unapply)).lossless
  }

  case class BooleanShapeDefinition(
    shapeType: String,
    box: Option[Boolean],
    deprecated: Option[Boolean],
    deprecatedMessage: Option[String],
    documentation: Option[String]
  ) extends ShapeDefinition {
    override def toString: String =
      q"""BooleanShapeDefinition(
         |  shapeType = $shapeType,
         |  box = $box,
         |  deprecated = $deprecated,
         |  deprecatedMessage = $deprecatedMessage,
         |  documentation = $documentation
         |)""".stripMargin
  }

  object Retryable {
    implicit val retryableCodec: Codec[Retryable] =
      Codec.forProduct1("throttling")(Retryable.apply)(getSome(Retryable.unapply)).lossless
  }

  case class Retryable(
    throttling: Boolean
  )

  object ProtocolSettings {
    implicit val protocolSettingsCodec: Codec[ProtocolSettings] =
      Codec.forProduct1("h2")(ProtocolSettings.apply)(getSome(ProtocolSettings.unapply)).lossless
  }

  case class ProtocolSettings(
    h2: String
  )

  object Endpoint {
    implicit val endpointCodec: Codec[Endpoint] =
      Codec.forProduct1("hostPrefix")(Endpoint.apply)(getSome(Endpoint.unapply)).lossless
  }

  case class Endpoint(
    hostPrefix: String
  )

  object EndpointDiscovery {
    implicit val endpointDiscoveryCodec: Codec[EndpointDiscovery] =
      Codec.forProduct1("required")(EndpointDiscovery.apply)(getSome(EndpointDiscovery.unapply)).lossless
  }

  case class EndpointDiscovery(
    required: Option[Boolean]
  )

  object XmlNamespace {
    implicit val xmlNamespaceCodec: Codec[XmlNamespace] =
      Codec.forProduct2("prefix", "uri")(XmlNamespace.apply)(getSome(XmlNamespace.unapply)).lossless
  }

  case class XmlNamespace(
    prefix: Option[String],
    uri: String
  )
}
