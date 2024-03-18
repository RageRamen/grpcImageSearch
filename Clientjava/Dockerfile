FROM openjdk:11-jre
FROM maven:3.8.4-openjdk-11 AS builder

WORKDIR /app

COPY target/Clientjava-0.0.1-SNAPSHOT.jar /app/Clientjava.jar

#RUN mvn exec:java -Dexec.mainClass="ImageSearchClient"

CMD ["java", "-jar", "/app/Clientjava.jar"]