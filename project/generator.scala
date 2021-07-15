import codecs._
import common.{Client, Embedded, Free, Generators, Hi, KleisliInterpreter}
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
}