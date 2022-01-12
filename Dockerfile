FROM openjdk:8-jdk-alpine
LABEL maintainer="Flavien ANNAIX, Maxime DAZIN"
RUN mkdir /data
RUN git clone https://github.com/Flav1-ann/springboot /data/springboot
WORKDIR /data/springboot
RUN mvn clean package install
WORKDIR /data/springboot/target
EXPOSE 8080
CMD ["catalina.sh", "run"]