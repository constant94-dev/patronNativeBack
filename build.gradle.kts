plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}

group = "digital.patron"
version = "0.0.1-SNAPSHOT"
java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(annotationProcessor.get())
    }
    querydsl.extendsFrom(compileClasspath.get())
}

repositories {
    mavenCentral()
}

dependencies {
    val queryDslVersion = "5.0.0"
    val p6spyVersion = "1.9.0"

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // spring web
    implementation("org.springframework.boot:spring-boot-starter-web")
    // spring data jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // MySQL 데이터베이스 드라이버 의존성 추가
    implementation("com.mysql:mysql-connector-j")
    // p6spy 쿼리 파라미터 로그 남기기
    //implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:${p6spyVersion}")

    // querydsl-jpa는 JPA(Java Persistence API)와의 통합을 제공
    implementation("com.querydsl:querydsl-jpa:${queryDslVersion}:jakarta")
    // querydsl-apt는 컴파일 프로세스 중에 Q 클래스(쿼리 유형)를 생성하는 데 사용
    annotationProcessor("com.querydsl:querydsl-apt:${queryDslVersion}:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

val generatedQuerydsl = "src/main/generated"
val excludedQuerydsl = "$buildDir/generated/querydsl"

querydsl {
    jpa = true
    querydslDefault = true
    querydslSourcesDir = generatedQuerydsl
}

sourceSets {
    main {
        java {
            srcDirs(generatedQuerydsl)
        }
    }
}

tasks {
    test {
        testLogging.showExceptions = true
        useJUnitPlatform()
    }
    compileQuerydsl {
        options.annotationProcessorPath = configurations.querydsl.get()
    }
    withType<JavaCompile> {
        options.annotationProcessorGeneratedSourcesDirectory = file(excludedQuerydsl)
    }
    named<Delete>("clean") {
        dependsOn("cleanGeneratedFiles")
    }
    register<Delete>("cleanGeneratedFiles") {
        delete("src/main/generated")
    }
}