import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "mailer-sample"
  val appVersion      = "1.0-SNAPSHOT"

  val studiodevRepo = Seq(
    "Studiodev repository releases" at "http://studiodev.github.io/mvn-repo/releases",
    "Studiodev repository snapshot" at "http://studiodev.github.io/mvn-repo/snapshots"
  )

  val appDependencies = Seq(
     "fr.studio-dev" %% "play-plugins-mailer" % "3.0.0"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers ++= studiodevRepo
  )

}
