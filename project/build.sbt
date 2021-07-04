lazy val awsVersion           = "2.16.85"

libraryDependencies ++= Seq(
  "org.scala-sbt"          % "main_2.12"    % "1.4.3",
  "org.scala-sbt"          % "sbt"          % "1.4.3",
  "org.reflections"        % "reflections"  % "0.9.12",
  "software.amazon.awssdk" % "aws-sdk-java" % awsVersion
)
