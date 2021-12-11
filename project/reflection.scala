import java.lang.reflect.Parameter
import java.lang.{reflect ⇒ R}
import org.reflections.Reflections

import scala.collection.JavaConverters._
import scala.collection.immutable.List


object reflection {
  import common._

  object ReflectionClient extends Client.Companion {
    def parentPackage(clazz: Class[_]): String =
      clazz.getPackage.getName.split("\\.").last

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
        .map(new ReflectionClient(_))
    }

    def methodsIn(client: ReflectionClient, clazz: Class[_]): ServiceMethods = ServiceMethods(
      client = client,
      values = clazz.getDeclaredMethods.toList
        .filterNot(isStatic)
        .map(ReflectionMethod)
    ).filter

    private def isStatic(method: R.Method): Boolean =
      R.Modifier.isStatic(method.getModifiers)
  }

  class ReflectionClient(clazz: Class[_]) extends Client {
    def companion: Client.Companion =
      ReflectionClient

    val module: String =
      companion.customModule(clazz.getSimpleName).getOrElse(ReflectionClient.parentPackage(clazz))

    lazy val methods: ServiceMethods =
      ReflectionClient.methodsIn(this, clazz).filter

    override val toString: String =
      simpleName

    def fullName: String =
      clazz.getName

    def simpleName: String =
      clazz.getSimpleName

    def modelPackage: String =
      companion.customModel(clazz.getSimpleName).getOrElse(ReflectionClient.parentPackage(clazz))

    def types: List[CaseClassType] =
      Nil

    def lookupType(name: String): Type =
      Type(name)
  }

  case class ReflectionMethod(method: R.Method) extends ServiceMethod {
    def name: String =
      method.getName

    def asRequest: String =
      name

    def returnType: TypeName =
      TypeName(method.getReturnType.getSimpleName)

    def parameters: List[String] = {
      parameterNamesList(method).zip(getSimpleParameterTypes).map {
        case (name, clazz) ⇒ s"$name: $clazz"
      }
    }

    def parameterNames: List[String] =
      parameterNamesList(method)

    def getParameterTypes: List[TypeName] =
      method.getParameterTypes.map(TypeName.fromClass).toList

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
