name := "iadvize-rocket-api"

version := "1.0"

lazy val `test` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"

scalaVersion := "2.13.7"

libraryDependencies ++= Seq(jdbc, ehcache, ws, specs2 % Test, guice)
libraryDependencies += "com.github.ghostdogpr" %% "caliban-client" % "1.2.1"

enablePlugins(CalibanPlugin)
