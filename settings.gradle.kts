pluginManagement {
  repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
    mavenLocal()
    gradlePluginPortal()
  }
}

rootProject.name = "FakePlayer"

include("api")

include("nms")
include("nms:v1_20_R0")

include("plugin")
