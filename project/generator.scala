import java.io.File
import io.circe.CursorOp.DownField
import io.circe._
import io.circe.parser._
import sbt.Def.task
import sbt.{Def, Task, TaskKey, taskKey}

import scala.collection.immutable.List
import scala.io.Source

import codecs._
import reflection._

object generator {
  val generate: TaskKey[Unit] = taskKey[Unit]("generate")

  val hi: Def.Initialize[Task[Unit]] = task {
    val clients =
      Client.discover

    Generators(
      clients.map(new Hi(_))
    ).scalaFiles.writeTo(".")
  }

  val free: Def.Initialize[Task[Unit]] = task {
    new File("project/aws-sdk-java-v2/services").list().toList.sorted.foreach(service ⇒ {
      readJson(List(
        s"project/aws-sdk-java-v2/services/$service/src/main/resources/codegen-resources/service-2.json",
        s"project/aws-sdk-java-v2/services/$service/src/main/resources/codegen-resources/$service/service-2.json" // TODO: loop in last service dir
      ))
    })

    val clients =
      Client.discover

    Generators(
      Embedded(clients) :: KleisliInterpreter(clients) :: clients.map(new Free(_))
    ).scalaFiles.writeTo(".")
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
}
