FROM openjdk:17

WORKDIR /app

COPY target/linkify-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dserver.port=8080","-jar","app.jar"]