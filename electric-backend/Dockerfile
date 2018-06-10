FROM openjdk:8-jdk-alpine
VOLUME /tmp

ARG JAR_FILE
ADD ${JAR_FILE} electric-service.jar

EXPOSE 8080

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /electric-service.jar