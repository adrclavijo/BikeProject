FROM eclipse-temurin:17.0.6_10-jdk-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "application.jar"]