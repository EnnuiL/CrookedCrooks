plugins {
	id("mod_conventions_loader")
	alias(libs.plugins.fabric.loom)
}

base.archivesName = "crooked_crooks-fabric"

repositories {
	maven("https://maven.terraformersmc.com/releases")
}

dependencies {
	minecraft(libs.minecraft)

	mappings(loom.layered {
		officialMojangMappings()
		parchment(libs.parchment)
	})
	modImplementation(libs.fabric.loader)

	modImplementation(libs.fabric.api)

	modImplementation(libs.modmenu)
}

loom {
	mods {
		register("crooked_crooks") {
			sourceSet("main")
		}
	}

	mixin {
		useLegacyMixinAp = false
	}

	fabricApi {
		configureDataGeneration {
			client = true
		}
	}

	runs {
		named("client") {
			client()
			ideConfigGenerated(true)
			runDir("run")
		}

		named("datagen") {
			ideConfigGenerated(true)
			runDir("build/datagen")
		}
	}
}

tasks.named<ProcessResources>("processResources").configure {
	val version = project.version
	inputs.property("version", version)

	filesMatching("fabric.mod.json") {
		expand("version" to version)
	}
}
