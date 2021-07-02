import com.jsuereth.sbtpgp.SbtPgp.autoImport._

inThisBuild(List(
  organization := "com.github.stacycurl",
  homepage     := Some(url("https://github.com/stacycurl/goober")),
  licenses     := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers   := List(
    Developer("stacycurl", "Stacy Curl", "stacy.curl@gmail.com", url("https://github.com/stacycurl"))
  ),
  usePgpKeyHex("pimpathon ci")
))

val goober: Project = (project in file(".")
  settings(
    organization              := "com.github.stacycurl",
    scalaVersion              := "2.12.13",
    scalacOptions             := Seq("-feature", "-Xfatal-warnings", "-deprecation", "-unchecked", "-target:jvm-1.8"),
    javacOptions              := Seq("-source", "1.8", "-target", "1.8", "-Xlint"),
    maxErrors                 := 1,
    parallelExecution in Test := true,
    resolvers += Resolver.sonatypeRepo("releases"),
    libraryDependencies ++= scalaVersion(dependencies("2.12.13" → List(
      "org.scala-lang"             % "scala-compiler"    % "2.12.13",
      "org.scala-lang"             % "scala-library"     % "2.12.13" % "test"
    ))).value,
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.3" cross CrossVersion.full)
  )
)

def dependencies(modules: (String, List[ModuleID])*)(version: String): List[sbt.ModuleID] = modules.toMap.apply(version)
