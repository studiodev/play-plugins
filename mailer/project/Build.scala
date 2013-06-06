import sbt._
import Keys._

import com.typesafe.sbt.SbtScalariform._
import scalariform.formatter.preferences._

object MinimalBuild extends Build {

  lazy val buildVersion = "2.1.1"
  lazy val playVersion = "2.1.1"

  lazy val typesafeSnapshot = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
  lazy val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  lazy val repo = if (buildVersion.endsWith("SNAPSHOT")) typesafeSnapshot else typesafe  
  
  lazy val root = Project(id = "play-plugins-mailer", base = file("."), settings = Project.defaultSettings ++ defaultScalariformSettings).settings(
    version := buildVersion,
    scalaVersion := "2.10.0",
    publishTo <<= (version) { version: String =>
                val nexus = "http://typesafe.artifactoryonline.com/typesafe/"
                if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "maven-snapshots/")
                else                                   Some("releases"  at nexus + "maven-releases/")
    },
    organization := "fr.studio-dev",
    resolvers += repo,
    javacOptions ++= Seq("-source","1.6","-target","1.6", "-encoding", "UTF-8"),
    javacOptions += "-Xlint:unchecked",
    libraryDependencies += "play" %% "play" % playVersion % "provided",
    libraryDependencies += "org.apache.commons" % "commons-email" % "1.2"
  )
}

