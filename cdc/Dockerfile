FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:17-alpine

WORKDIR /app

COPY --from=build /app/target/cdc-0.0.1-SNAPSHOT.jar .


CMD ["java", "-jar", "cdc-0.0.1-SNAPSHOT.jar"]