import com.jsuereth.sbtpgp.SbtPgp.autoImport._
import goober.generator

inThisBuild(List(
  organization := "com.github.stacycurl",
  homepage     := Some(url("https://github.com/stacycurl/goober")),
  licenses     := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers   := List(
    Developer("stacycurl", "Stacy Curl", "stacy.curl@gmail.com", url("https://github.com/stacycurl"))
  ),
  usePgpKeyHex("pimpathon ci")
))

lazy val awsVersion           = "2.16.85"
lazy val catsVersion          = "2.4.2"
lazy val catsEffectVersion    = "2.3.3"
lazy val fs2Version           = "2.5.3"

lazy val gooberSettings = Seq(
  organization              := "com.github.stacycurl",
  scalaVersion              := "2.12.13",
  scalacOptions             := Seq("-feature", "-Xfatal-warnings", "-deprecation", "-unchecked", "-target:jvm-1.8"),
  javacOptions              := Seq("-source", "1.8", "-target", "1.8", "-Xlint"),
  maxErrors                 := 1,
  parallelExecution in Test := true,
  resolvers += Resolver.sonatypeRepo("releases"),
  libraryDependencies ++= scalaVersion(dependencies("2.12.13" → List(
    "org.scala-lang"             % "scala-compiler"    % "2.12.13",
    "org.scala-lang"             % "scala-library"     % "2.12.13" % Test,
    "org.scalameta"             %% "munit"             % "0.7.27"  % Test
  ))).value,
  testFrameworks += new TestFramework("munit.Framework"),
  addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.3" cross CrossVersion.full)
)

lazy val noPublishSettings = Seq(
  skip in publish := true
)

lazy val goober: Project = project.in(file("."))
  .settings(gooberSettings)
  .settings(noPublishSettings)
  .aggregate(
    hi,
    free
  )

lazy val hi: Project = project.in(file("hi"))
  .settings(gooberSettings)
  .settings(
    generator.generate := generator.hi.value
  )
  .dependsOn(free)


lazy val free: Project = project.in(file("free"))
  .settings(gooberSettings)
  .settings(
    libraryDependencies ++= Seq(
      "co.fs2"         %% "fs2-core"        % fs2Version,
      "org.typelevel"  %% "cats-core"       % catsVersion,
      "org.typelevel"  %% "cats-free"       % catsVersion,
      "org.typelevel"  %% "cats-effect"     % catsEffectVersion,
      "software.amazon.awssdk" % "aws-sdk-java" % awsVersion,
    ),
    generator.generate := generator.free.value
  )




def dependencies(modules: (String, List[ModuleID])*)(version: String): List[sbt.ModuleID] = modules.toMap.apply(version)
