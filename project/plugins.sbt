libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

addSbtPlugin("com.github.sbt"       % "sbt-pgp"      % "2.1.2")
addSbtPlugin("com.typesafe.sbt"     % "sbt-git"      % "1.0.1")
addSbtPlugin("org.xerial.sbt"       % "sbt-sonatype" % "3.9.7")
addSbtPlugin("com.github.stacycurl" % "sbt-tcr"      % "1.0.1")

scalacOptions += "-deprecation"
