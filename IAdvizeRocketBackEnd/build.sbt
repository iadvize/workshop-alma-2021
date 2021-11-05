name := "iadvize-rocket-api"

lazy val `iadvize-rocket-api` = (project in file("."))
  .enablePlugins(PlayScala, CalibanPlugin)
  .disablePlugins(PlayLayoutPlugin)

scalaVersion := "2.13.7"

libraryDependencies ++= Seq(
  specs2 % Test,
  guice
)
libraryDependencies += "com.github.ghostdogpr" %% "caliban-client" % "1.2.1"

