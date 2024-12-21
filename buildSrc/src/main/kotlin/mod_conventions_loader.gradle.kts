plugins {
	id("mod_conventions_common")
}

dependencies {
	compileOnly(project(":mod_common"))
}

sourceSets {
	main {
		java {
			srcDir(project(":mod_common").sourceSets.main.get().java)
		}

		resources {
			srcDir(project(":mod_common").sourceSets.main.get().resources)
		}
	}
}
