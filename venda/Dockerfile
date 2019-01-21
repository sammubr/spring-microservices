FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8092
ADD target/venda-1.0-SNAPSHOT.jar venda-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=container", "venda-1.0-SNAPSHOT.jar"]