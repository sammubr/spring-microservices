FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/gateway-1.0-SNAPSHOT.jar gateway-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container", "gateway-1.0-SNAPSHOT.jar"]