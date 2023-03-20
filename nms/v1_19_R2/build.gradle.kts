plugins {
  id("io.papermc.paperweight.userdev") version "1.5.3"
}

dependencies {
  paperDevBundle("1.19.3-R0.1-SNAPSHOT")

  implementation("com.github.steveice10:mcprotocollib:1.19.2-1") {
    exclude("net.kyori:adventure-text-serializer-gson")
    exclude("io.netty")
    exclude("io.netty.incubator")
    exclude("org.junit")
    exclude("com.google.code.gson")
    exclude("com.github.spotbugs")
  }
}