//lazy val commonSettings = Seq()

name := "Hello World"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"


//coverageEnabled := true

// (testOptions in Test) += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/xml.report")
// libraryDependencies += "org.pegdown" % "pegdown" % "1.5.0" % "test"


