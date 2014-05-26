name := "gfc-time"

organization := "com.gilt"

scalaVersion := "2.10.4"

crossScalaVersions := Seq("2.10.4", "2.9.1", "2.9.2", "2.9.3")

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.testng" % "testng" % "6.0" % "test",
  "org.scalatest" %% "scalatest" % "1.9.2" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test" 
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gilt/gfc-time/master/LICENSE"))

homepage := Some(url("https://github.com/gilt/gfc-time"))

pomExtra := (
  <scm>
    <url>https://github.com/gilt/gfc-time.git</url>
    <connection>scm:git:git@github.com:gilt/gfc-time.git</connection>
  </scm>
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
  </developers>
)

