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


// publish artifcat
publishTo := Some(Resolver.file("file",  new File( "dist/release" )) )




// Define a special test task which does not fail when any test fails,
// so sequential tasks (like SonarQube analysis) will be performed no matter the test result.
lazy val unitTests = taskKey[Unit]("Run unit tests")

unitTests := {
  // Capture the test result
 val testResult = (test in Test).result.value
}



// TODO should be name-branch-major-minor.jar 
// Git versioning 
enablePlugins(GitVersioning)


val VersionRegex = "v([0-9]+.[0-9]+.[0-9]+)-?(.*)?".r
git.gitTagToVersionNumber := {
  case VersionRegex(v,"") => Some(v)
  case VersionRegex(v,"SNAPSHOT") => Some(s"$v-SNAPSHOT")  
  case VersionRegex(v,s) => Some(s"$v-$s-SNAPSHOT")
  case _ => None
}


// (testOptions in Test) += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/xml.report")
// libraryDependencies += "org.pegdown" % "pegdown" % "1.5.0" % "test"

//  Sonar details 
enablePlugins(SonarRunnerPlugin)

sonarProperties ++= Map(
      "sonar.host.url" -> "http://192.168.150.21:9000",

      "sonar.projectKey" ->  "icala_Example_Build",
      "sonar.projectName" -> "icala :: Simple Project :: icala Example Build",
      //"sonar.projectVersion" -> "5.1.0",

      "sonar.sources" -> "src/main/scala",
      "sonar.tests" ->  "src/test/scala", 
      "sonar.scoverage.reportPath" -> "target/scala-2.11/scoverage-report/scoverage.xml"

      //"sonar.language" ->  "scala",
      //"sonar.core.codeCoveragePlugin" -> "scoverage",
      //"sonar.scala.cobertura.reportPath" ->  "./target/scala-2.11/coverage-report/cobertura.xml"
)

