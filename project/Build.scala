import sbt._
import Process._
import Keys._

object ExercisesBuild extends Build {
    
    val ns       = "com.altervista.mirons"
    val scalaVer = "2.10.4"
    
    lazy val exercises = Project(
        id       = "exercises",
        base     = file("."),
        settings = Project.defaultSettings ++ Seq(
            name         := "exercises",
            organization := ns,
            version      := "0.7",
            scalaVersion := scalaVer
        )
    )
    
    lazy val nQueen  = Project(
        id       = "nQueens",
        base     = file("nQueens"),
        settings = Project.defaultSettings ++ Seq(
            name         := "nQueens",
            organization := ns,
            version      := "0.9",
            scalaVersion := scalaVer,
            libraryDependencies ++= Seq(
                "org.scalatest" %% "scalatest" % "2.1.0" % "test"
            )
        )
    )
    
    exercises aggregate(nQueen)

}