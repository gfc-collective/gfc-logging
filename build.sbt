import scoverage.ScoverageKeys

name := "gfc-logging"

organization := "org.gfccollective"

scalaVersion := "2.12.14"

crossScalaVersions := Seq(scalaVersion.value, "2.13.6", "3.0.1")

scalacOptions += "-target:jvm-1.8"

scalacOptions ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((3, _)) =>
          Seq("-source:3.0-migration", "-explain", "-explain-types")
        case _ =>
          Nil
      }
    }

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

ScoverageKeys.coverageFailOnMinimum := true

ScoverageKeys.coverageMinimumStmtTotal := 18.0

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.31",
  "org.slf4j" % "slf4j-simple" % "1.7.31" % Test,
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

publishMavenStyle := true

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gfc-collective/gfc-logging/main/LICENSE"))

homepage := Some(url("https://github.com/gfc-collective/gfc-logging"))

pomExtra := (
  <developers>
    <developer>
      <id>gheine</id>
      <name>Gregor Heine</name>
      <url>https://github.com/gheine</url>
    </developer>
    <developer>
      <id>ebowman</id>
      <name>Eric Bowman</name>
      <url>https://github.com/ebowman</url>
    </developer>
    <developer>
      <id>andreyk0</id>
      <name>Andrey Kartashov</name>
      <url>https://github.com/andreyk0</url>
    </developer>
    <developer>
      <id>sullis</id>
      <name>Sean C. Sullivan</name>
      <url>https://github.com/sullis</url>
    </developer>
  </developers>
)
