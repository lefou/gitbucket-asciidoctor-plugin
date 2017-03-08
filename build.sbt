val Organization = "com.github.lefou"
// Don't forget to also update src/main/scala/Plugin.scala
val Version = "1.0.2"

val ScalaVersion = "2.12.1"

val GitBucketVersion = "4.10"
val GitBucketAssembly = "io.github.gitbucket" %% "gitbucket" % s"${GitBucketVersion}.0"
val JavaOptions = Seq("-target", "8", "-source", "8")

val Name = s"gitbucket-${GitBucketVersion}-asciidoctor-plugin"


lazy val root = (project in file(".")).
  settings(
    sourcesInBase := false,
    organization := Organization,
    name := Name,
    version := Version,
    scalaVersion := ScalaVersion,
    scalacOptions := Seq("-deprecation", "-language:postfixOps"),
    resolvers ++= Seq(
      "amateras-repo" at "http://amateras.sourceforge.jp/mvn/"
    ),
    libraryDependencies ++= Seq(
      GitBucketAssembly % "provided",
      "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
      "org.asciidoctor" % "asciidoctorj" % "1.5.4",
      "net.sourceforge.htmlcleaner" % "htmlcleaner" % "2.16"
    ),
    javacOptions in compile ++= JavaOptions,

    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

  )
