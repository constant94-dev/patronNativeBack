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
    val queryDslVersion = "5.0.0"

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
    implementation("com.querydsl:querydsl-jpa:${queryDslVersion}:jakarta")
    // querydsl-apt는 컴파일 프로세스 중에 Q 클래스(쿼리 유형)를 생성하는 데 사용
    annotationProcessor("com.querydsl:querydsl-apt:${queryDslVersion}:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
}

tasks.withType<Test> {
    useJUnitPlatform()
}