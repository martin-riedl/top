libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

lazy val root = (project in file("."))
  .settings(
    name := "top",
    scalaVersion := "2.12.1"
  )
