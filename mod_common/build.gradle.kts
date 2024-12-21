plugins {
	id("mod_conventions_common")
	alias(libs.plugins.fabric.loom)
}

dependencies {
	minecraft(libs.minecraft)

	mappings(loom.layered {
		officialMojangMappings()
		parchment(libs.parchment)
	})
	modImplementation(libs.fabric.loader)
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
}
