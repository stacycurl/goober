lazy val awsVersion           = "2.16.85"

libraryDependencies ++= Seq(
  "org.scala-sbt"          % "main_2.12"    % "1.4.3",
  "org.scala-sbt"          % "sbt"          % "1.4.3",
  "software.amazon.awssdk" % "aws-sdk-java" % awsVersion
)
