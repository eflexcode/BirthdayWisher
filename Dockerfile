FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar BirthdayWisher.jar
ENTRYPOINT ["java","-jar","/BirthdayWisher.jar"]
EXPOSE 8080