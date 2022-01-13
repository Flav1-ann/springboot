FROM openjdk:8-jdk-alpine

LABEL maintainer="Flavien ANNAIX, Maxime DAZIN"

RUN apk update && \
    apk upgrade && \
    apk add git && \
    apk add maven && \
    apk add bash

RUN mkdir /data

RUN git clone https://github.com/Flav1-ann/springboot /data/springboot

WORKDIR /data/springboot

RUN mvn clean package

WORKDIR /data/springboot/target

RUN ls
CMD ["java","-jar","./demo-springboot-0.0.1-SNAPSHOT.jar"]