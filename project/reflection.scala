import java.lang.reflect.Parameter
import java.lang.{reflect ⇒ R}
import common.Free.Companion.{Implementation, Visitor}
import common.Free.Companion.Visitor.KleisliVisitor
import common.Free.SmartConstructor
import org.reflections.Reflections
import software.amazon.awssdk.core.SdkField

import scala.collection.JavaConverters._
import scala.collection.immutable.{List, Nil}


object reflection {
  import common._
  import syntax._




  object Client {
    def parentPackage(clazz: Class[_]): String =
      clazz.getPackage.getName.split("\\.").last

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

    def methodsIn(client: Client, clazz: Class[_]): GenMethods = Methods(
      client = client,
      values = clazz.getDeclaredMethods.toList
        .filterNot(isStatic)
        .map(RMethod)
        .filterNot(_.isExcluded)
        .groupBy(_.name)
        .flatMap(GenMethod.choosePreferred)
        .toList
        .sortBy(_.name)
    )

    private def isStatic(method: R.Method): Boolean =
      R.Modifier.isStatic(method.getModifiers)


    private val custom: Map[Class[_], Custom] = Map(
      classOf[software.amazon.awssdk.services.dynamodb.streams.DynamoDbStreamsClient] → Custom("dynamodb", "dynamodbstreams"),
      classOf[software.amazon.awssdk.services.waf.regional.WafRegionalClient] → Custom("waf", "wafregional")
    )

    private case class Custom(model: String, module: String)
  }

  class Client(clazz: Class[_]) extends GenClient {
    val module: String =
      Client.custom.get(clazz).fold(Client.parentPackage(clazz))(_.module)

    lazy val methods: GenMethods =
      Client.methodsIn(this, clazz)

    override val toString: String =
      simpleName

    def fullName: String =
      clazz.getName

    def simpleName: String =
      clazz.getSimpleName

    def modelPackage: String =
      Client.custom.get(clazz).fold(Client.parentPackage(clazz))(_.model)
  }

  case class Methods(client: GenClient, values: List[GenMethod]) extends GenMethods {
    def smartConstructors: List[SmartConstructor] =
      values.map(SmartConstructor(client, _))

    def visitorMethods: List[Visitor.Method] =
      values.map(Visitor.Method)

    def kleisliVisitors: List[KleisliVisitor.Method] =
      values.map(KleisliVisitor.Method(client, _))

    def implementations: List[Implementation] =
      values.map(Implementation(client, _))
  }

  case class RMethod(method: R.Method) extends GenMethod {
    def name: String =
      method.getName

    def returnType: String =
      method.getReturnType.getSimpleName

    def parameters: List[String] = {
      parameterNamesList(method).zip(getSimpleParameterTypes).map {
        case (name, clazz) ⇒ s"$name: $clazz"
      }
    }

    def parameterNames: List[String] =
      parameterNamesList(method)

    def getFullParameterTypes: List[String] =
      method.getParameterTypes.map(_.getName).toList

    def getSimpleParameterTypes: List[String] =
      method.getParameterTypes.map(_.getSimpleName).toList
  }

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


}
