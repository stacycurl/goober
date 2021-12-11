import codecs._
import common.{CaseClassType, Client, Embedded, Free, Generators, Hi, HiType, KleisliInterpreter}
import sbt.Def.task
import sbt.{Def, Task, TaskKey, taskKey}

object generator {
  val generate: TaskKey[Unit] = taskKey[Unit]("generate")

  val hi: Def.Initialize[Task[Unit]] = task {
    Generators(
      clientCompanion.discover.map(new Hi(_))
    ).scalaFiles.writeTo(".")
  }

  val free: Def.Initialize[Task[Unit]] = task {
    val clients =
      clientCompanion.discover

    Generators(
      Embedded(clients) :: KleisliInterpreter(clients) :: clients.map(new Free(_))
    ).scalaFiles.writeTo(".")
  }

  private def clientCompanion: Client.Companion = {
    Service
//      ReflectionClient
  }

  def main(args: Array[String]): Unit = {
    clientCompanion.discover.filter(_.module == "ec2").foreach(client ⇒ {
      PartialFunction.condOpt(client.lookupType("AcceptReservedInstancesExchangeQuoteRequest")) {
        case caseClass: CaseClassType ⇒ println(HiType(caseClass))
      }
    })
  }
}