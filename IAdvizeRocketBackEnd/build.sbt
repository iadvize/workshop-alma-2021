

lazy val `iadvize-rocket-api` = (project in file("."))
  .enablePlugins(PlayScala, CalibanPlugin)
  .disablePlugins(PlayLayoutPlugin)
  .settings(
    name := "iadvize-rocket-api",
    scalaVersion := "2.13.7",
    libraryDependencies ++= Seq(
      guice,
      "com.github.ghostdogpr" %% "caliban-client" % "1.2.2"
    ),
    libraryDependencies ++= Seq(
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
      "org.scalamock" %% "scalamock" % "5.1.0" % Test
    ),
    Compile / doc / sources := Seq.empty,
    Compile / packageDoc / publishArtifact := false
  )




