name := """top"""
version := "0.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

scalaVersion in ThisBuild := "2.11.11" 

lazy val top = (project in file("."))
