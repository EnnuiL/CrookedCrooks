rootProject.name = "crooked_crooks"

pluginManagement {
	repositories {
		maven(uri("https://maven.fabricmc.net/"))
		gradlePluginPortal()
	}
}

include("mod_common", "mod_fabric", "mod_norge")
