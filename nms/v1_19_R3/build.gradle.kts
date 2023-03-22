plugins {
  id("io.papermc.paperweight.userdev") version "1.5.3"
}

dependencies {
  paperDevBundle("1.19.3-R0.1-SNAPSHOT")

  implementation(files("C:/Bamtang/mcserver/fakeplayer/libs/mcprotocollib-1.19.3-SNAPSHOT.jar"))
  implementation("com.github.GeyserMC:opennbt:1.4")
  implementation("com.github.GeyserMC:mcauthlib:6f3d6aada5")

//  implementation("com.github.steveice10:mcprotocollib:1.19.2-1") {
//    exclude("net.kyori:adventure-text-serializer-gson")
//    exclude("io.netty")
//    exclude("io.netty.incubator")
//    exclude("org.junit")
//    exclude("com.google.code.gson")
//    exclude("com.github.spotbugs")
//  }
}
