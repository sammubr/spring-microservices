FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8091
ADD target/produto-1.0-SNAPSHOT.jar produto-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container", "produto-1.0-SNAPSHOT.jar"]