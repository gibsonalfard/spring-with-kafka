FROM openjdk:8-jdk-alpine

COPY target/spring-kafka-0.0.1-SNAPSHOT.jar /usr/src/spring-kafka-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "/usr/src/spring-kafka-0.0.1-SNAPSHOT.jar"]