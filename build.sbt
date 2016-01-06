//lazy val commonSettings = Seq()

name := "Hello World"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"


// should run from command line 
//coverageEnabled := true


// for jar building 
mainClass in compile := Some("HelloWorld")


// Rpm packaging 

enablePlugins(RpmPlugin)
enablePlugins(JavaAppPackaging)

rpmVendor in Rpm := "someVendor"

rpmLicense in Rpm := Some("Open License") 

rpmLicense := Some("MIT")

maintainer in Linux := "Team name"

// val runningUser = "prodicon" 

packageSummary in Linux := "Scala job 1"

packageDescription := "Scala job 2 "

defaultLinuxInstallLocation := "/opts/"

//name in Linux := "foonameinlinux" 





// (testOptions in Test) += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/xml.report")
// libraryDependencies += "org.pegdown" % "pegdown" % "1.5.0" % "test"


