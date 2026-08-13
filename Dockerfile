FROM eclipse-temurin:17-jre

WORKDIR /opt

EXPOSE 8080

COPY target/spring-boot-dockercompose.jar spring-boot-dockercompose.jar

ENTRYPOINT ["java", "-jar", "spring-boot-dockercompose.jar"]