import java.io.File
import codecs.Service.handleDecode
import io.circe.CursorOp.DownField
import io.circe.parser.decode
import io.circe.{Codec, Decoder, DecodingFailure, Encoder, Error, JsonNumber}

import scala.collection.immutable.List
import scala.io.Source


object codecs {
  import common._
  import syntax._

  case class Services(
    values: List[Service]
  ) extends {
    override def toString: String =
      q"""object Services(
         |  val values: List[Service] = $values
         |)""".stripMargin
  }

  object Service extends Client.Companion {
    implicit val serviceCodec: Codec[Service] = {
      Codec.forProduct6(
        "version",
        "metadata",
        "operations",
        "shapes",
        "authorizers",
        "documentation"
      )(Service.apply)(getSome(Service.unapply)).lossless
    }

    def discover: List[Client] = {
      val jsonFileNames: List[JsonFileNames] =
        JsonFileNames.discover().distinct.sorted
//          .filter(_.serviceJsonFile.toLowerCase.contains("dynamo"))

//      jsonFileNames.foreach(println)

      val result: List[Either[Error, Service]] =
        jsonFileNames.map(_.decodeService)

      val (errors, services) =
        result.partitionEithers

      //    ScalaFile("services.scala", Services(services).toString)
      //      .writeTo(".")

//      println(s"${jsonFileNames.length} total")
//      println(s"${errors.length} errors")
//      println(s"${services.length} services")

      services
    }

    def handleDecode(file: String, result: Either[Error, Service]): Either[Error, Service] = {
      result match {
        case Left(DecodingFailure(message, ops)) ⇒ Console.err.println(
          s"""
             |file: $file
             |
             |error: ${ops.reverse.map(opString).mkString(".")}
             |  $message
             |
             |""".stripMargin
        )
        case Right(_) ⇒ {

        }
      }

      result
    }

    private val opString: io.circe.CursorOp ⇒ String = {
      case DownField(field) ⇒ field
      case other => other.toString
    }

  }

  object JsonFileNames {
    implicit val jsonFileNamesOrdering: Ordering[JsonFileNames] =
      Ordering[String].on[JsonFileNames](_.serviceJsonFile)

    def recursivelyFind(dir: File)(p: File ⇒ Boolean): List[File] = {
      def loop(dir: File): List[File] = {
        dir.listFiles().flatMap(file ⇒ {
          if (file.isDirectory) loop(file) else Some(file).filter(p)
        })(collection.breakOut)
      }

      loop(dir)
    }

    def discover(): List[JsonFileNames] = for {
      serviceJsonFile ← recursivelyFind(new File(JsonFileNames.awsServices))(file ⇒ {
        file.getName == "service-2.json"
      })
      if serviceJsonFile.exists()
      if !excludedServices.exists(excluded ⇒ serviceJsonFile.getAbsolutePath.contains(excluded))
    } yield JsonFileNames(serviceJsonFile.getAbsolutePath)

    private def fileContents(file: String): String =
      withSource(file)(_.mkString(""))

    private def withSource[A](file: String)(f: Source ⇒ A): A = {
      val source = Source.fromFile(file)

      try f(source) finally source.close
    }

    private val awsServices: String =
      "project/aws-sdk-java-v2/services"

    private val codegenResources: String =
      "src/main/resources/codegen-resources"

    private val excludedServices: Set[String] = Set(
      "transcribestreaming"
    )
  }

  case class JsonFileNames(serviceJsonFile: String) {
    // TODO use customisation json
    def decodeService: Either[Error, Service] = {
      handleDecode(serviceJsonFile, decode[Service](JsonFileNames.fileContents(serviceJsonFile))) match {
        case Right(service) ⇒ {
//          println(s"$serviceJsonFile decoded as: ${service.simpleName}")

          Right(service)
        }
        case other ⇒ other
      }
    }
  }


