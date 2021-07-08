import java.io.{File, PrintWriter}
import java.lang.reflect.Parameter
import java.lang.{reflect ⇒ R}
import goober.Free.Companion.Visitor.KleisliVisitor
import goober.Free.Companion.{Implementations, Visitor}
import goober.Free.{Companion, SmartConstructors}
import io.circe.CursorOp.DownField
import io.circe.Decoder.Result
import org.reflections.Reflections
import sbt.Def.task
import sbt.{Def, Task, TaskKey, taskKey}
import software.amazon.awssdk.core.SdkField
import io.circe._
import io.circe.parser._

import scala.annotation.tailrec
import scala.collection.JavaConverters._
import scala.collection.immutable.{::, List, Nil}
import scala.io.Source
import scala.reflect.ClassTag

object goober {
  implicit class AnySyntax[A](private val self: A) extends AnyVal {
    def indentBy(by: String): String =
      self.toString.getLines.mkString(s"\n$by")
  }

  def quote(arg: Any): String = arg match {
    case s: String ⇒ "\"" + s + "\""
    case l: List[_] ⇒ {
      s"""List(
         |    ${l.map(it ⇒ quote(it).indentBy("  ")).mkString(",\n  ")}
         |  )"""
    }
    case None ⇒"None"
    case Some(a) ⇒ {
      s"""Some(
         |    ${quote(a).indentBy("  ")}
         |  )"""
    }
    case m: Map[_, _] ⇒ {
      val sorted =
        m.toList.map(kv ⇒ quote(kv._1) → kv._2).sortBy(_._1)

      s"""Map(
         |  ${sorted.map(kv ⇒ s"${kv._1} -> ${quote(kv._2).indentBy("  ")}").mkString(",\n  ")}
         |)""".stripMargin
    }
    case other ⇒ other.toString
  }

  implicit class QuotingStringContext(private val self: StringContext) extends AnyVal {
    def q(args: Any*): String = {
      def format(arg: Any): String =
        quote(arg).indentBy("  ")

      val interleaved: List[String] = interleave(
        self.parts.toList,
        args.toList.map(format)
      )

      interleaved.mkString("")
    }

    private def interleave[A](lhs: List[A], rhs: List[A]): List[A] = {
      @tailrec
      def recurse(acc: List[A], next: List[A], after: List[A]): List[A] = next match {
        case Nil ⇒ acc.reverse ::: after
        case head :: tail ⇒ recurse(head :: acc, after, tail)
      }

      recurse(Nil, lhs, rhs)
    }
  }

  implicit class CodecSyntax[A](private val self: Codec[A]) extends AnyVal {
    def lossless(implicit A: ClassTag[A]): Codec[A] = {
      Codec.from[A](
        decodeA = Decoder.instance[A](cursor ⇒ {
          for {
            a ← self.tryDecode(cursor).left.map(failure ⇒ failure.copy(message =
              s"""${failure.message}
                 |
                 |  ${cursor.focus.fold("None")(_.spaces2.take(100).indentBy("  "))}""".stripMargin
            ))
            _ ← {
              (cursor.focus, self.apply(a).deepDropNullValues) match {
                case (None, _)             ⇒ Left(DecodingFailure.apply("Nothing at focus", Nil))
                case (Some(before), after) ⇒ diff(A.toString, cursor, before, after)
              }
            }
          } yield a
        }),
        encodeA = Encoder.instance[A](a ⇒ {
          val json = self.apply(a)

          json
        })
      )
    }
  }

  private object obj {
    def unapply(json: Json): Option[JsonObject] = json.asObject
  }

  private def diff(name: String, cursor: HCursor, lhs: Json, rhs: Json): Decoder.Result[Unit] = {
    (lhs, rhs) match {
      case (obj(lhsObj), obj(rhsObj)) ⇒ {
        val missingKeys = lhsObj.keys.toSet -- rhsObj.keys.toSet
        val additionalKeys = rhsObj.keys.toSet -- lhsObj.keys.toSet

        if (missingKeys.isEmpty && additionalKeys.isEmpty) Right(()) else {
          Left(DecodingFailure.apply(
            s"""$name Not lossless
               |
               |  before: ${lhs.spaces2.indentBy("  ")}
               |
               |  after: ${rhs.spaces2.indentBy("  ")}
               |
               |
               |  missingKeys: ${missingKeys.mkString(", ")}
               |
               |  additionalKeys: ${additionalKeys.mkString(", ")}
               |
               |""".stripMargin,
            cursor.history
          ))
        }
      }
      case _ ⇒if (lhs == rhs) Right(()) else Left(DecodingFailure.apply(
        s"""$name Not lossless
           |
           |  before: ${lhs.spaces2.indentBy("  ")}
           |
           |  after: ${rhs.spaces2.indentBy("  ")}
           |
           |""".stripMargin,
        cursor.history
      ))
    }
  }

