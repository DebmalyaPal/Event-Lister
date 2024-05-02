name := """event-lister-backend"""
organization := "com.events"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.13"


val h2Version = "1.4.192"


libraryDependencies ++= Seq(
  guice,
  //"org.scalatestplus.play" % "scalatestplus-play" % "7.0.0" % Test,
  "com.h2database" % "h2" % h2Version,
  evolutions,
  jdbc
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.events.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.events.binders._"
