name := "SbtWithCI"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies += "junit" % "junit" % "4.12" % Test
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test

