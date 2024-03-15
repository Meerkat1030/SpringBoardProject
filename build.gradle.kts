plugins {
	java
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.springio"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.7")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	compileOnly("org.projectlombok:lombok:1.18.20")
	annotationProcessor("org.projectlombok:lombok:1.18.20")
	implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
	implementation ("org.springframework.boot:spring-boot-starter-jdbc")
	runtimeOnly ("com.h2database:h2")
	compileOnly("org.springframework.boot:spring-boot-devtools")
//	implementation("io.openliberty:openliberty-bom:23.0.0.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
