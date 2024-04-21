plugins {
  id("io.papermc.paperweight.userdev") version "1.5.3"
}

repositories {
  maven("https://repo.opencollab.dev/maven-releases")
  maven("https://repo.opencollab.dev/maven-snapshots")
}

dependencies {
  paperDevBundle("1.20.3-R0.1-SNAPSHOT")

//  implementation(files("..\\..\\libs\\mcprotocollib-1.20-1.jar"))
  implementation("com.github.steveice10:mcprotocollib:1.20.3-1-SNAPSHOT")

//  implementation("com.github.steveice10:mcprotocollib:1.19.2-1") {
//    exclude("net.kyori:adventure-text-serializer-gson")
//    exclude("io.netty")
//    exclude("io.netty.incubator")
//    exclude("org.junit")
//    exclude("com.google.code.gson")
//    exclude("com.github.spotbugs")
//  }
}
