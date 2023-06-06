FROM openjdk:17
EXPOSE 8080
COPY target/*.jar usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","usr/local/lib/app.jar"]