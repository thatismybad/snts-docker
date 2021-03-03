FROM amazoncorretto:11-alpine-jdk
COPY target/dockerapi.jar dockerapi.jar
ENTRYPOINT ["java", "-jar", "/dockerapi.jar"]