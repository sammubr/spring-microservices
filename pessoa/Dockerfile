FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8090
ADD target/pessoa-1.0-SNAPSHOT.jar pessoa-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container", "pessoa-1.0-SNAPSHOT.jar"]