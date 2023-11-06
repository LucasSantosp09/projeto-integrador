FROM openjdk:17
WORKDIR /app
COPY ./target/DigitalHouse-0.0.1-SNAPSHOT.jar /app/DigitalHouse-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/DigitalHouse-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
