name := "Play-Rest-Anorm"
 
version := "1.0" 
      
lazy val `play-rest-anorm` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "typesafe release" at "https://repo.typesafe.com/typesafe/releases"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test, guice, evolutions,
  "com.typesafe.play" %% "play-json" % "2.6.0",
  "com.typesafe.play" %% "anorm" % "2.5.3",
  "com.h2database" % "h2" % "1.4.196")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      