  object generator {
    val generate: TaskKey[Unit] = taskKey[Unit]("generate")

    val hi: Def.Initialize[Task[Unit]] = task {
//      val clients =
//        Client.discover
//
//      Generators(
//        clients.map(new Hi(_))
//      ).scalaFiles.writeTo(".")
    }

    val free: Def.Initialize[Task[Unit]] = task {
      new File("project/aws-sdk-java-v2/services").list().toList.sorted.foreach(service ⇒ {
        readJson(List(
          s"project/aws-sdk-java-v2/services/$service/src/main/resources/codegen-resources/service-2.json",
          s"project/aws-sdk-java-v2/services/$service/src/main/resources/codegen-resources/$service/service-2.json" // TODO: loop in last service dir
        ))
      })

//      val clients =
//        Client.discover
//
//      Generators(
//        Embedded(clients) :: KleisliInterpreter(clients) :: clients.map(new Free(_))
//      ).scalaFiles.writeTo(".")
    }

    def readJson(files: List[String]): Unit = for {
      file ← files
      if new File(file).exists
      // println(new File(file).exists())

      // println(parse(fileContents(file)).toString.take(100))
    } yield {
      decode[Service](fileContents(file)) match {
        case Left(DecodingFailure(message, ops)) ⇒ sys.error(
          s"""
             |file: $file
             |
             |error: ${ops.reverse.map(opString).mkString(".")}
             |  $message
             |
             |""".stripMargin
        )
        case Right(_) ⇒ {}
      }
    }

    private val opString: io.circe.CursorOp ⇒ String = {
      case DownField(field) ⇒ field
      case other => other.toString
    }

    private def fileContents(file: String): String = withSource(file)(_.mkString(""))

    private def withSource[A](file: String)(f: Source ⇒ A): A = {
      val source = Source.fromFile(file)

      try f(source) finally source.close
    }

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


    private def getSome[X, A](f: X => Option[A]): X => A =
      f andThen (_.get)
  }

  implicit class StringSyntax(private val self: String) extends AnyVal {
    def getLines: List[String] =
      self.split("\n", -1).toList

    def trimTrailing: String =
      self.replaceAll("\\s+$", "")
  }

  case class Generators(values: List[Generator]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.flatten(ScalaFiles(values.flatMap(_.scalaFiles.values)))
  }

  trait Generator {
    def scalaFiles: ScalaFiles
  }

  case class Hi(client: Client, methods: List[Hi.Method]) extends Generator {
    def this(client: Client) =
      this(client, client.methods.parameterTypes.distinct.sorted.map(Hi.Method.create))

    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Hi.directory}/${client.module}.scala", toString))

