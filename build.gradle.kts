import org.gradle.api.internal.artifacts.dsl.dependencies.DependencyAdderExtensionModule.module

plugins {
    val kotlinVersion = "1.7.10"

    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"

    // ✅ KAPT(Kotlin Annotation Processing Tool)를 설치합니다
    kotlin("kapt") version kotlinVersion
    // ✅ Intellij에서 사용할 파일을 생성하는 플러그인입니다
    idea
}

group = "digital.patron"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

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

    // querydsl-jpa는 JPA(Java Persistence API)와의 통합을 제공
    implementation("com.querydsl:querydsl-jpa")
    // querydsl-apt는 컴파일 프로세스 중에 Q 클래스(쿼리 유형)를 생성하는 데 사용
    implementation("com.querydsl:querydsl-apt")
    // Javax Persistence API
    implementation("javax.persistence:javax.persistence-api:2.2")


}

tasks.withType<Test> {
    useJUnitPlatform()
}

// QueryDSL 플러그인을 구성하여 generated/querydsl 디렉토리에 Q 클래스를 생성합니다.
// 또한 필요한 종속성을 설정하고 QueryDSL 주석 프로세서를 Kotlin 컴파일 프로세스에 추가
// ✅ QClass를 Intellij가 사용할 수 있도록 경로에 추가합니다
idea {
    module {
        val kaptMain = file("$buildDir/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}