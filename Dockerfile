FROM openjdk:21
VOLUME /tmp
COPY target/*.jar BirthdayWisher.jar
ENTRYPOINT ["java","-jar","/BirthdayWisher.jar"]
EXPOSE 8080