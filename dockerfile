FROM openjdk:11-jdk-slim
COPY target/ring-0.0.1-SNAPSHOT.jar cakeapi.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/cakeapi.jar"]
