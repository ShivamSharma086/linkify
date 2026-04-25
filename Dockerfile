FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY linkify/pom.xml ./pom.xml
COPY linkify/src ./src
COPY linkify/mvnw ./mvnw
COPY linkify/.mvn ./.mvn

RUN mvn clean package -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]