    override def toString: String =
      s"""package goober.hi
         |
         |${client.ioImports + client.modelImports}
         |
         |
         |object ${client.module} {
         |  import goober.free.{${client.module} ⇒ free}
         |
         |  object model {
         |    import goober.hi.util.BuilderSyntax._
         |
         |    // Methods for constructing model classes, requests, etc.
         |    ${methods.map(_.indentBy("  ")).mkString("\n    ")}
         |
         |  }
         |
         |  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
         |}
         |""".stripMargin
  }

  object Hi {
    private val directory = "/hi/src/main/scala/goober/hi"

    object Method {
      def create(clazz: Class[_]): Method =
        new Method(clazz, Nil)
    }

    case class Method(clazz: Class[_], fields: List[Field]) {
      override def toString: String =
        s"""// ${clazz.getSimpleName}"""
    }

    case class Field(value: SdkField[_])
  }

  case class HiModel(clazz: Class[_]) {

  }

  case class Free(
    client: Client,
    companion: Free.Companion,
    smartConstructors: Free.SmartConstructors
  ) extends Generator {

    def this(client: Client) =
      this(client, new Companion(client), new SmartConstructors(client))

    def interpreterValue: String =
      s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, $client, *] = new ${client.name}Interpreter {
         |  def primitive[A](f: $client ⇒ A): Kleisli[M, $client, A] = interpreter.primitive(f)
         |}""".stripMargin

    def interpreterTrait: String =
      s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
         |  def embed[A](e: Embedded[A]): Kleisli[M, $client, A] = interpreter.embed(e)
         |}""".stripMargin

    def embeddedClass: String =
      s"final case class ${client.name}[A](client: $client, io: ${client.io}[A]) extends Embedded[A]"

    def embeddedCase: String =
      s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, $client, *]](${client.name}Interpreter).run(client))"

    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/${client.module}.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.free.{Free => FF}
         |import cats.~>
         |import cats.data.Kleisli
         |${client.clientImports + client.modelImports + companion.imports}
         |
         |
         |object ${client.module} { module =>
         |
         |  // Free monad over ${client.op}
         |  type ${client.io}[A] = FF[${client.op}, A]
         |
         |  sealed trait ${client.op}[A] {
         |    def visit[F[_]](visitor: ${client.op}.Visitor[F]): F[A]
         |  }
         |
         |  ${companion.indentBy("  ")}
         |
         |  ${smartConstructors.indentBy("  ")}
         |}
         |""".stripMargin
  }

  object Free {
    val directory = "/free/src/main/scala/goober/free"

    case class Companion(
      client: Client,
      visitor: Companion.Visitor,
      implementations: Companion.Implementations
    ) {

      def this(client: Client) =
        this(client, new Visitor(client), new Implementations(client))

      def imports: Imports =
        visitor.imports

      override def toString: String =
        s"""object ${client.op} {
           |  // Given a $client we can embed a ${client.io} program in any algebra that understands embedding.
           |  implicit val ${client.op}Embeddable: Embeddable[${client.op}, $client] = new Embeddable[${client.op}, $client] {
           |    def embed[A](client: $client, io: ${client.io}[A]): Embedded[A] = Embedded.${client.name}(client, io)
           |  }
           |
           |  ${visitor.indentBy("  ")}
           |
           |  ${implementations.indentBy("  ")}
           |}""".stripMargin
    }

    object Companion {
      case class Visitor(client: Client, kleisliVisitor: Visitor.KleisliVisitor, methods: List[Visitor.Method]) {
        def this(client: Client) =
          this(client, new KleisliVisitor(client), client.methods.map(Visitor.Method))

        def imports: Imports = Imports.flatten(
          ifUsed("java.nio.file.Path"),
          ifUsed("software.amazon.awssdk.core.sync.RequestBody")
        )

        override def toString: String =
          s"""object Visitor {
             |  ${kleisliVisitor.indentBy("  ")}
             |}
             |
             |trait Visitor[F[_]] extends (${client.op} ~> F) {
             |  final def apply[A](op: ${client.op}[A]): F[A] = op.visit(this)
             |
             |  def embed[A](
             |    e: Embedded[A]
             |  ): F[A]
             |
             |  ${methods.map(_.indentBy("  ")).mkString("\n  \n  ")}
             |}""".stripMargin

        private def ifUsed(parameterType: String): Option[String] =
          if (methods.exists(_.hasParameterType(parameterType))) Some(parameterType) else None
      }

      object Visitor {
        case class KleisliVisitor(client: Client, methods: List[KleisliVisitor.Method]) {
          def this(client: Client) =
            this(client, client.methods.map(KleisliVisitor.Method(client, _)))

          override def toString: String =
            s"""trait KleisliVisitor[M[_]] extends ${client.op}.Visitor[Kleisli[M, $client, *]] {
               |  ${methods.map(_.indentBy("  ")).mkString("\n\n  ")}
               |
               |  def primitive[A](
               |    f: $client => A
               |  ): ${client.kleisliType("A")}
               |}""".stripMargin
        }

        object KleisliVisitor {
          case class Method(client: Client, method: R.Method) {
            override def toString: String =
              s"""def ${method.getName}(
                 |  ${parametersOf(method)}
                 |): ${client.kleisliType(method.getReturnType.getSimpleName)} =
                 |  primitive(_.${method.getName}(${parameterNames(method)}))""".stripMargin
          }
        }

        case class Method(method: R.Method) {
          def hasParameterType(pparameterType: String): Boolean =
            method.getParameterTypes.exists(parameterClass ⇒ parameterClass.getName == pparameterType)

          override def toString: String =
            s"""def ${method.getName}(
               |  ${parametersOf(method)}
               |): F[${method.getReturnType.getSimpleName}]""".stripMargin
        }
      }

      case class Implementations(client: Client, values: List[Implementation]) {
        def this(client: Client) =
          this(client, client.methods.map(Implementation(client, _)))

        override def toString: String = {
          s"""final case class Embed[A](
             |  e: Embedded[A]
             |) extends ${client.op}[A] {
             |  def visit[F[_]](visitor: Visitor[F]) =
             |    visitor.embed(e)
             |}
             |
             |${values.map(_.toString).mkString("\n\n")}""".stripMargin
        }
      }

      case class Implementation(client: Client, method: R.Method) {
        override def toString: String =
          s"""final case class ${method.getName.capitalize}Op(
             |  ${parametersOf(method)}
             |) extends ${client.op}[${method.getReturnType.getSimpleName}] {
             |  def visit[F[_]](visitor: Visitor[F]): F[${method.getReturnType.getSimpleName}] =
             |    visitor.${method.getName}(${parameterNames(method)})
             |}""".stripMargin
      }
    }

    case class SmartConstructors(client: Client, constructors: List[SmartConstructor]) {
      def this(client: Client) =
        this(client, client.methods.map(SmartConstructor(client, _)))

      override def toString: String = {
        s"""import ${client.op}._
           |
           |def embed[F[_], J, A](
           |  j: J,
           |  fa: FF[F, A]
           |)(implicit
           |  ev: Embeddable[F, J]
           |): FF[${client.op}, A] =
           |  FF.liftF(Embed(ev.embed(j, fa)))
           |
           |${constructors.map(_.toString).mkString("\n\n")}""".stripMargin
      }
    }

    case class SmartConstructor(client: Client, method: R.Method) {
      override def toString: String =
        s"""def ${method.getName}(
           |  ${parametersOf(method)}
           |): ${client.io}[${method.getReturnType.getSimpleName}] =
           |  FF.liftF(${method.getName.capitalize}Op(${parameterNames(method)}))""".stripMargin
    }
  }

  private def parentPackage(clazz: Class[_]): String =
    clazz.getPackage.getName.split("\\.").last

  object Client {
    implicit val clientOrdering: Ordering[Client] =
      Ordering.String.on[Client](_.name)

    def discover: List[Client] = {
      new Reflections("software.amazon.awssdk.services")
        .getSubTypesOf(classOf[software.amazon.awssdk.core.SdkClient])
        .asScala
        .toList
        .flatMap(create)
        .sorted
    }

    def create(clazz: Class[_]): Option[Client] = {
      Option(clazz)
        .filter(_.isInterface)
        .filterNot(_.getSimpleName.endsWith("AsyncClient"))
        .map(new Client(_))
    }

    def methodsIn(clazz: Class[_]): Methods = Methods {
      clazz.getDeclaredMethods.toList
        .filterNot(isExcluded)
        .filterNot(isStatic)
        .groupBy(_.getName)
        .flatMap(choosePreferred)
        .toList
        .sortBy(_.getName)
    }

    def ioImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.ioImports))

    def opImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.opImports))

    def clientImports(values: List[Client]): Imports =
      Imports.flatten(values.map(_.clientImports))

    private def isExcluded(method: R.Method): Boolean = {
      method.getName.endsWith("Paginator")           ||
        method.getName.endsWith("Torrent")           ||
        excludedNames.contains(method.getName)       ||
        excludedTypes.contains(method.getReturnType) ||
        method.getParameterTypes.isEmpty             ||
        method.getParameterTypes.exists(excludedTypes.contains)
    }

    private def isStatic(method: R.Method): Boolean =
      R.Modifier.isStatic(method.getModifiers)

    private def choosePreferred(values: (String, List[R.Method])): Option[R.Method] = {
      val sorted = values._2.sortBy(_.getParameterTypes.toList)(
        Ordering.Implicits.seqDerivedOrdering[List, Class[_]](
          indexOfOrdering(preferredTypes)
        )
      )
      // println(s"${values._1}: $sorted")
      sorted.headOption
    }

    private def indexOfOrdering[A](list: List[A]): Ordering[A] = Ordering.Int.on[A](a ⇒ {
      val result = list.indexOf(a)

      if (result == -1) Int.MaxValue else result
    })

    private lazy val excludedNames: Set[String] = Set("utilities")

    private lazy val excludedTypes: Set[Class[_]] = Set(
      classOf[java.util.function.Consumer[_]],
      classOf[software.amazon.awssdk.core.ResponseBytes[_]],
      classOf[software.amazon.awssdk.core.ResponseInputStream[_]],
      classOf[software.amazon.awssdk.core.sync.ResponseTransformer[_, _]]
    )

    private lazy val preferredTypes: List[Class[_]] = List(
      classOf[software.amazon.awssdk.core.sync.RequestBody],
      classOf[java.nio.file.Path]
    )

    private val custom: Map[Class[_], Custom] = Map(
      classOf[software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient] → Custom("dynamodb", "dynamodbstreams"),
      classOf[software.amazon.awssdk.services.waf.regional.WafRegionalClient] → Custom("waf", "wafregional")
    )

    private case class Custom(model: String, module: String)
  }

  class Client(clazz: Class[_]) {
    val module: String =
      Client.custom.get(clazz).fold(parentPackage(clazz))(_.module)

    val name: String =
      clazz.getSimpleName.stripSuffix("Client")

    val io: String = s"${name}IO"

    val op: String = s"${name}Op"

    val modelImports: Imports =
      Imports.create(s"software.amazon.awssdk.services.${modelPackage}.model._")

    val clientImports: Imports =
      Imports.create(clazz.getName)

    val opImports: Imports =
      Imports.create(s"goober.free.$module.$op")

    val ioImports: Imports =
      Imports.create(s"goober.free.$module.$io")

    def kleisliType(`type`: String): String =
      s"Kleisli[M, $this, ${`type`}]"

    lazy val methods: Methods =
      Client.methodsIn(clazz)

    override val toString: String =
      clazz.getSimpleName

    private def modelPackage: String =
      Client.custom.get(clazz).fold(parentPackage(clazz))(_.model)
  }

  case class Methods(values: List[R.Method]) {
    def map[A](f: R.Method ⇒ A): List[A] =
      values.map(f)

    def parameterTypes: ParameterTypes =
      ParameterTypes(values.flatMap(_.getParameterTypes.toList))
  }

  case class ParameterTypes(values: List[Class[_]]) {
    def distinct: ParameterTypes =
      ParameterTypes(values.map(equalBy(_.getSimpleName)).distinct.map(_.a))

    def sorted: ParameterTypes =
      ParameterTypes(values.sortBy(_.getSimpleName))

    def map[A](f: Class[_] ⇒ A): List[A] =
      values.map(f)
  }

  private def equalBy[A, B](f: A ⇒ B)(a: A): EqualBy[A, B] = EqualBy(f(a))(a)
  case class EqualBy[A, B](b: B)(val a: A)

  private def parametersOf(method: R.Method): String = {
    parameterNamesList(method).zip(method.getParameters.map(_.getType.getSimpleName)).map {
      case (name, clazz) ⇒ s"$name: $clazz"
    }.mkString(",\n  ")
  }

  private def parameterNames(method: R.Method): String =
    parameterNamesList(method).mkString(", ")

  private def parameterNamesList(method: R.Method): List[String] = customParameterNames.getOrElse(
    s"${method.getDeclaringClass.getSimpleName}.${method.getName}",
    method.getParameters.toList.map(parameterName)
  )

  private def parameterName(parameter: Parameter): String =
    if (parameter.getType.getSimpleName.endsWith("Request")) "request" else {
      parameterNames.getOrElse(parameter.getType, parameter.getName)
    }

  private val customParameterNames: Map[String, List[String]] = Map(
    "LexRuntimeClient.postContent"          → List("request", "sourcePath", "destinationPath"),
    "LexRuntimeV2Client.recognizeUtterance" → List("request", "sourcePath", "destinationPath")
  )

  private val parameterNames: Map[Class[_], String] = Map(
    classOf[software.amazon.awssdk.core.sync.RequestBody] → "body",
    classOf[java.nio.file.Path] → "path"
  )

  case class Embedded(clients: List[Client]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/embedded.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.free.Free
         |${Client.ioImports(clients) + Client.clientImports(clients)}
         |
         |
         |// A pair (J, Free[F, A]) with constructors that tie down J and F.
         |sealed trait Embedded[A]
         |
         |object Embedded {
         |  ${clients.map(embeddedClass).mkString("\n  ")}
         |}
         |
         |// Typeclass for embeddable pairs (J, F)
         |trait Embeddable[F[_], J] {
         |  def embed[A](j: J, fa: Free[F, A]): Embedded[A]
         |}
         |""".stripMargin

    private def embeddedClass(client: Client): String =
      s"final case class ${client.name}[A](client: $client, io: ${client.io}[A]) extends Embedded[A]"
  }

  case class KleisliInterpreter(clients: List[Client]) extends Generator {
    def scalaFiles: ScalaFiles =
      ScalaFiles.create(ScalaFile(s"${Free.directory}/KleisliInterpreter.scala", toString))

    override def toString: String =
      s"""package goober.free
         |
         |import scala.language.higherKinds
         |
         |import cats.data.Kleisli
         |import cats.effect.{Async, Blocker, ContextShift}
         |import cats.~>
         |${Client.opImports(clients) + Client.clientImports(clients)}
         |
         |
         |object KleisliInterpreter {
         |  def apply[M[_]](b: Blocker)(implicit
         |    am: Async[M],
         |    cs: ContextShift[M]
         |  ): KleisliInterpreter[M] = new KleisliInterpreter[M] {
         |    val asyncM = am
         |    val contextShiftM = cs
         |    val blocker = b
         |  }
         |}
         |
         |trait KleisliInterpreter[M[_]] { interpreter =>
         |  ${clients.map(interpreterValue).mkString("\n\n").indentBy("  ")}
         |
         |  ${clients.map(interpreterTrait).mkString("\n\n").indentBy("  ")}
         |
         |
         |  def primitive[J, A](f: J => A): Kleisli[M, J, A] = Kleisli(a => {
         |    // primitive AWS methods throw exceptions and so do we when reading values
         |    // so catch any non-fatal exceptions and lift them into the effect
         |    blocker.blockOn[M, A](try {
         |      asyncM.delay(f(a))
         |    } catch {
         |      case scala.util.control.NonFatal(e) => asyncM.raiseError(e)
         |    })(contextShiftM)
         |  })
         |
         |  def embed[J, A](e: Embedded[A]): Kleisli[M, J, A] = e match {
         |    ${clients.map(embeddedCase).mkString("\n  ").indentBy("  ")}
         |  }
         |
         |  val blocker: Blocker
         |  implicit val asyncM: Async[M]
         |  val contextShiftM: ContextShift[M]
         |}
         |""".stripMargin

    private def interpreterValue(client: Client): String =
      s"""lazy val ${client.name}Interpreter: ${client.op} ~> Kleisli[M, $client, *] = new ${client.name}Interpreter {
         |  def primitive[A](f: $client ⇒ A): Kleisli[M, $client, A] = interpreter.primitive(f)
         |}""".stripMargin

    private def interpreterTrait(client: Client): String =
      s"""trait ${client.name}Interpreter extends ${client.op}.Visitor.KleisliVisitor[M] {
         |  def embed[A](e: Embedded[A]): Kleisli[M, $client, A] = interpreter.embed(e)
         |}""".stripMargin

    private def embeddedCase(client: Client): String =
      s"case Embedded.${client.name}(client, io) => Kleisli(_ => io.foldMap[Kleisli[M, $client, *]](${client.name}Interpreter).run(client))"
  }

  object ScalaFiles {
    def flatten(files: ScalaFiles*): ScalaFiles =
      new ScalaFiles(files.flatMap(_.values).toList)

    def create(files: ScalaFile*): ScalaFiles =
      new ScalaFiles(files.toList)
  }

  case class ScalaFiles(values: List[ScalaFile]) {
    def +(rhs: ScalaFiles): ScalaFiles =
      ScalaFiles(values ++ rhs.values)

    def writeTo(directory: String): Unit =
      values.foreach(_.writeTo(directory))
  }

  case class ScalaFile(name: String, contents: String) {
    def writeTo(directory: String): Unit = {
      val pw = new PrintWriter(s"$directory/${name}")
      pw.write(contents.getLines.map(_.trimTrailing).mkString("\n"))
      pw.close()
    }
  }

  object Imports {
    def create(values: String*): Imports =
      Imports(values.toList)

    def flatten(values: Option[String]*): Imports =
      Imports(values.toList.flatten)

    def flatten(values: List[Imports]): Imports =
      Imports(values.flatMap(_.values))
  }

  case class Imports(values: List[String]) {
    def +(rhs: Imports): Imports =
      Imports(values ++ rhs.values)

    override def toString: String =
      values.map(value ⇒ s"import $value").mkString("\n")
  }
}


