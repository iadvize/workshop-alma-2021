name := "iadvize-rocket-api"

lazy val `iadvize-rocket-api` = (project in file("."))
  .enablePlugins(PlayScala, CalibanPlugin)
  .disablePlugins(PlayLayoutPlugin)

scalaVersion := "2.13.7"

libraryDependencies ++= Seq(
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % "test",
  "org.scalamock" %% "scalamock" % "5.1.0" % Test,
  guice
)
libraryDependencies += "com.github.ghostdogpr" %% "caliban-client" % "1.2.1"

