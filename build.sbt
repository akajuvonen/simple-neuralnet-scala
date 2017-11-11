import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.akajuvonen",
      scalaVersion := "2.11.8",
      version      := "0.9"
    )),
    name := "neuralnet_scala",
    libraryDependencies += scalaTest % Test
  )
