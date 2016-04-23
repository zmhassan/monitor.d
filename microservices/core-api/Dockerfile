FROM docker.io/java:8-jdk-alpine

MAINTAINER Zak Hassan zak.hassan1010@gmail.com

RUN mkdir -p /app
WORKDIR /app
ADD ./target/mond-core-1.0.0-SNAPSHOT.jar /app

EXPOSE 8181 

ENTRYPOINT ["java","-jar", "mond-core-1.0.0-SNAPSHOT.jar", "--server.port=8181"]