  case class Service(
    version: Option[String],
    metadata: MetaData,
    operations: Map[String, Operation],
    shapes: Map[String, ShapeDefinition],
    authorizers: Option[Authorizers],
    documentation: Option[String]
  ) extends Client {

    def companion: Client.Companion =
      Service

    lazy val module: String =
      companion.customModule(simpleName).getOrElse(serviceId.toLowerCase)

    lazy val fullName: String =
      s"software.amazon.awssdk.services.${clientPackage}.${simpleName}"

    lazy val simpleName: String =
      s"${serviceId}Client"

    lazy val clientPackage: String =
      companion.customClientModule(simpleName).getOrElse {
//        println(s"$simpleName not in ${companion.customs}")

        serviceId.toLowerCase
      }

    lazy val modelPackage: String =
      companion.customModel(simpleName).getOrElse {
//        println(s"$simpleName not in ${companion.customs}")

        serviceId.toLowerCase
      }

    private def isStreaming(shape: Shape): Boolean = {
      def loop(visited: Set[Shape])(shape: Shape): Boolean = {
        if (visited.contains(shape)) false else {
          shape.streaming.getOrElse(false) ||
          shapes.get(shape.shape).fold(false)(isStreaming(visited + shape))
        }
      }

      def isStreaming(visited: Set[Shape])(shapeDefinition: ShapeDefinition): Boolean = shapeDefinition match {
        case blob: BlobShapeDefinition ⇒ blob.streaming.getOrElse(false)
        case struct: StructureShapeDefinition ⇒ struct.members.values.exists(loop(visited))
        case _ ⇒ false
      }

      loop(Set.empty[Shape])(shape)
    }

    private def isEventStreaming(shape: Shape): Boolean = {
      def loop(visited: Set[Shape])(shape: Shape): Boolean = {
        if (visited.contains(shape)) false else {
          shape.streaming.getOrElse(false) ||
          shapes.get(shape.shape).fold(false)(isEventStreaming(visited + shape))
        }
      }

      def isEventStreaming(visited: Set[Shape])(shapeDefinition: ShapeDefinition): Boolean = shapeDefinition match {
        case blob: BlobShapeDefinition ⇒ blob.streaming.getOrElse(false)
        case struct: StructureShapeDefinition ⇒ {
          struct.eventstream.getOrElse(false) || struct.members.values.exists(loop(visited))
        }
        case _ ⇒ false
      }

      loop(Set.empty[Shape])(shape)
    }


    lazy val methods: ServiceMethods = {
      ServiceMethods(
        this,
        operations.toList.flatMap {
          case (name, operation) ⇒ OperationServiceMethod.create(
            name             = name,
            operation        = operation,
            streamingFlags   = StreamingFlags(
              input  = operation.input.fold(false)(isStreaming),
              output = operation.output.fold(false)(isStreaming),
              event  = operation.output.fold(false)(isEventStreaming)
            )
          )
        }
      ).filter
    }

    override def toString: String =
      q"""Service(
         |  version = $version,
         |  metadata = $metadata,
         |  operations = $operations,
         |  shapes = $shapes,
         |  authorizers = $authorizers,
         |  documentation = $documentation
         |)""".stripMargin

    private val serviceId: String =
      software.amazon.awssdk.utils.internal.CodegenNamingUtils.pascalCase(metadata.serviceId)
        .stripPrefix("Amazon")
        .stripPrefix("Aws")
        .stripSuffix("Service")
//        .split(" ")
//        .map(_.toLowerCase.capitalize)
//        .mkString("")
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
    override def toString: String = format("MetaData")(
      "apiVersion" → apiVersion,
      "endpointPrefix" → endpointPrefix,
      "globalEndpoint" → globalEndpoint,
      "jsonVersion" → jsonVersion,
      "checksumFormat" → checksumFormat,
      "protocol" → protocol,
      "protocolSettings" → protocolSettings,
      "serviceAbbreviation" → serviceAbbreviation,
      "serviceFullName" → serviceFullName,
      "serviceId" → serviceId,
      "signatureVersion" → signatureVersion,
      "signingName" → signingName,
      "targetPrefix" → targetPrefix,
      "uid" → uid,
      "xmlNamespace" → xmlNamespace
    )
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

  object OperationServiceMethod {
    def create(name: String, operation: Operation, streamingFlags: StreamingFlags): List[ServiceMethod] =
      if (operation.deprecated.getOrElse(false) || streamingFlags.event) Nil else {
        List(OperationServiceMethod(name, operation, streamingFlags))
      }
  }

  case class StreamingFlags(input: Boolean, output: Boolean, event: Boolean)

  case class OperationServiceMethod(
    operationName: String,
    operation: Operation,
    streamingFlags: StreamingFlags
  ) extends ServiceMethod {

    def name: String =
      operationName.uncapitalize

    def returnType: Type =
      Type(s"${operationName.pascal}Response")
//      operation.output match {
//      case Some(shape) ⇒ s"${shape.shape.stripSuffix("Result")}Response"
//      case None        ⇒ s"${operation.name}Response"
//    }

    def parameters: List[String] = params.map(_.toString)

    def parameterNames: List[String] = params.map(_.name)

    def getParameterTypes: List[Type] = params.map(_.`type`)

    def asRequest: String = s"${operationName.pascal}Request"

    private def params: List[Param] = streamingFlags match {
      case StreamingFlags(true, true, _) ⇒ List(
        Param("request", Type(asRequest)),
        Param("sourcePath", Type("Path")),
        Param("destinationPath", Type("Path"))
      )
      case StreamingFlags(true, _, _) ⇒ List(
        Param("request", Type(asRequest)),
        Param("body", Type("RequestBody"))
      )
      case StreamingFlags(_, true, _) ⇒ List(
        Param("request", Type(asRequest)),
        Param("path", Type("Path"))
      )
      case _ ⇒ List(
        Param("request", Type(asRequest))
      )
    }
  }

  case class Param(name: String, `type`: Type) {
    override def toString: String = s"$name: ${`type`}"
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
    override def toString: String = format("Operation")(
      "name" → name,
      "http" → http,
      "alias" → alias,
      "input" → input,
      "output" → output,
      "errors" → errors,
      "authtype" → authtype,
      "endpoint" → endpoint,
      "endpointDiscovery" → endpointDiscovery,
      "endpointoOeration" → endpointoOeration,
      "httpChecksumRequired" → httpChecksumRequired,
      "idempotent" → idempotent,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentationUrl" → documentationUrl,
      "documentation" → documentation
    )
  }

  object Http {
    implicit val httpCodec: Codec[Http] =
      Codec.forProduct3("method", "requestUri", "responseCode")(Http.apply)(getSome(Http.unapply)).lossless
  }

  case class Http(
    method: String,
    requestUri: String,
    responseCode: Option[Int] = None
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
    pattern: Option[String] = None,
    enum: Option[List[String]] = None,
    location: Option[String] = None,
    locationName: Option[String] = None,
    queryName: Option[String] = None,
    resultWrapper: Option[String] = None,
    xmlNamespace: Option[XmlNamespace] = None,
    box: Option[Boolean] = None,
    eventpayload: Option[Boolean] = None,
    flattened: Option[Boolean] = None,
    hostLabel: Option[Boolean] = None,
    idempotencyToken: Option[Boolean] = None,
    jsonvalue: Option[Boolean] = None,
    streaming: Option[Boolean] = None,
    xmlAttribute: Option[Boolean] = None,
    deprecated: Option[Boolean] = None,
    deprecatedMessage: Option[String] = None,
    documentation: Option[String] = None
  ) {

    override def toString: String = format("Shape")(
      "shape" → shape,
      "pattern" → pattern,
      "enum" → enum,
      "location" → location,
      "locationName" → locationName,
      "queryName" → queryName,
      "resultWrapper" → resultWrapper,
      "xmlNamespace" → xmlNamespace,
      "box" → box,
      "eventpayload" → eventpayload,
      "flattened" → flattened,
      "hostLabel" → hostLabel,
      "idempotencyToken" → idempotencyToken,
      "jsonvalue" → jsonvalue,
      "streaming" → streaming,
      "xmlAttribute" → xmlAttribute,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
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
    override def toString: String = format("IntegerShapeDefinition")(
      "shapeType" → shapeType,
      "max" → max,
      "min" → min,
      "box" → box,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
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
    override def toString: String = format("BlobShapeDefinition")(
      "shapeType" → shapeType,
      "max" → max,
      "min" → min,
      "requiresLength" → requiresLength,
      "sensitive" → sensitive,
      "streaming" → streaming,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
  }


  object LongShapeDefinition {
    implicit val longShapeDefinitionCodec: Codec[LongShapeDefinition] = Codec.forProduct7(
      "type",
      "max",
      "min",
      "box",
      "deprecated",
      "deprecatedMessage",
      "documentation"
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
    override def toString: String = format("LongShapeDefinition")(
      "shapeType" → shapeType,
      "max" → max,
      "min" → min,
      "box" → box,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
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
    override def toString: String = format("ListShapeDefinition")(
      "shapeType" → shapeType,
      "member" → member,
      "max" → max,
      "min" → min,
      "locationName" → locationName,
      "flattened" → flattened,
      "sensitive" → sensitive,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
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
    override def toString: String = format("MapShapeDefinition")(
      "shapeType" → shapeType,
      "key" → key,
      "value" → value,
      "max" → max,
      "min" → min,
      "locationName" → locationName,
      "flattened" → flattened,
      "sensitive" → sensitive,
      "documentation" → documentation
    )
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
    override def toString: String = format("StringShapeDefinition")(
      "shapeType" → shapeType,
      "max" → max,
      "min" → min,
      "pattern" → pattern,
      "enum" → enum,
      "sensitive" → sensitive,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
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
    override def toString: String = format("StructureShapeDefinition")(
      "shapeType" → shapeType,
      "required" → required,
      "xmlOrder" → xmlOrder,
      "xmlNamespace" → xmlNamespace,
      "members" → members,
      "error" → error,
      "payload" → payload,
      "locationName" → locationName,
      "retryable" → retryable,
      "box" → box,
      "event" → event,
      "eventstream" → eventstream,
      "exception" → exception,
      "fault" → fault,
      "sensitive" → sensitive,
      "synthetic" → synthetic,
      "union" → union,
      "wrapper" → wrapper,
      "deprecated" → deprecated,
      "deprecatedMessage" → deprecatedMessage,
      "documentation" → documentation
    )
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
    override def toString: String = format("TimestampShapeDefinition")(
       "shapeType" -> shapeType,
       "timestampFormat" -> timestampFormat,
       "documentation" -> documentation
    )
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
    override def toString: String = format("BooleanShapeDefinition")(
      "shapeType" -> shapeType,
      "box" -> box,
      "deprecated" -> deprecated,
      "deprecatedMessage" -> deprecatedMessage,
      "documentation" -> documentation
    )
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


  def format(name: String)(args: (String, Any)*): String = {
    val withoutNones = args.flatMap {
      case (_, None)           ⇒ None
      case (name, Some(value)) ⇒ Some(s"$name = ${quote(value)}")
      case (name, value)       ⇒ Some(s"$name = ${quote(value)}")
    }.toList

    withoutNones match {
      case Nil ⇒ "$name()"
      case List(one) ⇒ s"$name($one)"
      case many ⇒
        s"""$name(
         |  ${many.mkString(",\n  ")}
         |)""".stripMargin
    }
  }
}
