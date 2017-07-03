name := """TOP"""
version := "0.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

scalaVersion in ThisBuild := "2.12.1" 

lazy val root = (project in file("."))
