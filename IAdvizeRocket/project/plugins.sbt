logLevel := Level.Warn

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.8")
addSbtPlugin("com.github.ghostdogpr" % "caliban-codegen-sbt" % "1.2.1")

