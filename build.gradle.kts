plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "digital.patron"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // spring web
    implementation("org.springframework.boot:spring-boot-starter-web")
    // spring data jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // MySQL 데이터베이스 드라이버 의존성 추가
    implementation("com.mysql:mysql-connector-j")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
