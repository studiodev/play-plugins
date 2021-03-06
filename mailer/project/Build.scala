import sbt._
import Keys._

object MinimalBuild extends Build {

  lazy val buildName = "play-plugins-mailer"
  lazy val buildVersion = "3.0.3"
  lazy val playVersion = "2.3.0-RC2"

  lazy val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

  lazy val root = Project(id = buildName, base = file("."), settings = Project.defaultSettings).settings(
    version := buildVersion,
    scalaVersion := "2.11.0",
    publishTo <<= version { (version: String) =>
      val localPublishRepo = "/Users/julienlafont/Travail/perso/mvn-repo"
      if (version.trim.endsWith("SNAPSHOT"))
        Some(Resolver.file("snapshots", new File(localPublishRepo + "/snapshots")))
      else
        Some(Resolver.file("releases", new File(localPublishRepo + "/releases")))
    },
    organization := "fr.studio-dev",
    javacOptions ++= Seq("-source","1.6","-target","1.6", "-encoding", "UTF-8"),
    javacOptions += "-Xlint:unchecked",
    libraryDependencies += "com.typesafe.play" %% "play" % playVersion % "provided",
    libraryDependencies += "org.apache.commons" % "commons-email" % "1.3"
  )
}

