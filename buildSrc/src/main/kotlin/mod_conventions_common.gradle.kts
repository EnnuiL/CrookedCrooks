plugins {
	id("java-library")
	id("maven-publish")
}

repositories {
	maven("https://maven.parchmentmc.org")
}

java {
	withSourcesJar()
	// TODO - Resurrect the version getter method
}

project.version = System.getenv("TAG") ?: "0.0.0-development"
project.group = "io.github.ennuil.crooked_crooks"

tasks.withType<JavaCompile> {
	options.release = 21
}

tasks.named<Jar>("jar").configure {
	val name = project.name
	inputs.files("LICENSE.md")
	inputs.property("name", name)

	from("LICENSE.md") {
		rename { "LICENSE_${name}.md" }
	}
}

publishing {
	publications {
		register<MavenPublication>("mavenJava_${project.name}") {
			from(components["java"])
		}
	}

	repositories {
		val uploadUrl = System.getenv("MAVEN_UPLOAD_URL")
		if (uploadUrl != null) {
			maven {
				url = uri(uploadUrl)
				credentials {
					username = System.getenv("MAVEN_UPLOAD_USERNAME")
					password = System.getenv("MAVEN_UPLOAD_PASSWORD")
				}
			}
		}
	}
}
