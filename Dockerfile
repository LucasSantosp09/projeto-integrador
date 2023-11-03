FROM maven:3.8.1-jdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/target/DigitalHouse-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "DigitalHouse-0.0.1-SNAPSHOT.jar"]
