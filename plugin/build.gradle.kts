dependencies {
  implementation(project(":api"))
  implementation(project(":nms:v1_20_R0"))

  implementation(reflectionLibrary)
  implementation(versionmatchedLibrary)
  implementation(configurateJacksonLibrary)

  compileOnly(paperApiLibrary)
  // https://mvnrepository.com/artifact/com.nukkitx/math
  implementation("com.nukkitx:math:1.1.1")
}

tasks {
  shadowJar {
    define()
    rootProject.findProperty("pluginsFolder")?.let {
      val path = it.toString()
      if (path.isNotEmpty() && path.isNotBlank()) {
        destinationDirectory.set(File(path))
      }
    }
  }

  build {
    dependsOn("shadowJar")
  }
}
