FROM openjdk:8-jdk-alpine
VOLUME /tmp

ADD /target/electric-service-1.0-SNAPSHOT.jar electric-service.jar
RUN sh -c 'touch /sabb-backend.jar'

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.config.location=tmp/application.yml","-jar","/electric-service.jar"]