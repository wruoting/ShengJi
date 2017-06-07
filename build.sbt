import sbt._
import sbt.Keys._
name := "ShengJi"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-swing" % "2.10+"
)

unmanagedBase := baseDirectory.value/"lib"

//fork to JVM
fork := true

// add a JVM option to use when forking a JVM for 'run'
javaOptions += "-Djava.library.path=./lib/native/windows"

javaHome := Some(file("E:/Java"))
