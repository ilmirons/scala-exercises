resolvers ++= Seq(
    Classpaths.typesafeResolver,
    "sonatype-releases" at  "https://oss.sonatype.org/content/repositories/releases/"
)

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.4.0")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.4.0")